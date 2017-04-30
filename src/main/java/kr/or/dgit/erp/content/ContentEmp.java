package kr.or.dgit.erp.content;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import erp_myframework.CheckBoxPanel;
import erp_myframework.ComboPanel;
import erp_myframework.RadioPanel;
import erp_myframework.SpinerPanel;
import erp_myframework.TextFieldForamtPanel;
import erp_myframework.TextFieldPanel;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.service.DepartmentService;
import kr.or.dgit.erp.service.TitleService;

public class ContentEmp extends AbsContentPanel<Employee> {
	private TextFieldPanel pEmpNo;
	private TextFieldPanel pEmpName;
	private SpinerPanel pEmpSalary;
	private ComboPanel<String> pTitle;
	private RadioPanel pGender;
	private CheckBoxPanel phobby;
	private ComboPanel<String> pDept;
	private TextFieldForamtPanel  pdays;
	private SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
	

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
		
		pdays = new TextFieldForamtPanel();
		pdays.setMaskPattern("####-##-##",'#');
		pdays.setTitle("입사일");
		add(pdays);
		setTitleComboData();
		setDeptComboData();
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
		System.out.println(pTitle.getSelectItem());
		Title ti= TitleService.getInstance().selectTitleByNo(new Title(null, (String) pTitle.getSelectItem()));
		boolean gender =pGender.equals("남")?true:false;
		String hobby=" ";
		for(int i=0;i<phobby.getSelectedItems().size();i++){
			 hobby = hobby+phobby.getSelectedItems().get(i).toString().replace('[', ' ').replace(']', ' ')+" ";
		}
		String[] dept = ((String) pDept.getSelectItem()).split(" ");
		Department department= DepartmentService.getInstance().selectDepartmentByNo(new Department(null, dept[0]));
		Date JoinDate=null;
		try {
			JoinDate = sdf.parse(pdays.getTfValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Employee(no, name, ti, salary, gender, hobby.trim(), department, JoinDate);
	}
	
	@Override
	public void setObject(Employee item) {
		pEmpNo.setTfValue(item.getEmpNo());
		pEmpName.setTfValue(item.getEmpName());
		pTitle.setSelectedItem(item.getTitle().toString());
		pEmpSalary.setvalue(item.getSalary());
		pGender.setSelectedItem(item.isGender()?"남":"여");
		String hobby[]=item.getHobbys().split(" ");
		ArrayList<String> list= new ArrayList<>();
		phobby.setClearItems();
		for(int i=0;i<hobby.length;i++){
			list.add(hobby[i]);
		}
		phobby.setSelectedItems(list);
		pDept.setSelectedItem(item.getDepartment().toString());
		pdays.setTfValue(sdf.format(item.getJoinDate()));
		
	}

	@Override
	public void clear() {
		pEmpName.setTfValue("");
		pTitle.setSelectedItem(0);
		pEmpSalary.setvalue(1500000);
		pGender.setSelectedItem(1);
		phobby.setClearItems();
		pDept.setSelectedItem(0);
		
	}
	public void setTitleComboData(){
		List<Title> list= TitleService.getInstance().selectTitleByAll();;
		Vector<String> items= new Vector<>();
		for(Title t:list){
			items.add(t.toString());
		}
		pTitle.setComboData(items);
	}

	public void setDeptComboData(){
		List<Department> list= DepartmentService.getInstance().selectDepartmentByAll();;
		Vector<String> items= new Vector<>();
		for(Department t:list){
			items.add(t.toString());
		}
		pDept.setComboData(items);
	}
	
}
