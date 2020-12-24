
public class WarehouseEntity {

	private int Wid;
	private int is_functional;
	private int capacity;
	private String company;
	private String address;
	private String latitude;
	private String longitude;
	private int supervisor_id;
	
	//get
	public int get_Wid() {
		return Wid;
	}
	public int get_is_functional() {
		return is_functional;
	}
	public int get_capacity() {
		return capacity;
	}
	public int get_supervisor_id() {
		return supervisor_id;
	}
	public String get_company() {
		return company;
	}
	public String get_address() {
		return address;
	}
	public String get_latitude() {
		return latitude;
	}
	public String get_longitude() {
		return longitude;
	}
	
	//set
	public void set_Wid(int Wid) {
		this.Wid = Wid;
	}
	public void set_is_functional(int is_functional) {
		this.is_functional = is_functional;
	}
	public void set_capacity(int capacity) {
		this.capacity = capacity;
	}
	public void set_supervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}
	public void set_company(String company) {
		this.company = company;
	}
	public void set_address(String address) {
		this.address = address;
	}
	public void set_latitude(String latitude) {
		this.latitude = latitude;
	}
	public void set_longitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
	public String toString() {
		return "WarehouseEntity ["+Wid+" "+is_functional+" "+capacity+" "+company+" "+address+" "+latitude+" "+longitude+" "+supervisor_id+"]";
	}
	
	
}
