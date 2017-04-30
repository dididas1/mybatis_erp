package kr.or.dgit.erp.view;

import javax.swing.JOptionPane;

import kr.or.dgit.erp.content.AbsContentPanel;
import kr.or.dgit.erp.content.ContentDepartment;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.table.AbsTablePanel;
import kr.or.dgit.erp.table.TableDepartment;

public class ViewDepartment extends AbsViewFrame<Department> {
	public ViewDepartment() {
	}

	@Override
	protected AbsTablePanel<Department> createTable() {
		return new TableDepartment();
	}

	@Override
	protected AbsContentPanel<Department> createContent() {
		return new ContentDepartment();
	}

	@Override
	public String setNoName() {
		return "D%03d";
	}

	@Override
	public int setNextNo() {
		return departmentService.selectDepartmentByAll().size()+1;
	}
	
	@Override
	public Department getDataObject() { 
		int selectedidx= ptable.getTable().getSelectedRow();
		if(selectedidx==-1)return null;
		String no=(String) ptable.getTable().getValueAt(selectedidx, 0);
		Department  department= departmentService.selectDepartmentByNo(new Department(no));
		return department;
	}
	
	public void additems(){
		if(pContent.isEmpty()){
			JOptionPane.showMessageDialog(null, "공백이존재합니다");
			return;
		}
		departmentService.insertDepartmentItem(pContent.getObject());
		setNoInit();
		pContent.clear();
		ptable.loadData();	
		JOptionPane.showMessageDialog(null, "추가되었습니다");
	}

}
