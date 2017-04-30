package kr.or.dgit.erp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dao.TitleMapper;
import kr.or.dgit.erp.dao.TitleMapperImpl;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.utill.MyBatisSqlSessionFactory;
public class TitleService {
	public static final TitleService instance = new TitleService();
	private TitleService() {}
	public static TitleService getInstance(){
		return instance;
	}

	public List<Title> selectTitleByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			return titleMapper.selectTitleByAll();
		} 
	}
	
	public Title selectTitleByNo(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			return titleMapper.selectTitleByNo(title);
		} 
	}

	public int insertTitleItem(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res = titleMapper.insertTitleItem(title);
			sqlSession.commit();
			return res;
		} 
	}
	
	public int updateTitleItem(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res = titleMapper.updateTitleItem(title);
			sqlSession.commit();
			return res;
		} 
	}

	public int deleteTitleItem(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res = titleMapper.deleteTitleItem(title);
			sqlSession.commit();
			return res;
		} 
	}
}
