package kr.or.dgit.erp.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Employee implements Serializable{
	private String empNo;
	private String empName;
	private Title title;
	private int Salary;
	private boolean gender;
	private String hobbys;
	private Department department;
	private Date joinDate;
	private boolean isExist;

	

	public Employee() {
	}
	
	

	public Employee(String empNo) {
		this.empNo = empNo;
	}


	public Employee(String empNo, String empName, Title title, int salary, boolean gender, String hobbys,
			Department department, Date joinDate) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		Salary = salary;
		this.gender = gender;
		this.hobbys = hobbys;
		this.department = department;
		this.joinDate = joinDate;
	}



	public String getEmpNo() {
		return empNo;
	}



	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public Title getTitle() {
		return title;
	}



	public void setTitle(Title title) {
		this.title = title;
	}



	public int getSalary() {
		return Salary;
	}



	public void setSalary(int salary) {
		Salary = salary;
	}



	public boolean isGender() {
		return gender;
	}



	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public String getHobbys() {
		return hobbys;
	}



	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public Date getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}



	public boolean isExist() {
		return isExist;
	}



	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}



	@Override
	public String toString() {
		return String.format(
				"Employee [no=%s, name=%s, title=%s, Salary=%s, gender=%s, hobbys=%s, department=%s, joinDate=%s]", empNo,
				empName, title, Salary, gender, hobbys, department, joinDate);
	}



	public Object[] toArray() {
		return new Object[]{empNo,empName,title,Salary,gender?"남":"여",hobbys,department,joinDate};
	}


}
