package kr.or.dgit.erp.dao;

import java.util.List;

import kr.or.dgit.erp.dto.Department;

public interface DepartmentMapper {
	List<Department> selectDepartmentByAll();
	Department selectDepartmentByNo(Department department); 
	int insertDepartmentItem(Department department);
	int updateDepartmentItem(Department department);
	int deleteDepartmentItem(Department department);
}
