package service;

import java.util.List;

import model.PageBean;
import model.Score;

public interface ScoreService {
	/*
	 * 添加成绩
	 */
	int addScore(Score score);
	/*
	 * 删除成绩
	 */
	int deleteScore(int scoreID);
	/*
	 * 修改成绩
	 */
	int editCos(Score score);
	/*
	 * 查询所有成绩
	 */
	List findAll();
	/*
	 * 查询一个学生成绩
	 */
	List findOne(String stuNum);
	/*
	 * 查询一个学生一门课程
	 */
	List selectScore(int scoreID);
	/*
	 * 查询该学生的该门课程是否添加
	 */
	Score selectScoreInfo(Score score);
	/*
	 * 分页显示一个学生成绩信息
	 */
	PageBean scoreListPage(int pageNo,int pageCount,String stuNum);
	/*
	 *分页显示成绩信息
	 */
	PageBean scoreListPage(int pageNo,int pageCount);
	/*
	 * 查询一个学生的一门课成绩
	 */
	List findStuOne(String stuNum,String courseName);
	/*
	 * 学生所有成绩总和
	 */
	double findStuSc(String stuNum);
	/*
	 * 查询学生总分排名
	 */
	PageBean selectScoreSum(int pageNo,int pageCount);
	/*
	 * 模糊查询学生成绩
	 */
	PageBean selectStuScore(int pageNo,int pageCount, Score score);
	/*
	 * 查询一个教师所带的课程
	 */
	PageBean selectTeaScore(int PageNo,int pageCount, String teaName, Score score);
}
