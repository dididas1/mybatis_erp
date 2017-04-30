package kr.or.dgit.erp.view;

import kr.or.dgit.erp.content.AbsContentPanel;
import kr.or.dgit.erp.content.ContentTitle;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.table.AbsTablePanel;
import kr.or.dgit.erp.table.TableTitle;

public class ViewTitle extends AbsViewFrame<Title> {

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
	protected String fileNmae() {
		// TODO Auto-generated method stub
		return "D:\\backuptitle.txt";
	}

}
