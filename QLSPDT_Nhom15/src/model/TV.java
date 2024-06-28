package model;

import java.io.Serializable;

public class TV extends Product implements Serializable {
	private String TV_size;
	private String TV_brand;
	private String TV_typescreen;

	public TV() {

	}

	public TV(int product_id, String product_name, double product_price, int product_total, String TV_size,
			String TV_brand, String TV_typescreen) {
		super(product_id, product_name, product_price, product_total);
		this.TV_size = TV_size;
		this.TV_brand = TV_brand;
		this.TV_typescreen = TV_typescreen;
	}

	public String getTV_size() {
		return TV_size;
	}

	public String getTV_brand() {
		return TV_brand;
	}

	public String getTV_typescreen() {
		return TV_typescreen;
	}

	public void setTV_size(String TV_size) {
		this.TV_size = TV_size;
	}

	public void setTV_brand(String TV_brand) {
		this.TV_brand = TV_brand;
	}

	public void setTV_typescreen(String TV_typescreen) {
		this.TV_typescreen = TV_typescreen;
	}

	@Override
	public String toString() {
		return "TV [" + super.toString() + ", size=" + TV_size + ", brand=" + TV_brand + ", typescreen=" + TV_typescreen
				+ "]";
	}

	public static TV createProduct(int id) {
		String[] name = { "TV C1", "OLED ", "XR ", "TCLTV ", "TV P-Series", "Hisense U8G", "Philips 806", "TV A80J",
				"TV (R635)" };
		String[] typescreen = { "4k,'HD", "LCD", "OLED" };

		String[] manufacturer = { "Samsung", "LG", "xiaomi", "Sony", "Bravia", "Vizio" };

		int cnt;
		cnt = (int) (Math.random() * 100);
		TV m = new TV();
		m.setProduct_id(id);
		cnt = (int) (Math.random() * (name.length));
		m.setProduct_name(name[cnt]);

		m.setProduct_price((int) (Math.random() * 100000));

		m.setProduct_total((int) (Math.random() * 5) * 10);

		cnt = (int) (Math.random() * manufacturer.length);
		m.setTV_brand(manufacturer[cnt]);

		m.setTV_size((int) (Math.random() * 60) + "inch");

		m.setTV_typescreen(typescreen[(int) (Math.random() * typescreen.length)]);
		return m;

	}
}
