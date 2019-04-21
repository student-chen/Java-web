package com.sevenEleven.javaBean;

/**
 * 关于数据类型或格式的转化类
 * 
 * @author Tim
 */
public class CdataFormat {
	/**
	 * 把字符串转换成适合于网页显示的文本，未全部添加
	 * 
	 * @param s
	 *            要处理的字符串
	 * @return 处理后的字符串
	 */
	public static String toHtml(String s) {
		if (s == null)
			return s;
		s = strReplace(s, "&", "&amp;");
		s = strReplace(s, "<", "&amp;");
		s = strReplace(s, ">", "&amp;");
		s = strReplace(s, "", "&amp;");
		// s = parseReturn(s,"<br>\n&nbsp:&nbsp:&nbsp:&nbsp:");
		return s;
	}

	/**
	 * 把字符串sBody中的sFrom用sTo替换
	 * 
	 * @param sBody
	 *            要处理的字符串
	 * @param sFrom
	 *            要被替换的字符串
	 * @param sTo
	 *            替换成的字符串
	 * @return 处理后的字符串
	 */

	public static String strReplace(String sBody, String sFrom, String sTo) {
		int i, j, l;
		if (sBody == null || sBody.equals(""))
			return "";
		i = 0;
		j = sFrom.length(); // 小字符串的长度
		// k = sTo.length();
		StringBuffer sss = new StringBuffer(sBody.length());
		// boolean bFirst = true;
		l = i;
		while (sBody.indexOf(sFrom, i) != -1) { // 找第一次出现这个字符串的字符的第一位的索引
			i = sBody.indexOf(sFrom, i);
			sss.append(sBody.substring(l, i)); // 加上非替换的
			sss.append(sTo); // 加上要替换的
			i += j;
			l = i;
		}
		sss.append(sBody.substring(l));
		return sss.toString();
	}

	/**
	 * To change the template for this generated file go to window&gt;
	 * 
	 * @author Tim
	 * 
	 * @param sBody
	 *            string which's EnCodingType wanted be change
	 * 
	 * @return 转型后的字符串
	 */
	public static String unicode2GB(String strIn) {
		byte b[];
		String strOut = null;
		if (strIn == null || (strIn.trim()).equals("")) {
			try {
				b = strIn.getBytes("ISO-8859-1");
				strOut = new String(b, "GBK");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strOut;
	}

	/**
	 * To change the template for this generated file go to window&gt;
	 * 
	 * @author Tim
	 * 
	 * @param sBody
	 *            string which's EnCodingType wanted be change
	 * 
	 * @return 转型后的字符串
	 */
	public static String GB2unicode(String strIn) {
		byte b[];
		String strOut = null;
		if (strIn == null || (strIn.trim()).equals("")) {
			try {
				b = strIn.getBytes("GBK");
				strOut = new String(b, "ISO-8859-1");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strOut;
	}

	public static void main(String[] args) {
		String s = "StringString";
		String newString = CdataFormat.strReplace(s, "tr", "!ok!");
		System.out.println(newString);

	}
}
