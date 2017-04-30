package kr.or.dgit.erp.table;

import java.util.Vector;

import javax.swing.JPanel;

import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;

public class TableEmp extends AbsTablePanel<Employee> {

	public TableEmp() {

	}

	protected Object[][] getRowData() {
		Vector<Employee> depts= dao.selectAllItems();
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
