package generate;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;


/**
 * @author pez1420(pez1420@163.com)
 * @date 2015-08-11
 */
@SuppressWarnings("unchecked")
public class BeanUtils {
	

	
	//公共部分
	private static final String RT_1 = "\r\n";
	private static final String RT_2 = RT_1+RT_1;
	private static final String BLANK_1 =" ";
	private static final String BLANK_4 ="    ";
	private static final String BLANK_8 =BLANK_4 + BLANK_4;
	private static final String BLANK_12 =BLANK_8 + BLANK_4;
	
	
	//注释部分
	private static final String ANNOTATION_AUTHOR_PARAMTER = "@pez1420 ";
	private static final String ANNOTATION_AUTHOR_NAME = "pez1420(pez1420@163.com)";
	private static final String ANNOTATION_AUTHOR = ANNOTATION_AUTHOR_PARAMTER + ANNOTATION_AUTHOR_NAME;
	private static final String ANNOTATION_DATE = "@date ";
	private static final String ANNOTATION = "/**"+RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_AUTHOR +RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_DATE +getDate()+RT_1+BLANK_1+"*/"+RT_1;
	
	private static final String BS_PATH = "com/njby";
	private static final String BS_URL = "com.njby";
	
	//文件 地址
	//private static final String BEAN_PATH = "com/b510/base/bean";
	private static final String DAO_PATH = BS_PATH+"/dao";
	//private static final String DAO_IMPL_PATH = "com/b510/base/dao/impl";
	private static final String SERVICE_PATH = BS_PATH+"/service";
	private static final String SERVICE_IMPL_PATH = BS_PATH+"/service/impl";
	private static final String CONTROLLER_PATH = BS_PATH+"/controller" + "/admin";
	private static final String MAPPER_PATH = "mapper";
	private static final String SEARCH_ENTITY_PATH = BS_PATH + "/entity/search";
	
	
	//包名
	private static final String BEAN_URL = BS_URL+".entity";
	private static final String DAO_URL = BS_URL+".dao";
	private static final String CONTROLLER_URL = BS_URL+".controller";
	private static final String SEARCH_ENTITY_URL = BEAN_URL+".search";
	//private static final String DAO_IMPL_URL = BS_URL+".impl";
	private static final String SERVICE_URL = BS_URL+".service";
	private static final String SERVICE_IMPL_URL = BS_URL+".service.impl";

	//基本类名称
	private static final String BASE_DAO_NAME = "com.njby.dao.BaseDao";
	//private static final String ABSTRACT_BASE_DAO_IMPL_NAME = DAO_IMPL_URL + ".AbstractBaseDaoImpl";
	private static final String BASE_SERVICE_NAME = SERVICE_URL + ".BaseService";
	private static final String ABSTRACT_BASE_SERVICE_IMPL_NAME = SERVICE_IMPL_URL + ".BaseServiceImpl";
	
	
	//框架名称
	private static final String IMPORT_SOURCE = "import javax.annotation.Resource;";
	private static final String IMPORT_SERVICE = "import org.springframework.stereotype.Service;";

	
	/**
	 * 创建bean的Mapper文件<br>
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanXml(Class c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + MAPPER_PATH
				+ "/" + getLastChar(cName) + "Mapper.xml";
		File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}
		
		FileWriter fw = new FileWriter(f);
		fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" + RT_1 
				+ "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >" 
				+ RT_2 + "<mapper namespace=\"" + DAO_URL + "." + getLastChar(cName) + "Dao" + "\">" + RT_1
				
				+ BLANK_4 + "<sql id=\"Table_Name\">" + RT_1
				+ BLANK_8 + GenerateUtils.hump2underline(getLastChar(cName)) + RT_1
				+ BLANK_4 + "</sql>" + RT_2
				
				+ BLANK_4 + "<sql id=\"Db_Time\">" + RT_1
				+ BLANK_8 + "now()" + RT_1
				+ BLANK_4 + "</sql>" + RT_2
				
				+ BLANK_4 + "<sql id=\"UUID\">" + RT_1
				+ BLANK_8 + "select replace(uuid(),'-','')" + RT_1
				+ BLANK_4 + "</sql>" + RT_2

				+ BLANK_4 + "<resultMap id=\""+ getLastChar(cName) + "Map" + "\" type=\""+getLastChar(cName)+"\">" + RT_1
				+ BLANK_8  + RT_1
				+ BLANK_4 + "</resultMap>" + RT_2
				
				
				+ BLANK_4 + "<insert id=\"save\" parameterType=\""+ getLastChar(cName)+ "\">" + RT_1
				+ BLANK_8 + "<selectKey keyProperty=\"id\" resultType=\"String\" order=\"BEFORE\">" + RT_1
				+ BLANK_12 + "<include refid=\"UUID\" />" + RT_1
				+ BLANK_8 + "</selectKey>" + RT_1
				+ BLANK_4 + "</insert>" + RT_2
				
				+ BLANK_4 + "<update id=\"update\" parameterType=\"" + getLastChar(cName)+ "\">" + RT_1
				+ BLANK_8 + RT_1
				+ BLANK_4 + "</update>" + RT_2

				+ BLANK_4 + "<select id=\"find\" resultMap=\""+ getLastChar(cName) + "Map" + "\" parameterType=\"java.lang.String\">" + RT_1
				+ BLANK_8 + RT_1
				+ BLANK_4 + "</select>" + RT_2

				+ BLANK_4 + "<select id=\"count\" resultType=\"long\">" + RT_1
				+ BLANK_12 + "select count(*) from " + RT_1
				+ BLANK_12 + "<include refid=\"Table_Name\" />" + RT_1
				+ BLANK_4 + "</select>" + RT_2

				+ BLANK_4 + "<select id=\"findPage\" resultMap=\""+ getLastChar(cName) + "Map" + "\" parameterType=\"map\">" + RT_1
				+ BLANK_8 + "select * from <include refid=\"Table_Name\" /> " + RT_1
				+ BLANK_8 + "<trim prefix=\"where\" prefixOverrides=\"and|or\">" + RT_1
				+ BLANK_8 + "</trim>" + RT_1
				+ BLANK_4 + "</select>" + RT_2
				
				
				+ "</mapper>");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}
	
	/**
	 * 创建bean的Controller<br>
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanController(Class c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + CONTROLLER_PATH
				+ "/" + getLastChar(cName) + "Controller.java";
		File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}
		
		FileWriter fw = new FileWriter(f);
		fw.write("package "+CONTROLLER_URL+";"+RT_2 
				+ANNOTATION+"public class " + getLastChar(cName) 
				+ "Controller extends BaseAdminController " + "{"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}


	public void createBeanSearchEntity(Class c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + SEARCH_ENTITY_PATH
				+ "/" + "Search" + getLastChar(cName) + ".java";
		File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}
		
		FileWriter fw = new FileWriter(f);
		fw.write("package "+SEARCH_ENTITY_URL+";"+RT_2 
				+ "import java.io.Serializable;" + RT_2
				+ ANNOTATION + "public class " + "Search" + getLastChar(cName) 
				+ " implements Serializable " + "{"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}
	

	/**
	 * 创建bean的Dao<br>
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanDao(Class c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + DAO_PATH
				+ "/" + getLastChar(cName) + "Dao.java";
		File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}
		
		FileWriter fw = new FileWriter(f);
		fw.write("package "+DAO_URL+";"+RT_2 + "import "+BASE_DAO_NAME+";"
				+RT_1+"import "+BEAN_URL+"."+getLastChar(cName)+";"
				+RT_2+ANNOTATION+"public interface " + getLastChar(cName) 
				+ "Dao extends BaseDao <" + getLastChar(cName) + ", String> {"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}	
	
 
    /**
     * 创建bean的service
     * @param c
     * @throws Exception
     */
    public void createBeanService(Class c) throws Exception{
    	String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + SERVICE_PATH
				+ "/" + getLastChar(cName) + "Service.java";
		File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}		

		FileWriter fw = new FileWriter(f);
		fw.write("package "+SERVICE_URL+";"+RT_2+ "import "+BASE_SERVICE_NAME+";"
				+RT_1+"import "+BEAN_URL+"."+getLastChar(cName)+";"
				+RT_2+ANNOTATION+"public interface "+getLastChar(cName)
				+"Service extends BaseService<"+ getLastChar(cName) +", String>{"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
    }
    
    /**
     * 创建bean的service的实现类
     * @param c
     * @throws Exception
     */
    public void createBeanServiceImpl(Class c) throws Exception{
    	String cName = c.getName();
    	String fileName = System.getProperty("user.dir") + "/src/" + SERVICE_IMPL_PATH 
    			+ "/" +getLastChar(cName)+"ServiceImpl.java";
    	File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}
		
    	FileWriter fw = new FileWriter(f);
    	fw.write("package "+SERVICE_IMPL_URL+";"+ RT_2 + IMPORT_SOURCE
    			+ RT_2 + IMPORT_SERVICE + RT_2 + "import "+BEAN_URL+"."+getLastChar(cName)+";"
    			+ RT_1 + "import "+ABSTRACT_BASE_SERVICE_IMPL_NAME+";"
    			+ RT_1 + "import "+SERVICE_URL+"."+getLastChar(cName)+"Service"+";"
    			+ RT_1 + "import "+DAO_URL+"."+getLastChar(cName)+"Dao"+";"
    			+ RT_2+ANNOTATION+"@Service"+RT_1+"public class " + getLastChar(cName) 
    			+ "ServiceImpl extends BaseServiceImpl<"+ getLastChar(cName) 
    			+ ", String> implements "+getLastChar(cName)+"Service{"
    			+RT_2+BLANK_4 + "@Resource"+RT_1+BLANK_4+"private "+getLastChar(cName)
    			+"Dao "+getLowercaseChar(getLastChar(cName))+"Dao;"+RT_2+BLANK_4+"@Resource"
    			+RT_1+BLANK_4+"public void setBaseDao("+getLastChar(cName)+"Dao "
				+getLowercaseChar(getLastChar(cName))+"Dao){"+RT_1+BLANK_8+"super.setBaseDao("
				+getLowercaseChar(getLastChar(cName))+"Dao);"+RT_1+BLANK_4+"}"+RT_2 +"}");
    	fw.flush();
		fw.close();
		showInfo(fileName);
    }
    

	/**
	 * 获取路径的最后面字符串<br>
	 * 如：<br>
	 *     <code>str = "com.b510.base.bean.User"</code><br>
	 *     <code> return "User";<code>
	 * @param str
	 * @return
	 */
	public String getLastChar(String str) {
		if ((str != null) && (str.length() > 0)) {
			int dot = str.lastIndexOf('.');
			if ((dot > -1) && (dot < (str.length() - 1))) {
				return str.substring(dot + 1);
			}
		}
		return str;
	}
	
	/**
	 * 把第一个字母变为小写<br>
	 * 如：<br>
	 *     <code>str = "UserDao";</code><br>
	 *     <code>return "userDao";</code>
	 * @param str
	 * @return
	 */
	public String getLowercaseChar(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1);
	}

	/**
	 * 显示信息
	 * @param info
	 */
	public void showInfo(String info){
		System.out.println("创建文件："+ info+ "成功！");
	}
	
	/**
	 * 获取系统时间
	 * @return
	 */
	public static String getDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(new Date());
	}
}

