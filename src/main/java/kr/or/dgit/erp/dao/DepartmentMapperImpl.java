package kr.or.dgit.erp.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Title;

public class DepartmentMapperImpl implements DepartmentMapper{
	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(DepartmentMapperImpl.class);
	private String nameSpace = "kr.or.dgit.erp.dao.DepartmentMapper.";

	public DepartmentMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Department> selectDepartmentByAll() {
		log.debug("selectDepartmentByAll()");
		return sqlSession.selectList(nameSpace + "selectDepartmentByAll");
	}

	@Override
	public Department selectDepartmentByNo(Department department) {
		log.debug("selectDepartmentByNo()");
		return sqlSession.selectOne(nameSpace + "selectDepartmentByNo",department);
	}

	@Override
	public int insertDepartmentItem(Department department) {
		log.debug("insertDepartmentItem()");
		return sqlSession.insert(nameSpace + "insertDepartmentItem",department);
	}

	@Override
	public int updateDepartmentItem(Department department) {
		log.debug("updateDepartmentItem()");
		return sqlSession.update(nameSpace + "updateDepartmentItem",department);
	}

	@Override
	public int deleteDepartmentItem(Department department) {
		log.debug("deleteDepartmentItem()");
		return sqlSession.update(nameSpace + "deleteDepartmentItem",department);
	}
}
