
public class GoodsEntity {
	private int goods_id;
	private int is_sensitive;
	private int storage;
	private int weight;
	private int cost;
	private int arrival;
	private int supplier;
	private int departure;
	private int consumer;
	private String goods_name;
	private String category;
	
	//get
	public int get_goods_id () {
		return goods_id;
	}
	public int get_is_sensitive () {
		return is_sensitive;
	}
	public int get_storage () {
		return storage;
	}
	public int get_weight () {
		return weight;
	}
	public int get_cost () {
		return cost;
	}
	public int get_arrival () {
		return arrival;
	}
	public int get_supplier () {
		return supplier;
	}
	public int get_departure () {
		return departure;
	}
	public int get_consumer () {
		return consumer;
	}
	public String get_goods_name () {
		return goods_name;
	}
	public String get_category () {
		return category;
	}
	
	//set
	public void set_goods_id (int goods_id) {
		this.goods_id = goods_id;
	}
	public void set_is_sensitive (int is_sensitive) {
		this.is_sensitive = is_sensitive;
	}
	public void set_storage (int storage) {
		this.storage = storage;
	}
	public void set_weight (int weight) {
		this.weight = weight;
	}
	public void set_cost (int cost) {
		this.cost =  cost;
	}
	public void set_arrival (int arrival) {
		this.arrival = arrival;
	}
	public void set_supplier (int supplier) {
		this.supplier = supplier;
	}
	public void set_departure (int departure) {
		this.departure = departure;
	}
	public void set_consumer (int consumer) {
		this.consumer = consumer;
	}
	public void set_goods_name (String goods_name) {
		this.goods_name = goods_name;
	}
	public void set_category (String category) {
		this.category = category;
	}
	
	
	
	public String toString() {
		return "GoodsEntity["+ goods_id + " " + goods_name + " " + is_sensitive + " " + storage + " " + weight + " " + cost   + " " + category + " " + arrival + " " + supplier + " " + departure + " " + consumer + "]";
	}
}
