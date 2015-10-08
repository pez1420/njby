package com.njby.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

public class Catalog extends BaseEntity{

	private static final long serialVersionUID = -5380961431163128261L;

	private static final String TREE_PATH_SEPRATOR = ",";
	
	private String name;
	
	private Integer grade;
	
	private String treePath;
	
	private Catalog parent;
	
	private List<Catalog> childrens = new ArrayList<Catalog>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public Catalog getParent() {
		return parent;
	}

	public void setParent(Catalog parent) {
		this.parent = parent;
	}

	public List<Catalog> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Catalog> childrens) {
		this.childrens = childrens;
	}
	
	public List<String> getTreePaths() {
		List<String> treePaths = new ArrayList<String>();
	    String[] ids = StringUtils.split(getTreePath(), ",");
	    if (ids != null) {
	      for (String id : ids) {
	    	  treePaths.add(id);
	      }
	    }
	    return treePaths;
	}
	
	public String toString() {
		return name;
	}

}

/*
 	<resultmap id="result" class="chapter">
 		<result property="name" column="name" />
 		<result property="cid" column="cid" />
 		<result property="lcode" column="lcode" />
 		<result property="level" column="level" />
 		<result property="dorder" column="dorder" />
 		<result property="parent" column="pid" select="chapter.getparent"/>
 		<result property="children" column="cid" select="chapter.getchildren"/>
 	</resultmap>
 	
 	<select id="selectall" resultclass="chapter" resultmap="result">
 		select <include refid="main_columns" /> 
 		from <include refid="main_table" />
 		where cid =1
 	</select>
 	
 	<select id="getparent" resultclass="chapter" parameterclass="int" resultmap="result"  >
 		select <include refid="main_columns" />
 		from <include refid="main_table" />        
 		where cid =#cid#  
 	 </select>
 	 
 	 <select id="getchildren" resultclass="chapter" parameterclass="int" resultmap="result"  >         
 	 	select <include refid="main_columns" />
 	 	from<include refid="main_table" />        
 	 	where pid =#cid#  
 	 </select>
 */
