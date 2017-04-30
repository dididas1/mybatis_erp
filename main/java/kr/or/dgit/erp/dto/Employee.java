package kr.or.dgit.erp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Employee implements Serializable{
	private String no;
	private String name;
	private Title title;
	private int Salary;
	private boolean gender;
	private ArrayList<String> hobbys;
	private Department department;
	private Date joinDate;
	public Employee(String no) {
		this.no = no;
	}
	




	public Employee(String no, String name, int salary) {
		this.no = no;
		this.name = name;
		Salary = salary;
	}





	public Employee(String no, String name, Title title, int salary, boolean gender, ArrayList<String> hobbys,
			Department department, Date joinDate) {
		this.no = no;
		this.name = name;
		this.title = title;
		Salary = salary;
		this.gender = gender;
		this.hobbys = hobbys;
		this.department = department;
		this.joinDate = joinDate;
	}
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public Title getTitle() {
		return title;
	}
	public int getSalary() {
		return Salary;
	}
	public boolean isGender() {
		return gender;
	}
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	public Department getDepartment() {
		return department;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
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
		return String.format(
				"Employee [no=%s, name=%s, title=%s, Salary=%s, gender=%s, hobbys=%s, department=%s, joinDate=%s]", no,
				name, title, Salary, gender, hobbys, department, joinDate);
	}
	

	
public Object[] toArray() {
		
		return new Object[]{no,name,title,Salary,gender?"남":"여",hobbys,department,joinDate};
	}
	
	
}
