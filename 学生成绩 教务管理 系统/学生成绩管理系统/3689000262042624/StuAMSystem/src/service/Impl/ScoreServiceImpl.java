package service.Impl;

import java.util.List;

import dao.Impl.ScoreDaoImpl;


import model.PageBean;
import model.Score;
import model.ScoreCou;
import service.ScoreService;

public class ScoreServiceImpl implements ScoreService{
	
	private ScoreDaoImpl scoreDaoImpl=new ScoreDaoImpl();

	public int addScore(Score score) {
		
		int rs=scoreDaoImpl.addScore(score);
		return rs;
	}

	public int deleteScore(int scoreID) {
		
		int rs=scoreDaoImpl.deleteScore(scoreID);
		return rs;
	}

	public int editCos(Score score) {
		
		int rs=scoreDaoImpl.editCos(score);
		return rs;
	}

	public List findAll() {
		
		List rs=scoreDaoImpl.findAll();
		return rs;
	}

	public List findOne(String stuNum) {
		
		List rs=scoreDaoImpl.findOne(stuNum);
		return rs;
	}

	public List selectScore(int scoreID) {
		
		List rs=scoreDaoImpl.selectScore(scoreID);
		return rs;
	}

	public Score selectScoreInfo(Score score) {
		
		Score rs=scoreDaoImpl.selectScoreInfo(score);
		return rs;
	}

	public PageBean scoreListPage(int pageNo, int pageCount, String stuNum) {
		
		PageBean rs=scoreDaoImpl.scoreListPage(pageNo, pageCount, stuNum);
		return rs;
	}

	public PageBean scoreListPage(int pageNo, int pageCount) {
		
		PageBean rs=scoreDaoImpl.scoreListPage(pageNo, pageCount);
		return rs;
	}

	public List findStuOne(String stuNum, String courseName) {
		
		List rs=scoreDaoImpl.findStuOne(stuNum, courseName);
		return rs;
	}

	public double findStuSc(String stuNum) {
		double sum=0;
		List rs=scoreDaoImpl.findOne(stuNum);
		for(int i=0;i<rs.size();i++){
			ScoreCou scu=(ScoreCou) rs.get(i);
			sum+=scu.getScoreGrade();
		}
		return sum;
	}

	public PageBean selectScoreSum(int pageNo, int pageCount) {
		
		PageBean rs=scoreDaoImpl.selectScoreSum(pageNo, pageCount);
		return rs;
	}

	public PageBean selectStuScore(int pageNo, int pageCount, Score score) {
		
		PageBean rs=scoreDaoImpl.selectStuScore(pageNo, pageCount, score);
		return rs;
	}

	public PageBean selectTeaScore(int pageNo, int pageCount, String teaName, Score score) {
		
		PageBean rs=scoreDaoImpl.selectTeaScore(pageNo, pageCount, teaName, score);
		return rs;
	}

}
