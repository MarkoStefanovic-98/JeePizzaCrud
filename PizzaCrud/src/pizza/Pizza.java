package pizza;

public class Pizza {
	
	private int id; 
	private String DesignPizz;
	private Double price;
	private String Description;
	
	public Pizza(int id, String DesignPizz, Double price, String Description) {
		this.id = id;
		this.DesignPizz = DesignPizz;
		this.price = price;
		this.Description = Description;
	}
	public Pizza(String designPizz2, Double tarifPizz, String description2) {
		// TODO Auto-generated constructor stub
	}
	public Pizza() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignPizz() {
		return DesignPizz;
	}
	public void setDesignPizz(String designPizz) {
		DesignPizz = designPizz;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
}
