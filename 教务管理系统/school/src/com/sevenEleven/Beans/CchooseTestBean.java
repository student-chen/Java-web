package com.sevenEleven.Beans;

/**
 * @author Tim 选择题的Bean
 */
public class CchooseTestBean {
	private String ch_id;     //主键

	private int l_id;        //课程ID

	private int type;        //题目类别(单选,多选)

	private String ch_question;  //问题

	private String keya;        //答案A

	private String keyb;

	private String keyc;

	private String keyd;

	private String answer;    //正确答案

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCh_id() {
		return ch_id;
	}

	public void setCh_id(String ch_id) {
		this.ch_id = ch_id;
	}

	public String getCh_question() {
		return ch_question;
	}

	public void setCh_question(String ch_question) {
		this.ch_question = ch_question;
	}

	public String getKeya() {
		return keya;
	}

	public void setKeya(String keya) {
		this.keya = keya;
	}

	public String getKeyb() {
		return keyb;
	}

	public void setKeyb(String keyb) {
		this.keyb = keyb;
	}

	public String getKeyc() {
		return keyc;
	}

	public void setKeyc(String keyc) {
		this.keyc = keyc;
	}

	public String getKeyd() {
		return keyd;
	}

	public void setKeyd(String keyd) {
		this.keyd = keyd;
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	
}
