package erp_project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.erp.dao.DataDao;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.view.AbsViewFrame;
import kr.or.dgit.erp.view.ViewDepartment;
import kr.or.dgit.erp.view.ViewEmployee;
import kr.or.dgit.erp.view.ViewTitle;

public class ErpApplication extends JFrame implements ActionListener,Serializable {

	private JPanel contentPane;
	private JButton btnEmp;
	private JButton btnDept;
	private JButton btnTitle;
	private DataDao<Department> deptdao;
	private DataDao<Title> titledao;
	private DataDao<Employee> empdao;
	private JButton btnBackup;
	private JButton btnRestore;
	private AbsViewFrame<Department> vd= new ViewDepartment();
	private AbsViewFrame<Title> vt= new ViewTitle();
	private AbsViewFrame<Employee> ve= new ViewEmployee();
	

	/**
	 * Launch the application.
	 */
	


	public ErpApplication() {
		testInit();
		setTitle("Erp Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 108);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 5, 0));
		
		btnEmp = new JButton("사원관리");
		btnEmp.addActionListener(this);
		contentPane.add(btnEmp);
		
		btnDept = new JButton("부서관리");
		btnDept.addActionListener(this);
		contentPane.add(btnDept);
		
		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
		
		btnBackup = new JButton("백업");
		btnBackup.addActionListener(this);
		contentPane.add(btnBackup);
		
		btnRestore = new JButton("복원");
		btnRestore.addActionListener(this);
		contentPane.add(btnRestore);
	}

	private void testInit() {
		titledao= new DataDao<>();
		titledao.insertItem(new Title("T001", "사장"));
		titledao.insertItem(new Title("T002", "부장"));
		titledao.insertItem(new Title("T003", "과장"));
		
		deptdao= new DataDao<>();
		deptdao.insertItem(new Department("D001", "이름", 1));
		deptdao.insertItem(new Department("D002", "이름2", 2));
		deptdao.insertItem(new Department("D003", "이름3", 3));
		
		empdao= new DataDao<>();
		ArrayList<String> al= new ArrayList<>();
		al.add("취미");
		empdao.insertItem(new Employee("E001", "이승우", new Title("과장"), 500000, true, al, new Department(" "), new Date()));
		
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRestore) {
			btnRestoreActionPerformed(e);
		}
		if (e.getSource() == btnBackup) {
			btnBackupActionPerformed(e);
		}
		if (e.getSource() == btnTitle) {
			actionPerformedBtnTitle(e);
		}
		if (e.getSource() == btnDept) {
			actionPerformedBtnDept(e);
		}
		if (e.getSource() == btnEmp) {
			actionPerformedBtnEmp(e);
		}
	}
	
	
	protected void actionPerformedBtnEmp(ActionEvent e) {
		ve.setDao(empdao);
		ve.setBounds(300, 300, 700, 500);
		((ViewEmployee)ve).setDaoTitle(titledao);
		((ViewEmployee)ve).setDoaDept(deptdao);
		ve.setVisible(true);
	}
	
	protected void actionPerformedBtnDept(ActionEvent e) {
		vd.setDao(deptdao);
		vd.setVisible(true);
		
	}
	
	protected void actionPerformedBtnTitle(ActionEvent e) {
		vt.setDao(titledao);
		vt.setBounds(300, 300, 300, 300);
		vt.setVisible(true);
	}
	protected void btnBackupActionPerformed(ActionEvent e) {
		vd.backUp(deptdao);
		ve.backUp(empdao);
		vt.backUp(titledao);
	}
	
	protected void btnRestoreActionPerformed(ActionEvent e) {
		vd.read("D:\\backupdept.txt");
		ve.read("D:\\backupemp.txt");
		vt.read("D:\\backuptitle.txt");
		JOptionPane.showMessageDialog(null, "북원되었습니다");
	}
}
