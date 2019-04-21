package data;

public class student {
	private int id;
	private String username;
	private int[] score;
	private String[] course;
	private int i;
	private int j;
	public student(){
		score=new int[50];
		course=new String[50];
		i=0;
		j=0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course[i] = course;
		i++;
	}
	public int[] getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score[j] = score;
		j++;
	}
	
}
