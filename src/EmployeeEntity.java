
public class EmployeeEntity {
	
	private int empid;
	private int emp_sal;
	private int wid;
	private String emp_name;
	private String emp_shift;
	
	//get
	public int get_empid () {
		return empid;
	}
	public int get_emp_sal () {
		return emp_sal;
	}
	public int get_wid () {
		return wid;
	}
	
	public String get_emp_name () {
		return emp_name;
	}
	public String get_emp_shift () {
		return emp_shift;
	}
	
	//set
	public void set_empid (int empid) {
		this.empid = empid;
	}
	public void set_emp_sal (int emp_sal) {
		this.emp_sal = emp_sal;
	}
	public void set_wid (int wid) {
		this.wid = wid;
	}
	
	public void set_emp_name (String emp_name) {
		this.emp_name = emp_name;
	}
	public void set_emp_shift (String emp_shift) {
		this.emp_shift = emp_shift;
	}
	
	public String toString() {
		return "EmployeeEntity ["+" "+ empid + " "+ emp_name + " " + emp_shift + " " +emp_sal+" "+wid +" "+"]";
	}
	
	
	
}
