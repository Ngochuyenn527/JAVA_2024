package objects;

public class Address {
	//Constants
	public static final String CITYNAME = "No CityName";
	public static final String DISTRICTNAME = "No DistrictName";
	public static final String STREETNAME = "No StreetName";
	
	//Classes' variables
	private static int count=0;
	
	//Object's properties
	private String cityName;
	private String districtName;
	private String streetName;
	
	//Constructor methods  //ko có kiểu trả về, 
	public Address() {
		this(Address.CITYNAME, Address.DISTRICTNAME, Address.STREETNAME);
	}
	
	public Address(String c) {
		this(c, Address.DISTRICTNAME, Address.STREETNAME);
	}
	
	public Address(String c, String d) {
		this(c, d, Address.STREETNAME);
	}
	public Address(String c, String d, String s) {
		this.cityName = c;
		this.districtName = d;
		this.streetName = s;
		
		//Tăng biến đếm đối tượng
		Address.count++;
	}
	
	public Address(Address addr) {
		this(addr.getCityName(), addr.getDistrictName(), addr.getStreetName());
	}

	//Getter methods
	public String getCityName() {
		return this.cityName;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public String getStreetName() {
		return this.streetName;
	}
	
	//Setter methods
	public Address setCityName(String cityName) {
		this.cityName = cityName;
		return this;
	}
	
	public Address setDistrictName(String districtName) {
		this.districtName = districtName;
		return this;
	}

	public Address setstreetName(String streetName) {
		this.streetName = streetName;
		return this;
	}

	@Override
	public String toString() {
		return "Address [CN=" + cityName + ", DN=" + districtName + ", SN=" + streetName + "]";
	}
	
	public static int getCountAddress() {
		return Address.count;
	}
	
	public static void main(String[] args) {
		Address a1 = new Address();
		Address a2 = new Address("HANOI");
		Address a3 = new Address("HANOI","PHUXUYEN");
		Address a4 = new Address("HANOI","PHUXUYEN","HHHH");
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println("So doi tuong la: " + Address.getCountAddress());


	}

}
