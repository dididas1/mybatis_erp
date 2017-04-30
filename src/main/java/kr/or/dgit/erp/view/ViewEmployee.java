package kr.or.dgit.erp.view;

import javax.swing.JOptionPane;

import kr.or.dgit.erp.content.AbsContentPanel;
import kr.or.dgit.erp.content.ContentEmp;
import kr.or.dgit.erp.dao.DataDao;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.table.AbsTablePanel;
import kr.or.dgit.erp.table.TableEmp;

public class ViewEmployee extends AbsViewFrame<Employee> {
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

	@Override
	public int setNextNo() {
		return employeeService.selectEmployeeByAll().size()+1;
	}
	
	@Override
	public Employee getDataObject() { 
		int selectedidx= ptable.getTable().getSelectedRow();
		if(selectedidx==-1)return null;
		String no=(String) ptable.getTable().getValueAt(selectedidx, 0);
		Employee  employee= employeeService.selectEmployeeByNo(new Employee(no));
		return employee;
	}
	
	public void additems(){
		if(pContent.isEmpty()){
			JOptionPane.showMessageDialog(null, "공백이존재합니다");
			return;
		}
		employeeService.insertEmployeeItem(pContent.getObject());
		setNoInit();
		pContent.clear();
		ptable.loadData();	
		JOptionPane.showMessageDialog(null, "추가되었습니다");
	}
}
