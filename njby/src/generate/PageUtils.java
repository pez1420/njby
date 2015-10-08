package generate;

import java.io.File;
import java.io.FileWriter;


/**
 * @author pez1420(pez1420@163.com)
 * @date 2015-08-25
 * @description 自动生成页面代码
 */

public class PageUtils {
	//公共部分
	private static final String RT_1 = "\r\n";
	private static final String RT_2 = RT_1+RT_1;
	
	public void createBeanPage_View(Class c, String filePath) throws Exception {
		String cName = c.getName();
		String fileName = filePath + GenerateUtils.hump2underline(cName) + "_view.ftl";
		File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}
		
		FileWriter fw = new FileWriter(f);
		fw.flush();
		fw.close();
	}
	
	public void createBeanPage_Add(Class c, String filePath) throws Exception {
		String cName = c.getName();
		String fileName = filePath + GenerateUtils.hump2underline(cName) + "_add.ftl";
		File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}
		
		FileWriter fw = new FileWriter(f);
		fw.flush();
		fw.close();
	}
	
	public void createBeanPage_Edit(Class c, String filePath) throws Exception {
		String cName = c.getName();
		String fileName = filePath + GenerateUtils.hump2underline(cName) + "_edit.ftl";
		File f = new File(fileName);
		if(f.exists())   {
			System.out.println("!!!已经存在文件:" + fileName );
			return;
		}
		
		FileWriter fw = new FileWriter(f);
		fw.flush();
		fw.close();
	}
	
	public void createBeanPage(Class c, String parentPath, String subPath, 
			boolean viewPage, boolean addPage, boolean editPage) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/WebRoot/WEB-INF/template/admin"  + "/" ;
		fileName += parentPath;
		fileName += "/";
		fileName += subPath;
		fileName += "/";
		if (viewPage == true)
			createBeanPage_View(c, fileName);
		if (addPage == true)
			createBeanPage_Add(c, fileName);
		if (editPage == true)
			createBeanPage_Edit(c, fileName);
	}
	
	
}
