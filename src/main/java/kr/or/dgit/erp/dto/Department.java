package kr.or.dgit.erp.dto;

import java.io.Serializable;

public class Department implements Serializable{
	private String deptNo;
	private String deptName;
	private int floor;
	private boolean isExist;
	
	public Department() {
	}
	
	public Department(String deptNo) {
		this.deptNo = deptNo;
	}




	public Department(String deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public Department(String deptNo, String deptName, int floor) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}


	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public boolean isExist() {
		return isExist;
	}
	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	@Override
	public String toString() {
		return String.format("%s %s", deptName, floor);
	}
	
	public Object[] toArray() {
		return new Object[]{deptNo, deptName, floor};
	}
	
	
}
