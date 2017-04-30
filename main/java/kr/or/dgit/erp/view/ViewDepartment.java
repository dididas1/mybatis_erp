package kr.or.dgit.erp.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

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
		// TODO Auto-generated method stub
		return new TableDepartment();
	}

	@Override
	protected AbsContentPanel<Department> createContent() {
		// TODO Auto-generated method stub
		return new ContentDepartment();
	}

	@Override
	public String setNoName() {
		return "D%03d";
	}

	@Override
	protected String fileNmae() {
		// TODO Auto-generated method stub
		return "D:\\backupdept.txt";
	}
	
	

}
