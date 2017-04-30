package kr.or.dgit.erp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dao.DepartmentMapper;
import kr.or.dgit.erp.dao.DepartmentMapperImpl;
import kr.or.dgit.erp.dao.EmployeeMapper;
import kr.or.dgit.erp.dao.EmployeeMapperImpl;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.utill.MyBatisSqlSessionFactory;

public class EmployeeService {
	public static final EmployeeService instance = new EmployeeService();
	private EmployeeService() {}
	public static EmployeeService getInstance(){
		return instance;
	}
	
	public List<Employee> selectEmployeeByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			return employeeMapper.selectEmployeeByAll();
		} 
	}
	
	public Employee selectEmployeeByNo(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			return employeeMapper.selectEmployeeByNo(employee);
		} 
	}

	public int insertEmployeeItem(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			int res = employeeMapper.insertEmployeeItem(employee);
			sqlSession.commit();
			return res;
		} 
	}
	
	public int updateEmployeeItem(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			int res = employeeMapper.updateEmployeeItem(employee);
			sqlSession.commit();
			return res;
		} 
	}

	public int deleteEmployeeItem(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			int res = employeeMapper.deleteEmployeeItem(employee);
			sqlSession.commit();
			return res;
		} 
	}
}
