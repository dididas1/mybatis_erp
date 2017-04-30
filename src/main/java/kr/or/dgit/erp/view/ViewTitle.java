package kr.or.dgit.erp.view;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.log4j.Category;

import kr.or.dgit.erp.content.AbsContentPanel;
import kr.or.dgit.erp.content.ContentTitle;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.TitleService;
import kr.or.dgit.erp.table.AbsTablePanel;
import kr.or.dgit.erp.table.TableTitle;
import java.awt.event.ActionListener;

public class ViewTitle extends AbsViewFrame<Title> implements ActionListener {
	
	public ViewTitle() {
	}

	@Override
	protected AbsTablePanel<Title> createTable() {
		return new TableTitle() ;
	}

	@Override
	protected AbsContentPanel<Title> createContent() {
		return new ContentTitle();
	}

	@Override
	public String setNoName() {
		return "T%03d";
	}

	@Override
	public int setNextNo() {
		return titleService.selectTitleByAll().size()+1;
	}
	
	@Override
	public Title getDataObject() { 
		int selectedidx= ptable.getTable().getSelectedRow();
		if(selectedidx==-1)return null;
		String no=(String) ptable.getTable().getValueAt(selectedidx, 0);
		Title title = titleService.selectTitleByNo(new Title(no));
		return title;
	}
	
	public void additems(){
		if(pContent.isEmpty()){
			JOptionPane.showMessageDialog(null, "공백이존재합니다");
			return;
		}
		titleService.insertTitleItem(pContent.getObject());
		setNoInit();
		pContent.clear();
		ptable.loadData();	
		JOptionPane.showMessageDialog(null, "추가되었습니다");
	}
}
