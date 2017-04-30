package kr.or.dgit.erp.table;

import java.util.List;

import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.TitleService;

public class TableTitle extends AbsTablePanel<Title> {
	

	protected Object[] getColumn() {
		
		return new String[]{"직책번호","직책"};
	}
	
	public Object[][] getRowData(){
		List<Title> ti= TitleService.getInstance().selectTitleByAll();
		Object[][] title= new Object[ti.size()][];
		for(int i=0;i<title.length;i++){
			title[i]=ti.get(i).toArray();
		}
		return title;
	}

	
}
