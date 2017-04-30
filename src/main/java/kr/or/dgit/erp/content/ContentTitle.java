package kr.or.dgit.erp.content;

import java.awt.GridLayout;

import erp_myframework.TextFieldPanel;
import kr.or.dgit.erp.dto.Title;

public class ContentTitle extends AbsContentPanel<Title> {

	private TextFieldPanel titleNo;
	private TextFieldPanel titleName;

	/**
	 * Create the panel.
	 */
	public ContentTitle() {
		setLayout(new GridLayout(0, 1, 0, 0));

		titleNo = new TextFieldPanel();
		titleNo.setTitle("번호");
		add(titleNo);

		titleName = new TextFieldPanel();
		titleName.setTitle("직책명");
		add(titleName);

	}

	public void clear(){
		titleName.setTfValue("");
		titleNo.getTf().requestFocus();
	}


	@Override
	public TextFieldPanel getpNo() {
		return titleNo;
	}


	@Override
	public TextFieldPanel getpName() {
		return titleName;
	}


	@Override
	public Title getObject() {
		String no= titleNo.getTfValue();
		String name= titleName.getTfValue();
		return new Title(no, name);

	}

	@Override
	public void setObject(Title item) {
		titleNo.setTfValue(item.getTitleNo());
		titleName.setTfValue(item.getTitleName());

	}

}
