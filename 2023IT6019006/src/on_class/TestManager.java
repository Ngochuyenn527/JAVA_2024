
package on_class;

//import java.util.ArrayList;
import java.util.HashMap;

public class TestManager {

//	public static ArrayList<Manager> generatePerson(int n) {
	public static HashMap<Manager, Person> generatePerson(int n) {

//		ArrayList<Manager> list = new ArrayList<>(n);
		HashMap<Manager, Person> list = new HashMap<>(n);

		Person p = null;
		Manager m = null;
		int index;
		for (int i = 0; i < n; i++) {
			// Sinh viên ngẫu nhiên tuổi
			index = 18 + (int) (Math.random() * 20);

			if (index <= 22) {
				p = new Student();
				m = new StudentManager();
			} else {
				p = new Staff();
				m = new StaffManager();
			}

			p.setAge((byte) index);

			// Giới tính
			index = (int) (Math.random() * GENDER.values().length);
			p.setGen(GENDER.values()[index]);

//			list.add(m);
			list.put(m, p);
			
			System.out.println(m.getDetails(p));
		}
		return list;
	}

	public static void printInfo(HashMap<Manager, Person> list) {
		list.forEach((m,p) -> {
			System.out.println(m.getDetails(p));
		});
	}

	public static void main(String[] args) {

		HashMap<Manager, Person> list = TestManager.generatePerson(50);
//		TestPerson.printInfo(list);

	}
}
