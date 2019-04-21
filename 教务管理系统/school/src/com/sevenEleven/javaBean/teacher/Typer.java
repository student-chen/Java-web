package com.sevenEleven.javaBean.teacher;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Typer {
	static public boolean IsInter(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() )
		{
		return false;
		}
		return true;
	}
}
