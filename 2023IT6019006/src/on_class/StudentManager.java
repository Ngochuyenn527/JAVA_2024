package on_class;

public class StudentManager extends Manager {

	@Override
	public String getInfo(Person p) {
		// TODO Auto-generated method stub
		return "Student Manager - " + p.toString();
	}

}
