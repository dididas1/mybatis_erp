package kr.or.dgit.erp.table;

import javax.swing.JPanel;

import kr.or.dgit.erp.dao.DataDao;
import kr.or.dgit.erp.dto.Department;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableDepartment extends AbsTablePanel<Department> {
	public TableDepartment() {
	}
	
	protected Object[][] getRowData() {
		Vector<Department> depts= dao.selectAllItems();
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