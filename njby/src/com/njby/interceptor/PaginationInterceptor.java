package com.njby.interceptor;

import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;   
import com.njby.utils.Pageable;
import com.system.ananotation.reflection.ReflectUtil;


/**
 * 分页技术说明:
 * 1、为什么需要分页？
 * 数据过多，一页内无法显示，所以需要分页显示
 * 
 * 2、分页技术实现：两种物理分页和逻辑分页
 * 物理分页：在数据库执行查询时（实现分页查询），查询需要的数据 ---- 依赖数据库SQL语句，属于后台分页
 * 逻辑分页：先查询所有数据到内存，再从内存截取需要数据 ------- 采用程序内部逻辑，属于前台分页
 * 
 * 物理分页：Mysql /SQLServer / Oracle 每种数据库写法不同的  
 * mysql 使用limit ，SQLServer 使用top ，Oracle使用rowNum 
 * 
 * limit语法 ： select .... limit 开始记录索引,记录条数
 * 例如：select * from tablename limit 10,20; // 注意索引是从0开始的，因此10代表第11条数据 ------ 20代表从第11条开始的20条数据，即从第11条到第30条。
 * 
 * 逻辑分页：查询所有数据 List, list.subList 截取你需要数据
 * 例如：查询第11到第30条数据 list.subList(开始索引,结束索引); // 前取到，后取不到 ----- list.subList(10,30);
 * 
 * 性能上 ：物理分页好于逻辑分页 ---- 尽量使用物理分页
 * 
 * @author Administrator
 *
 */


@Intercepts({@Signature(type = StatementHandler.class, 
						method = "prepare", 
						args = {Connection.class})})
public class PaginationInterceptor implements Interceptor{

	private static final Log logger = LogFactory.getLog(PaginationInterceptor.class);
	
	//数据库类型，不同的数据库有不同的分页方法
	private String databaseType;  
	
	private String pagePattern;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		 RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();   
	     StatementHandler delegate = (StatementHandler)ReflectUtil.getFieldValue(handler, "delegate");      
	     MappedStatement mappedStatement = (MappedStatement)ReflectUtil.getFieldValue(delegate, "mappedStatement");     
	     //满足SQL分页条件
	     if (mappedStatement.getId().matches(pagePattern)) { 
		     BoundSql boundSql = delegate.getBoundSql();   
	    	 Object paramObj = boundSql.getParameterObject();
	    	 if (paramObj == null) {  
	    		 throw new NullPointerException("parameterObject is null!"); 
	    	 } else {
	    		 Pageable page = null;
	    		 if (paramObj instanceof Pageable) //只有一个参数的情况 
	    			 page = (Pageable)paramObj;  
	    	     else if (paramObj instanceof Map){ //多参数的情况，找到第一个Page的参数 
	    	    	 for (Map.Entry<String, Object> e : ((Map<String, Object>)paramObj).entrySet()){  
	    	    		 if (e.getValue() instanceof Pageable){  
	    	    			 page = (Pageable)e.getValue();  
	    	                 break;  
	    	             }  
	    	         }  	 
	    	     }
    	    	 Connection connection = (Connection)invocation.getArgs()[0];
    	    	 String sql = boundSql.getSql();
    	    	 this.setTotalRecord(paramObj, page, mappedStatement, connection);
    	    	 String pageSql = this.getPageSql(page, sql);
    	    	 ReflectUtil.setFieldValue(boundSql, "sql", pageSql);	    		 
	    		
	    	 }
	    	 
	     }
	     	     
	     return invocation.proceed();
	}

	/**
	 * 拦截器对应的封装原始对象的方法
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this); 
	}

	/**
	 * 设置注册拦截器时设定的属性
	 */
	@Override
	public void setProperties(Properties properties) {
		this.databaseType = properties.getProperty("databaseType");
		this.pagePattern = properties.getProperty("pagePattern");
	}
	
	
	 /**  
     * 根据page对象获取对应的分页查询Sql语句，
     * 这里只做了两种数据库类型，Mysql和Oracle  
     * 其它的数据库都 没有进行分页  
     *  
     * @param page 分页对象  
     * @param sql 原sql语句  
     * @return  
     */  
    private String getPageSql(Pageable page, String sql) {   
       StringBuffer sqlBuffer = new StringBuffer(sql);   
       if ("mysql".equalsIgnoreCase(databaseType)) {   
           return getMysqlPageSql(page, sqlBuffer);   
       } else if ("oracle".equalsIgnoreCase(databaseType)) {   
           return getOraclePageSql(page, sqlBuffer);   
       }   
       return sqlBuffer.toString();   
    }   
    
    /**  
     * 获取Mysql数据库的分页查询语句  
     * @param page 分页对象  
     * @param sqlBuffer 包含原sql语句的StringBuffer对象  
     * @return Mysql数据库分页语句  
     */  
    private String getMysqlPageSql(Pageable page, StringBuffer sqlBuffer) {    
       int offset = (page.getPageNumber() - 1) * page.getPageSize();   
       sqlBuffer.append(" limit ").append(offset).append(",").append(page.getPageSize());   
       return sqlBuffer.toString();   
    }   
      
    /**  
     * 获取Oracle数据库的分页查询语句  
     * @param page 分页对象  
     * @param sqlBuffer 包含原sql语句的StringBuffer对象  
     * @return Oracle数据库的分页查询语句  
     */  
    private String getOraclePageSql(Pageable page, StringBuffer sqlBuffer) {    
       int offset = (page.getPageNumber() - 1) * page.getPageSize() + 1;   
       sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(offset + page.getPageSize());   
       sqlBuffer.insert(0, "select * from (").append(") where r >= ").append(offset);   
       return sqlBuffer.toString();   
    }   
    
    /**  
     * 给当前的参数对象page设置总记录数  
     *  
     * @param page Mapper映射语句对应的参数对象  
     * @param mappedStatement Mapper映射语句  
     * @param connection 当前的数据库连接  
     */  
    private void setTotalRecord(Object paramObj, Pageable page, 
           MappedStatement mappedStatement, Connection connection) {     
       BoundSql boundSql = mappedStatement.getBoundSql(paramObj);   
       String sql = boundSql.getSql();   
       String countSql = this.getCountSql(sql);   
       List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();   
       BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, paramObj);   
       ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, paramObj, countBoundSql);   
       PreparedStatement pstmt = null;   
       ResultSet rs = null;   
       try {   
           pstmt = connection.prepareStatement(countSql);   
           parameterHandler.setParameters(pstmt);   
           rs = pstmt.executeQuery();   
           if (rs.next()) {   
              int totalRecord = rs.getInt(1);   
              page.setTotal(totalRecord);   
           }   
       } catch (SQLException e) {   
           e.printStackTrace();   
       } finally {   
           try {   
              if (rs != null)   
                  rs.close();   
               if (pstmt != null)   
                  pstmt.close();   
           } catch (SQLException e) {   
              e.printStackTrace();   
           }   
       }   
    }   
      
    /**  
     * 根据原Sql语句获取对应的查询总记录数的Sql语句  
     * @param sql  
     * @return  
     */  
    private String getCountSql(String sql) {   
       int index = sql.indexOf("from");   
       return "select count(*) " + sql.substring(index);   
    }       
    
}
