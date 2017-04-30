package kr.or.dgit.erp.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import kr.or.dgit.erp.content.AbsContentPanel;
import kr.or.dgit.erp.content.ContentTitle;
import kr.or.dgit.erp.dao.DataDao;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.table.AbsTablePanel;
import kr.or.dgit.erp.table.TableTitle;

@SuppressWarnings("serial")
public abstract class AbsViewFrame<T> extends JFrame implements ActionListener{
	private DataDao<T> dao;
	private AbsTablePanel<T> ptable;
	private JButton btnOk;
	protected AbsContentPanel<T> pContent;
	private JButton btnCancel;
	
	public AbsViewFrame() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setBounds(100, 200, 300, 300);
		
		pContent = createContent();
		getContentPane().add(pContent);
		pContent.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		btnOk = new JButton("저장") ;
		btnOk.addActionListener(this);
		panel_1.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_1.add(btnCancel);
		
		ptable = createTable();
		getContentPane().add(ptable);
	}

	protected abstract AbsTablePanel<T> createTable();
	protected abstract AbsContentPanel<T> createContent();
	protected abstract String fileNmae();
	
	public void backUp(DataDao<T> dao){
		File f= new File(fileNmae());
		setDao(dao);
		Vector<T> vector= dao.selectAllItems();
		
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f))){
			oos.writeObject(vector);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}	
	public void read(String string) {
		try(ObjectInputStream ois= new ObjectInputStream(new BufferedInputStream(new FileInputStream(string)))){
			Vector<T> vector= (Vector<T>) ois.readObject();
			dao.setVector(vector);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setDao(DataDao<T> dao) {
		this.dao = dao;
		ptable.setDao(dao);
		ptable.loadData();
		setNoInit();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		if(pContent.isEmpty()){
			JOptionPane.showMessageDialog(null, "공백이존재합니다");
			return;
		}
		dao.insertItem(pContent.getObject());
		setNoInit();
		pContent.clear();
		ptable.loadData();	
		JOptionPane.showMessageDialog(null, "추가되었습니다");
	}
	
	public void setNoInit(){
		String value= String.format(setNoName(), dao.getLastNum()+1);
		pContent.getpNo().setTfValue(value);
		pContent.getpNo().getTf().setEditable(false);
		pContent.getpName().getTf().requestFocus();
	}
	
	protected boolean isValidecheck() {
		return pContent.isEmpty();
		
		
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clear();
	}
	
	 public abstract String setNoName();
		
	}
