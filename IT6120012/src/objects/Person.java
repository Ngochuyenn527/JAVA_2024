package objects;

public class Person {
	// Constants - first of code
	public static final String FIRSTNAME = "No FirstName";
	public static final String LASTNAME = "No LarstName";
	public static final byte AGE = 0;
	public static final Address ADDRESS = new Address();

	// Classes' variables
	private static int count = 0;

	// Object's properties
	private String firstName;
	protected String lastName;
	private byte age;
	private Address address;

	// Constructor methods
	public Person() {
		// Đặc biệt loại 1
//		this.firstName = "No Firstname";
//		this.lastName = "No Lastname";
//		this.age = 0;

//		this("No Firstname", "No Lastname", (byte)0);

		this(Person.FIRSTNAME, Person.LASTNAME, Person.AGE, Person.ADDRESS);
	}

	public Person(byte age) {
//		this.firstName = "No Firstname";
//		this.lastName = "No Lastname";
//		this.age = age;

//		this("No Firstname", "No Lastname", age);

		this(Person.FIRSTNAME, Person.LASTNAME, age, Person.ADDRESS);

	}

	public Person(String f, byte age) {
//		this.firstName =f;
//		this.lastName = "No lastName";
//		this.age = age;

//		this(f, "No Lastname", age);

		this(f, Person.LASTNAME, age, Person.ADDRESS);

	}

	public Person(String f, String l, byte age, Address address) {
		// Đặc biệt loại 2
		this.firstName = f;
		this.lastName = l;
		this.age = age;
		// cach1 : gán địa chỉ trong bộ nhớ
		this.address = address;

		// cach2: khởi tạo bộ nhớ mới và sao chép giá trị
		//this.address = new Address(address);

		// Tăng biến đếm đối tượng
		Person.count++;
	}
	
	

	// Getter methods
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public byte getAge() {
		return this.age;
	}
	
	

	// Setter methods
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//		return;
//	}
//	
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//		return;
//	}
//	
//	public void setAge(byte age) {
//		this.age = age;
//		return;
//	}

	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Person setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Person setAge(byte age) {
		this.age = age;
		return this;
	}
	
	public Person setAddress(Address address) {
		this.address = new Address(address);
		return this;
	}
	
	public Person setAddress(String cityName, String districtName, String streetName) {
		this.address = new Address(cityName, districtName, streetName);
		return this;
	}

	@Override
	public String toString() {
//		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address+ "]";
		return  lastName +" " + firstName + " " + age + " tuoi";
	}

	public static int getCountPerson() {
		return Person.count;
	}

	protected void finalize() throws Throwable {
		// giamr số đối tượng
		Person.count--;
	}

	public static void main(String[] args) {
		// khai báo đối tượng
		
		Address addr1 = new Address();
		Address addr2 = new Address("HaNoi", "BacTuLiem", "Pho nhon");
		Address addr3 = new Address(addr2); // sao chép thông tin của addr2
		addr3.setstreetName("Kieu Mai"); // thay đổi địa chỉ của addr2 thông qua addr3
		
		Person p;
		Person p1 = new Person();
		Person p2 = new Person((byte) 19);
		Person p3 = new Person("Huyenn", (byte) 19);
		Person p4 = new Person("Huyenn", "Ngoc", (byte) 19, addr1);
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
		System.out.println(p4);
		
		p4.setAddress(addr3);
		System.out.println(p4);
		
		addr1.setCityName("Thai Binh");
		System.out.println(p4);


//		p1.setFirstName("Ngoc");
//		p1.setLastName("Huyenn");
//		p1.setAge((byte)19);
//		System.out.println(p1);

//		p1.setFirstName("Ngoc").setLastName("Huyenn").setAge((byte)19);
//		System.out.println(p1);

		System.out.println("So doi tuong la: " + Person.getCountPerson());
	}
}
