package kr.or.dgit.erp.view;

import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.erp.content.AbsContentPanel;
import kr.or.dgit.erp.dao.DataDao;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.DepartmentService;
import kr.or.dgit.erp.service.EmployeeService;
import kr.or.dgit.erp.service.TitleService;
import kr.or.dgit.erp.table.AbsTablePanel;

@SuppressWarnings("serial")
public abstract class AbsViewFrame<T> extends JFrame implements ActionListener{
	protected AbsTablePanel<T> ptable;
	protected AbsContentPanel<T> pContent;
	protected JPanel btnPanel;
	private JButton btnCancel;
	private JButton btnOk;
	protected TitleService titleService = TitleService.getInstance();
	protected DepartmentService departmentService = DepartmentService.getInstance();
	protected EmployeeService employeeService= EmployeeService.getInstance();
	
	public AbsViewFrame() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setBounds(100, 200, 300, 300);

		pContent = createContent();
		getContentPane().add(pContent);
		pContent.setLayout(new GridLayout(0, 1, 0, 0));

		btnPanel = new JPanel();
		getContentPane().add(btnPanel);

		btnOk = new JButton("저장");
		btnOk.addActionListener(this);
		btnPanel.add(btnOk);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnPanel.add(btnCancel);
		
		ptable = createTable();
		ptable.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				pContent.setObject(getDataObject());
				super.mouseClicked(e);
			}
			
		});
		getContentPane().add(ptable);
		ptable.loadData();
		setNoInit();
		
	}

	protected abstract AbsTablePanel<T> createTable();
	protected abstract AbsContentPanel<T> createContent();
	public abstract String setNoName();
	public abstract T getDataObject();
	public abstract int setNextNo();
	public abstract void additems();



	public void setNoInit(){
		String value= String.format(setNoName(), setNextNo());
		pContent.getpNo().setTfValue(value);
		pContent.getpNo().getTf().setEditable(false);
		pContent.getpName().getTf().requestFocus();
	}	
	protected boolean isValidecheck() {
		return pContent.isEmpty();

	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}
	private void btnCancelActionPerformed(ActionEvent e) {
		pContent.clear();
		setNoInit();
	}

	protected void btnOkActionPerformed(ActionEvent e) {
		additems();
	}
}
