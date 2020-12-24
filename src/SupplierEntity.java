
public class SupplierEntity {

	private int supplier_id;
	private String supplier_name;
	private String phone;
	private String email;

	//get
	public int get_supplier_id() {
		return supplier_id;
	}
	
	public String get_supplier_name () {
		return supplier_name;
	}
	public String get_phone () {
		return phone;
	}
	public String get_email () {
		return email;
	}
	//set
	public void set_supplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public void set_supplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public void set_phone (String phone) {
		this.phone = phone;
	}
	public void set_email (String email) {
		this.email = email;
	}
	
	
	public String toString() {
		return "SupplierEntity[ " +supplier_id + " " + supplier_name + " " + phone + " " +  email + "]";
	}
	
}
