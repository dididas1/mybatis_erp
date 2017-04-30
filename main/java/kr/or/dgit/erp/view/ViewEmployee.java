package kr.or.dgit.erp.view;

import kr.or.dgit.erp.content.AbsContentPanel;
import kr.or.dgit.erp.content.ContentEmp;
import kr.or.dgit.erp.dao.DataDao;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.table.AbsTablePanel;
import kr.or.dgit.erp.table.TableEmp;

import javax.swing.JPanel;
import erp_myframework.CompPanel;
import javax.swing.JComboBox;
import java.awt.GridLayout;

public class ViewEmployee extends AbsViewFrame<Employee> {
	private DataDao<Title> daoTitle;
	private DataDao<Department> daodept;
	public void setDaoTitle(DataDao<Title> daoTitle) {
		this.daoTitle = daoTitle;
		((ContentEmp)pContent).setTitles(daoTitle.selectAllItems());
	}
	
	

	public void setDoaDept(DataDao<Department> daodept) {
		this.daodept = daodept;
		((ContentEmp)pContent).setDepartment(daodept.selectAllItems());
	}


	public ViewEmployee() {
		
	}

	@Override
	protected AbsTablePanel<Employee> createTable() {
		return new TableEmp();
	}

	@Override
	protected AbsContentPanel<Employee> createContent() {
		return new ContentEmp();
	}

	@Override
	public String setNoName() {
		return "E%03d";
	}
	
	protected String fileNmae() {
		return "D:\\backupemp.txt";
	}
}
