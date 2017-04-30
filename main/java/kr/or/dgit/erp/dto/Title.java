package kr.or.dgit.erp.dto;

import java.io.Serializable;

public class Title implements Serializable{
	private String no;
	private String name;
	public Title() {
	}
	

	public Title(String no) {
		this.no = no;
	}
	

	public Title(String no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Title)) {
			return false;
		}
		Title other = (Title) obj;
		
		if (no == null) {
			if (other.no != null) {
				return false;
			}
		} else if (!no.equals(other.no)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return String.format("%s(%s)",name, no );
	}


	public Object[] toArray() {
		
		return new Object[]{no,name};
	}
	
	
	
	
	
	
}
