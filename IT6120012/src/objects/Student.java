package objects;


public class Student extends Person {
	//Constants
	public static final int STUDENT_ID = 0;
	public static final String STUDENT_CODE = "2022604722";
	public static final String STUDENT_SPECIALY = "NONE";
	
	//Student's properties
	private int student_id; 
	private String student_code;
	private String student_specialy; //chuyen nganh hoc
	
	//Constructor methods
	
	public Student(){
		this(Student.FIRSTNAME, Student.LASTNAME, Student.AGE, Student.ADDRESS,Student.STUDENT_ID, Student.STUDENT_CODE, Student.STUDENT_SPECIALY);
	}
	//truyền đúng cấu trúc, đúng thứ tự
	
	
	public Student(String f, String l, byte age, Address address, 
			int student_id, String student_code, String student_specialy) {
		//khởi tạo lớp đối tượng cha (Person)
		super(f, l, age, address);
		
		//gán giá trị cho các thuộc tính đối tượng con(Student)
		this.student_id = student_id;
		this.student_code = student_code;
		this.student_specialy = student_specialy;
	}


	public int getStudent_id() {
		return student_id;
	}


	public String getStudent_code() {
		return student_code;
	}


	public String getStudent_specialy() {
		return student_specialy;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}


	public void setStudent_specialy(String student_specialy) {
		this.student_specialy = student_specialy;
	}


	@Override //ghi đè pt: 1 pt được viết đi viết lại nhiều lần trên các lớp đt khác nhau mà có quan hệ cha con

	//muốn lấy cả tostring bên Person => "+super.toString()+"
	public String toString() {
		return "Student ["+super.toString()+ ", SI=" + student_id + ", SC=" + student_code + ", SS="+ student_specialy + "]";
	}
	
	public static void main(String[] args) {
		
		Address addr = new Address();
		//tao sv    cha = new con
		
		Person s = new Student("Bui", "Ngoc Huyenn", (byte)19, addr, 123, "2022604722", "KTPM");
		System.out.println(s.toString());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
