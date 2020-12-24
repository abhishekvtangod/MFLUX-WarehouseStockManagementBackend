
public class VehicleEntity {
	
	private int in_wh;
	private String reg_num;
	private String model;
	private String type;
	private String last_maintainence;
	
	//get
	public int get_in_wh() {
		return in_wh;
	}
	public String get_reg_num() {
		return reg_num;
	}
	public String get_model() {
		return model;
	}
	public String get_type() {
		return type;
	}
	public String get_last_maintainence() {
		return last_maintainence;
	}
		
	//set
	
	public void set_in_wh(int in_wh) {
		this.in_wh = in_wh;
	}
	public void set_reg_num(String reg_num) {
		this.reg_num = reg_num;
	}
	public void set_model(String model) {
		this.model = model;
	}
	public void set_type(String type) {
		this.type = type;
	}
	public void set_last_maintainence(String last_maintainence) {
		this.last_maintainence = last_maintainence;
	}
	
	public String toString() {
		return "VehicleEntity ["+" "+reg_num + " " + model+" "+type+" "+last_maintainence+" "+in_wh+" "+"]";
	}
	
	
}
