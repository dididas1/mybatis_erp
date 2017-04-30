package kr.or.dgit.erp;

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
	private JButton btnBackup;
	private JButton btnRestore;
	private AbsViewFrame<Title> vt;
	private AbsViewFrame<Department> vd;
	private AbsViewFrame<Employee> ve;

	/**
	 * Launch the application.
	 */
	


	public ErpApplication() {
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
		ve= new ViewEmployee();
		ve.setBounds(300, 300, 300, 300);
		ve.setVisible(true);
	}
	
	
	protected void actionPerformedBtnDept(ActionEvent e) {
		vd= new ViewDepartment();
		vd.setBounds(300, 300, 300, 300);
		vd.setVisible(true);
	}
	
	protected void actionPerformedBtnTitle(ActionEvent e) {
		vt= new ViewTitle();
		vt.setBounds(300, 300, 300, 300);
		vt.setVisible(true);
	}
	protected void btnBackupActionPerformed(ActionEvent e) {
	}
	
	protected void btnRestoreActionPerformed(ActionEvent e) {
	}
}
