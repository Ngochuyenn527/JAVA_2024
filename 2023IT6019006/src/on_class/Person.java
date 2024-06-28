package on_class;

import on_class.Address;

public class Person {
	
	//Constants
	public static final String FIRSTNAME = "No FirstName";
	public static final String LASTNAME = "No LarstName";
	public static final GENDER GEN = GENDER.UNDEFINE;
	public static final byte AGE = 0;
	public static final Address ADDRESS = new Address();
	
	

	// Object's properties
	private String firstName;
	private String lastName;
	private GENDER gen;
	private byte age;
	
	private Address address;

	// Constructor methods
	public Person() {
		this(Person.FIRSTNAME, Person.LASTNAME ,Person.GEN , Person.AGE,Person.ADDRESS);
	}
	

	public Person(String firstName, String lastName, GENDER gen, byte age, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gen = gen;
		this.age = age;
		this.address = address; // cách 1: gán địa chỉ cho bộ nhớ
//		this.address = new Address(address);  //cách 2: khởi tạo một vùng nhớ mới
	}


	// getter methods
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public GENDER getGen() {
		return gen;
	}

	public byte getAge() {
		return age;
	}

	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Person setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Person setGen(GENDER gen) {
		this.gen = gen;
		return this;
	}

	public Person setAge(byte age) {
		this.age = age;
		return this;
	}

	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Person setAddress(String cityName, String districtName, String streetName) {
		this.address = new Address(cityName, districtName, streetName);
		return this;
	}

	

	public String toString() {
		return age + ", " + gen.name();
//		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", gen=" + gen + ", age=" + age
//				+ ", address=" + address + "]";
	}


	public static void main(String[] args) {
		// Tạo đối tượng
		Person p; //count1
		Person p1 = new Person();

		System.out.println(p1);
		p1.setAge((byte) (18 + (byte) (Math.random() * 5))).setFirstName("Nguyen").setLastName("Anh My").setGen(GENDER.FEMALE); //count3

		System.out.println(p1);

	}
}

enum GENDER {
	MALE, FEMALE, UNDEFINE
}
