package on_class;

public class Staff extends Person {
	
	public static final int STAFF_ID = 0;
	public static final String STAFF_POSITION = "";
	public static final String STAFF_NET = "";
	public static final short STAFF_APPLY = 0;

	private int staff_id;
	private String staff_position;
	private String staff_net;
	private short staff_apply;

	public Staff() {

	}

	public Staff(String firstName, String lastName, GENDER gen, byte age, Address address, int staff_id,
			String staff_position, String staff_net, short staff_apply) {
		super(firstName, lastName, gen, age, address);
		this.staff_id = staff_id;
		this.staff_position = staff_position;
		this.staff_net = staff_net;
		this.staff_apply = staff_apply;
	}

	public static int getStaffId() {
		return STAFF_ID;
	}

	public static String getStaffPosition() {
		return STAFF_POSITION;
	}

	public static String getStaffNet() {
		return STAFF_NET;
	}

	public static short getStaffApply() {
		return STAFF_APPLY;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public String getStaff_position() {
		return staff_position;
	}

	public String getStaff_net() {
		return staff_net;
	}

	public short getStaff_apply() {
		return staff_apply;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public void setStaff_position(String staff_position) {
		this.staff_position = staff_position;
	}

	public void setStaff_net(String staff_net) {
		this.staff_net = staff_net;
	}

	public void setStaff_apply(short staff_apply) {
		this.staff_apply = staff_apply;
	}

	@Override
	public String toString() {
		return "Staff [" + super.toString()+ ":SD = "+ staff_id + "]";
//		return "Staff [" + super.toString() + "staff_id=" + staff_id + ", staff_position=" + staff_position
//				+ ", staff_net=" + staff_net + ", staff_apply=" + staff_apply + "]";
	}
	
	public static void main(String[] args) {
		
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Phố Nhổn");
		
		Staff s = new Staff("Chiến", "Đào Duy", GENDER.MALE, (byte)20, addr, 10, "Nhân viên", "23_000_000", (short)2025);
		
		System.out.println(s);
	}

}
