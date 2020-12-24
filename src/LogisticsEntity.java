
public class LogisticsEntity {
	
	private int logistics_id;
	private String start_addr;
	private String end_addr;
	private String dispatch_datetime;
	private String receive_datetime;
	private String vehicle;
	
	//get
	public int get_logistics_id() {
		return logistics_id;
	}
	public String get_start_addr () {
		return start_addr;
	}
	public String get_end_addr () {
		return end_addr;
	}
	public String get_dispatch_datetime () {
		return dispatch_datetime;
	}
	public String get_receive_datetime () {
		return receive_datetime;
	}
	public String get_vehicle () {
		return vehicle;
	}

	//set
	public void set_logistics_id(int logistics_id) {
		this.logistics_id = logistics_id;
	}
	public void set_start_addr (String start_addr) {
		this.start_addr = start_addr;
	}
	public void set_end_addr (String end_addr) {
		this.end_addr = end_addr;
	}
	public void set_dispatch_datetime (String dispatch_datetime) {
		this.dispatch_datetime = dispatch_datetime;
	}
	public void set_receive_datetime (String receive_datetime) {
		 this.receive_datetime = receive_datetime;
	}
	public void set_vehicle (String vehicle) {
		this.vehicle = vehicle;
	}
	
	public String toString() {
		return "LogisticsEntity ["+logistics_id + " " + start_addr + " " + end_addr + " " + dispatch_datetime   + " " + receive_datetime + " " + vehicle +"]";
	}
	
}
