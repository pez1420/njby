package generate;

import com.njby.entity.*;

public class BeanUtilTest {

	public static void main(String[] args) throws Exception{
		BeanUtilTest beanUtilTest = new BeanUtilTest();
		BeanUtils beanUtils = new BeanUtils();
		beanUtilTest.beanTool(beanUtils, Equipment.class);


	}
	
	/**
	 * 根据bean生成相应的文件
	 * @param beanUtils
	 * @param c
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public void beanTool(BeanUtils beanUtils ,Class c)throws Exception{
		beanUtils.createBeanXml(c);
		beanUtils.createBeanController(c);
		beanUtils.createBeanSearchEntity(c);
		beanUtils.createBeanDao(c);
		beanUtils.createBeanService(c);
		beanUtils.createBeanServiceImpl(c);
	}
	
	/**
	 * 根据bean生成相应的文件
	 * @param beanUtils
	 * @param c
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public void pageTool(Class c)throws Exception{
		PageUtils pageUtils = new PageUtils();
		String parentPath = "";
		String subPath = "";
		pageUtils.createBeanPage(c, parentPath, subPath, true, false, false);
	}
	
}