package kr.or.dgit.erp.content;

import java.awt.GridLayout;

import erp_myframework.TextFieldPanel;
import kr.or.dgit.erp.dto.Department;

@SuppressWarnings("serial")
public class ContentDepartment extends AbsContentPanel<Department> {
	private TextFieldPanel pDeptNo;
	private TextFieldPanel pDeptName;
	private TextFieldPanel pDeptFloor;
	public ContentDepartment() {
		setLayout(new GridLayout(0, 1, 0, 0));

		pDeptNo = new TextFieldPanel();
		pDeptNo.setTitle("부서번호");
		add(pDeptNo);

		pDeptName = new TextFieldPanel();
		pDeptName.setTitle("부서명");
		add(pDeptName);

		pDeptFloor = new TextFieldPanel();
		pDeptFloor.setTitle("위치");
		add(pDeptFloor);
	}
	public void clear(){
		pDeptName.setTfValue("");
		pDeptFloor.setTfValue("");
		pDeptName.getTf().requestFocus();
	}

	@Override
	public TextFieldPanel getpNo() {
		return pDeptNo;
	}

	@Override
	public TextFieldPanel getpName() {
		return pDeptName;
	}


	@Override
	public Department getObject() {
		String no = pDeptNo.getTfValue();
		String name = pDeptName.getTfValue();
		int floor = Integer.parseInt(pDeptFloor.getTfValue());
		return new Department(no, name, floor);
	}

	@Override
	public void setObject(Department item) {
		pDeptNo.setTfValue(item.getDeptNo());
		pDeptName.setTfValue(item.getDeptName());
		pDeptFloor.setTfValue(item.getFloor()+"");

	}
}