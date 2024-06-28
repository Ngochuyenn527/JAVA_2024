package on_class;

public class Address {
	//Constants
	public static final String CITYNAME = "No CityName";
	public static final String DISTRICTNAME = "No DistrictName";
	public static final String STREETNAME = "No StreetName";
	

	//Object's properties
	private String cityName;
	private String districtName;
	private String streetName;
	
	//Constructor methods  //ko có kiểu trả về, 
	public Address() {
		this(Address.CITYNAME, Address.DISTRICTNAME, Address.STREETNAME);
	}
	
	
	public Address(String c, String d, String s) {
		this.cityName = c;
		this.districtName = d;
		this.streetName = s;
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
	

}

