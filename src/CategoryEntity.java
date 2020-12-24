
public class CategoryEntity {
	private String category_name;
	
	//get
	public String get_category_name() {
		return category_name;
	}
	//set
	public void set_category_name(String category_name) {
		this.category_name = category_name;
	}
	
	public String toString() {
		return "CategoryEntity ["+category_name+"]";
	}
}
