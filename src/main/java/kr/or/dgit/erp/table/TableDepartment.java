package kr.or.dgit.erp.table;

import java.util.List;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.service.DepartmentService;

@SuppressWarnings("serial")
public class TableDepartment extends AbsTablePanel<Department> {
	public TableDepartment() {
	}
	
	protected Object[][] getRowData() {
		List<Department> depts= DepartmentService.getInstance().selectDepartmentByAll();
		Object[][] datas= new Object[depts.size()][];
		for(int i=0;i<datas.length;i++){
			datas[i]= depts.get(i).toArray();
		}
		return datas;
	}

	protected Object[] getColumn() {
		return new String[]{"부서번호" ,"부서명","위치"};

	}

}