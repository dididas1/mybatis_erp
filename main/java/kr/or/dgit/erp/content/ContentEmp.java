package kr.or.dgit.erp.content;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import erp_myframework.CheckBoxPanel;
import erp_myframework.ComboPanel;
import erp_myframework.DatePanel;
import erp_myframework.RadioPanel;
import erp_myframework.SpinerPanel;
import erp_myframework.TextFieldPanel;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;

public class ContentEmp extends AbsContentPanel<Employee> {
	private TextFieldPanel pEmpNo;
	private TextFieldPanel pEmpName;
	private SpinerPanel pEmpSalary;
	private ComboPanel<Title> pTitle;
	private RadioPanel pGender;
	private CheckBoxPanel phobby;
	private ComboPanel<Department> pDept;
	private DatePanel  pdays;
	

	public ContentEmp() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pEmpNo = new TextFieldPanel();
		pEmpNo.setTitle("번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldPanel();
		pEmpName.setTitle("사원명");
		add(pEmpName);
		
		pTitle = new ComboPanel<>();
		pTitle.setTitle("직책");
		add(pTitle);
		
		pEmpSalary = new SpinerPanel();
		pEmpSalary.setTitle("급여");
		pEmpSalary.setvalues(1500000, 1000000, 5000000, 100000);
		add(pEmpSalary);
		
		pGender = new RadioPanel();
		pGender.setTitle("성별");
		pGender.setRaidoItems("남","여");
		add(pGender);
		
		phobby = new CheckBoxPanel();
		phobby.setTitle("취미");
		phobby.setCheckItems("볼링","야구","축구");
		add(phobby);
		
		pDept = new ComboPanel<>();
		pDept.setTitle("부서");
		add(pDept);
		
		pdays = new DatePanel();
		pdays.setTitle("입사일");
		add(pdays);

	}

	@Override
	public TextFieldPanel getpNo() {
		return pEmpNo;
	}

	@Override
	public TextFieldPanel getpName() {
		return pEmpName;
	}

	@Override
	public Employee getObject() {
		String no= pEmpNo.getTfValue();
		String name= pEmpName.getTfValue();
		int salary= (int) pEmpSalary.getvalue();
		Title ti= (Title) pTitle.getSelectItem();
		boolean gender =pGender.equals("남")?true:false;
		ArrayList<String> hobbys= new ArrayList<>();
		for(String h:phobby.getSelectedItems()){
			hobbys.add(h);
		}
		Department department= (Department) pDept.getSelectItem(); 
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
		Date JoinDate=null;
		try {
			JoinDate = sdf.parse(pdays.getTfDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Employee(no, name, ti, salary, gender, hobbys, department, JoinDate);
	}
	
	public void setTitles(Vector<Title> titles){
		pTitle.setComboData(titles);
	}
	public void setDepartment(Vector<Department> dept){
		pDept.setComboData(dept);
	}
	@Override
	public void setObject(Employee item) {
		pEmpNo.setTfValue(item.getNo());
		pEmpName.setTfValue(item.getName());
		pTitle.setSelectedItem(item.getTitle());
		pEmpSalary.setvalue(item.getSalary());
		pGender.setSelectedItem(item.isGender()?"남":"여");
		phobby.setSelectedItems(item.getHobbys());
		pDept.setSelectedItem(item.getDepartment());
		pdays.setTfDate(String.format("%tf", item.getJoinDate()));
		
	}

	@Override
	public void clear() {
		pEmpName.setTfValue("");
		pTitle.setSelectedItem(1);
		pEmpSalary.setvalue(1500000);
		pGender.setSelectedItem(1);
		phobby.setClearItems();
		pDept.setSelectedItem(1);
		
	}

	
}
