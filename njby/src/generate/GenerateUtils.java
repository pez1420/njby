package generate;

import java.util.ArrayList;
import java.util.List;

public class GenerateUtils {
	
	/***
	 * 驼峰转变成下划线
	 * 
	 * @param str 等待变换字符串
	 * 
	 * @return
	 */
	public static String hump2underline(String str) {
		List record = new ArrayList();
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if ((tmp <= 'Z') && (tmp >= 'A')) {
				record.add(i);// 记录每个大写字母的位置
			}
		}
		
		if (null == record || record.size() == 0) {
			return str;
		}
		
		str = str.toLowerCase();
		
		char[] charofstr = str.toCharArray();
		String[] t = new String[record.size()];
		for (int i = 0; i < record.size(); i++) {
			t[i] = "_" + charofstr[(Integer) record.get(i)];
		}
		String result = "";
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((flag < record.size()) && (i == (Integer) record.get(flag))) {
				result += t[flag];
				flag++;
			} else
				result += charofstr[i];
		}
		
		result = result.substring(1);
		
		return result;
	}
	
	
	/**
	 * 获取路径的最后面字符串<br>
	 * 如：<br>
	 *     <code>str = "com.b510.base.bean.User"</code><br>
	 *     <code> return "User";<code>
	 * @param str
	 * @return
	 */
	public static String getLastChar(String str) {
		if ((str != null) && (str.length() > 0)) {
			int dot = str.lastIndexOf('.');
			if ((dot > -1) && (dot < (str.length() - 1))) {
				return str.substring(dot + 1);
			}
		}
		return str;
	}
}
