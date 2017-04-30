package erp_project;

import java.awt.EventQueue;

import javax.swing.JFrame;

import kr.or.dgit.erp.dao.DataDao;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.view.ViewDepartment;
import kr.or.dgit.erp.view.ViewTitle;

public class TestMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
