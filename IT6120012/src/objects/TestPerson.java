package objects;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address addr = new Address();
		
		Person s = new Student("Bui", "Ngoc Huyenn", (byte)19, addr, 123, "2022604722", "KTPM");
		System.out.println(s.toString());
		
		Person e = new Employee("Bui", "Minh Yen", (byte)33, addr, (long)3000000, "President", 2021, "Nothing");
		System.out.println(e.toString());
	}

}
