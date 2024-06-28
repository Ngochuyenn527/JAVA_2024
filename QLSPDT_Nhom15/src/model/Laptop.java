package model;

public class Laptop extends Product {
	private String laptop_type;
	private int laptop_ram;

	public Laptop() {
		super();
	}

	public Laptop(int product_id, String product_name, double product_price, int product_total, String laptop_type,
			int laptop_ram) {
		super(product_id, product_name, product_price, product_total);
		this.laptop_type = laptop_type;
		this.laptop_ram = laptop_ram;
	}

	public String getLaptop_type() {
		return laptop_type;
	}

	public int getLaptop_ram() {
		return laptop_ram;
	}

	public void setLaptop_type(String laptop_type) {
		this.laptop_type = laptop_type;
	}

	public void setLaptop_ram(int laptop_ram) {
		this.laptop_ram = laptop_ram;
	}

	@Override
	public String toString() {
		return "Laptop [laptop_type=" + laptop_type + ", laptop_ram=" + laptop_ram + "]";
	}

	public static Laptop createProduct(int id) {
		String[] productnames = { "Laptop Gaming", "Ultrabook", "Budget Laptop", "Student Laptop" };
		String pn = productnames[(int) (Math.random() * productnames.length)];
		int total = (int) (Math.random() * 100);
		String[] laptopnames = { "Acer nitro 5", "Asus FTX 15", "Dell XPS 13", "Lenovo ThinkPad X1 Carbon",
				"Razer Blade 15", "Microsoft Surface Laptop 4" };
		String tn = laptopnames[(int) (Math.random() * laptopnames.length)];
		double price = (300 + (int) (Math.random() * 600));
		double tprice = Math.round(price * 100) / 100;
		int ram = 8 + 8 * (int) (Math.random() * 2);
		Laptop t = new Laptop(id, tn, tprice, total, pn, ram);
		return t;
	}

}
