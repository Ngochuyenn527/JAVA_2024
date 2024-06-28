package on_class;

public class Student extends Person{
	
	public static final int STUDENT_ID = 0;
	public static final String STUDENT_MANAGE_ID = "(2023)0000000";
	public static final String SPECIALY = "NONE";

	// Student property
	private int student_id;
	private String student_manage_id;
	private String specialy;

	public Student() {
		this(Student.FIRSTNAME, Student.LASTNAME, Student.GEN, Student.AGE, Student.ADDRESS, Student.STUDENT_ID,
				Student.STUDENT_MANAGE_ID, Student.SPECIALY);
	}

	public Student(String firstName, String lastName, GENDER gen, byte age, Address address, int student_id,
			String student_manage_id, String specialy) {

		// Khởi tạo lớp đối tượng cha (Person)
		super(firstName, lastName, gen, age, address);

		// Gán các giá trị cho thuộc tính lớp con (Student)
		this.student_id = student_id;
		this.student_manage_id = student_manage_id;
		this.specialy = specialy;
	}

	public static int getStudentId() {
		return STUDENT_ID;
	}

	public static String getStudentManageId() {
		return STUDENT_MANAGE_ID;
	}

	public static String getSpecialy1() {
		return SPECIALY;
	}

	public int getStudent_id() {
		return student_id;
	}

	public String getStudent_manage_id() {
		return student_manage_id;
	}

	public String getSpecialy() {
		return specialy;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public void setStudent_manage_id(String student_manage_id) {
		this.student_manage_id = student_manage_id;
	}

	public void setSpecialy(String specialy) {
		this.specialy = specialy;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString()+ ": SI = "+ student_id  + "]";

//		return "Student [" + super.toString() + ", student_id=" + student_id + ", student_manage_id=" + student_manage_id + ", specialy="
//				+ specialy + "]";
	}
	
	public static void main(String[] args) {
		
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Phố Nhổn");
		
		Student st = new Student("Chiến", "Đào Duy", GENDER.MALE, (byte)20, addr, 10, "2022601653", "CNTT");
		
		System.out.println(st);
		
	}

}
