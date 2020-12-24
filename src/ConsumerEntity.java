
public class ConsumerEntity {
	
	private int consumer_id;
	private String consumer_name;
	private String phone;
	private String email;
	
	//get
	public int get_consumer_id () {
		return consumer_id;
	}
	public String get_consumer_name () {
		return consumer_name;
	}
	public String get_phone () {
		return phone;
	}
	public String get_email () {
		return email;
	}
		
	//set
	public void set_consumer_id(int consumer_id) {
		this.consumer_id = consumer_id;
	}
	public void set_consumer_name (String consumer_name) {
		this.consumer_name = consumer_name;
	}
	public void set_phone (String phone) {
		this.phone = phone;
	}
	public void set_email (String email) {
		this.email = email;
	}
		
	
	public String toString() {
		return "ConsumerEntity ["+ consumer_id + " " + consumer_name + " " + phone + " " + email + "]";
	}
	
}
