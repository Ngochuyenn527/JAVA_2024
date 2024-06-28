package on_class;

import java.util.ArrayList;

public class TestPerson {

	public static ArrayList<Person> generatePerson(int n) {
		ArrayList<Person> list = new ArrayList<>(n);

		Person p = null;
		int index;
		for (int i = 0; i < n; i++) {
			// Sinh viên ngẫu nhiên tuổi
			index = 18 + (int) (Math.random() * 20);

			if (index <= 22) {
				p = new Student();
			} else {
				p = new Staff();
			}

			p.setAge((byte) index);

			// Giới tính
			index = (int) (Math.random() * GENDER.values().length);
			p.setGen(GENDER.values()[index]);

			list.add(p);
		}
		return list;
	}

	public static void printInfo(ArrayList<Person> list) {
		list.forEach(p -> {
			System.out.println(p);
		});
	}

	public static void main(String[] args) {

		ArrayList<Person> list = TestPerson.generatePerson(50);
		TestPerson.printInfo(list);
	}
}

