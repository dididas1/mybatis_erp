package kr.or.dgit.erp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dao.DepartmentMapper;
import kr.or.dgit.erp.dao.DepartmentMapperImpl;
import kr.or.dgit.erp.dao.TitleMapper;
import kr.or.dgit.erp.dao.TitleMapperImpl;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.utill.MyBatisSqlSessionFactory;
public class DepartmentService {
	public static final DepartmentService instance = new DepartmentService();
	private DepartmentService() {}
	public static DepartmentService getInstance(){
		return instance;
	}

	public List<Department> selectDepartmentByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			return departmentMapper.selectDepartmentByAll();
		} 
	}
	
	public Department selectDepartmentByNo(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			return departmentMapper.selectDepartmentByNo(department);
		} 
	}

	public int insertDepartmentItem(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res = departmentMapper.insertDepartmentItem(department);
			sqlSession.commit();
			return res;
		} 
	}
	
	public int updateDepartmentItem(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res = departmentMapper.updateDepartmentItem(department);
			sqlSession.commit();
			return res;
		} 
	}

	public int deleteDepartmentItem(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res = departmentMapper.deleteDepartmentItem(department);
			sqlSession.commit();
			return res;
		} 
	}
}
