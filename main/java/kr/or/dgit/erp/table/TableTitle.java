package kr.or.dgit.erp.table;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.erp.dao.DataDao;
import kr.or.dgit.erp.dto.Title;

public class TableTitle extends AbsTablePanel<Title> {
	

	protected Object[] getColumn() {
		
		return new String[]{"직책번호","직책"};
	}
	
	public Object[][] getRowData(){
		Vector<Title> ti=dao.selectAllItems();
		Object[][] title= new Object[ti.size()][];
		for(int i=0;i<title.length;i++){
			title[i]=ti.get(i).toArray();
		}
		return title;
	}

	
}
