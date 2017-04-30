package kr.or.dgit.erp.dto;

import java.io.Serializable;

public class Title implements Serializable{
	private String titleNo;
	private String titleName;
	private boolean isExist;
	
	public Title() {
	}

	public Title(String titleNo) {
		this.titleNo = titleNo;
	}



	public Title(String titleNo, String titleName) {
		this.titleNo = titleNo;
		this.titleName = titleName;
	}


	public String getTitleNo() {
		return titleNo;
	}



	public void setTitleNo(String titleNo) {
		this.titleNo = titleNo;
	}



	public String getTitleName() {
		return titleName;
	}



	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}



	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}


	@Override
	public String toString() {
		return String.format("%s", titleName);
	}


	public Object[] toArray() {
		return new Object[]{titleNo,titleName};
	}
	
	
	
	
	
	
}
