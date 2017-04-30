package kr.or.dgit.erp.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;

public interface EmployeeMapper {
	List<Employee> selectEmployeeByAll();
	Employee selectEmployeeByNo(Employee employee); 
	int insertEmployeeItem(Employee employee);
	int updateEmployeeItem(Employee employee);
	int deleteEmployeeItem(Employee employee);
}
