package objects;

public class Employee extends Person{
	//Constants
	public static final long EMPLOYEE_NET = 0;
	public static final String EMPLOYEE_POSITION = "NONE";
	public static final int EMPLOYEE_APPLYYEAR = 0;
	public static final String EMPLOYEE_NOTES = "NONE";
	
	
	//Employee's properties
	private long employee_net;
	private String employee_position;
	private int employee_applyyear;
	private String employee_notes;
	
	
	//Constructor methods
	public Employee() {
		this(Employee.FIRSTNAME, Employee.LASTNAME, Employee.AGE, Employee.ADDRESS, Employee.EMPLOYEE_NET, Employee.EMPLOYEE_POSITION, Employee.EMPLOYEE_APPLYYEAR, Employee.EMPLOYEE_NOTES);
	}
	
	public Employee(String f, String l, byte age, Address address,
			long employee_net, String employee_position, int employee_applyyear, String employee_notes) {
		super(f, l, age, address);
		
		this.employee_net = employee_net;
		this.employee_position = employee_position;
		this.employee_applyyear = employee_applyyear;
		this.employee_notes = employee_notes;
	}

	public long getEmployee_net() {
		return employee_net;
	}

	public String getEmployee_position() {
		return employee_position;
	}

	public int getEmployee_applyyear() {
		return employee_applyyear;
	}

	public String getEmployee_notes() {
		return employee_notes;
	}

	public void setEmployee_net(long employee_net) {
		this.employee_net = employee_net;
	}

	public void setEmployee_position(String employee_position) {
		this.employee_position = employee_position;
	}

	public void setEmployee_applyyear(int employee_applyyear) {
		this.employee_applyyear = employee_applyyear;
	}

	public void setEmployee_notes(String employee_notes) {
		this.employee_notes = employee_notes;
	}

	@Override
	public String toString() {
		return "Employee ["+super.toString()+", ENet=" + employee_net + ", EP=" + employee_position
				+ ", EA=" + employee_applyyear + ", ENotes=" + employee_notes + "]";
	}
	
	public static void main(String[] args) {
		Address addr = new Address();
		
		Person e = new Employee("Bui", "Minh Yen", (byte)33, addr, (long)3000000, "President", 2021, "Nothing");
		System.out.println(e.toString());

	}
	
	
	
	
	
	
	
	
	

}
