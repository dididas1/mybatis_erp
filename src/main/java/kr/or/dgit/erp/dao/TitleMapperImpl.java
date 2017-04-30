package kr.or.dgit.erp.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dto.Title;

public class TitleMapperImpl implements TitleMapper{
	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(TitleMapperImpl.class);
	private String nameSpace = "kr.or.dgit.erp.dao.TitleMapper.";

	public TitleMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<Title> selectTitleByAll() {
		log.debug("selectTitleByAll()");
		return sqlSession.selectList(nameSpace + "selectTitleByAll");
	}

	@Override
	public Title selectTitleByNo(Title title) {
		log.debug("selectTitleByNo()");
		return sqlSession.selectOne(nameSpace + "selectTitleByNo",title);
	}

	@Override
	public int insertTitleItem(Title title) {
		log.debug("insertTitleItem()");
		return sqlSession.insert(nameSpace + "insertTitleItem",title);
	}

	@Override
	public int updateTitleItem(Title title) {
		log.debug("updateTitleItem()");
		return sqlSession.update(nameSpace + "updateTitleItem",title);
	}

	@Override
	public int deleteTitleItem(Title title) {
		log.debug("deleteTitleItem()");
		return sqlSession.update(nameSpace + "deleteTitleItem",title);
	}
}
