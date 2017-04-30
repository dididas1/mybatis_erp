package kr.or.dgit.erp.table;

import java.util.List;

import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.service.EmployeeService;

public class TableEmp extends AbsTablePanel<Employee> {

	public TableEmp() {

	}

	protected Object[][] getRowData() {
		List<Employee> depts= EmployeeService.getInstance().selectEmployeeByAll();
		Object[][] datas= new Object[depts.size()][];
		for(int i=0;i<datas.length;i++){
			datas[i]= depts.get(i).toArray();
		}
		return datas;
	}

	protected Object[] getColumn() {
		return new String[]{"번호" ,"사원명","직책","급여","성별","취미","부서","입사일"};

	}

}
