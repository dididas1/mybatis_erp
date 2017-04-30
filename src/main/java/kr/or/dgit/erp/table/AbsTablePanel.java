package kr.or.dgit.erp.table;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.erp.dao.DataDao;


@SuppressWarnings("serial")
public abstract class AbsTablePanel<T> extends JPanel {
	private JTable table;
	public AbsTablePanel() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setViewportView(table);
	}

	protected abstract Object[][] getRowData();

	protected abstract Object[] getColumn() ;
	
	public void loadData(){
		table.setModel(new DefaultTableModel(getRowData(),getColumn()));
	}

	public JTable getTable() {
		return table;
	}

	
	
}
