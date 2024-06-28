package on_class;

import java.util.ArrayList;

public class MyArrays {
	
	public static int[] generateArray(int n) {
		int[] arrInt = new int[n];

		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = (int) (Math.random() * 10);
		}
		return arrInt;
	}

	public static int[][] generateArray(int rows, int cols) {
		int[][] arrInt = new int[rows][cols];
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = MyArrays.generateArray(cols);
		}
		return arrInt;
	}

	public static Person[] generatePerson(int n) {
		// Mảng trung gian
		Person[] list = new Person[n];

		// Danh sách tên
		String[] firstNames = { "Huyen", "Duong", "Phuong", "Ngoc", "Ha", "May", "Tuan", "Trung" };

		// Danh sách họ
		String[] lastNames = { "Bui", "Nguyen", "Duong", "Ngo", "Tran", "Roan", "Giang", "Trung" };

		// hôm nay là 17/4
		int index;
		for (int i = 0; i < n; i++) {
			list[i] = new Person();

			index = (int) (Math.random() * firstNames.length);
			list[i].setFirstName(firstNames[index]);
			index = (int) (Math.random() * lastNames.length);
			list[i].setLastName(lastNames[index]);

			index = 18 + (int) (Math.random() * 5);
			list[i].setAge((byte) index);

			index = (int) (Math.random() * GENDER.values().length);
			list[i].setGen(GENDER.values()[index]);
		}
		return list;

	}

	public static boolean printArray(int[] arrInt) {
		// Java 5
		for (int value : arrInt) {
			System.out.print(value + " ");
		}
		System.out.println();
		return true;
	}

	public static boolean printArray(int[][] arrInt) {
		for (int[] rows : arrInt) {
			MyArrays.printArray(rows);
		}
		return true;
	}

	public static int[] sortedArray(int[] arrInt, boolean isINC) {
		byte oriented = (byte) (isINC ? 1 : -1);

		for (int i = 1; i < arrInt.length; i++) {
			for (int j = arrInt.length - 1; j >= i; j--) {
				if (arrInt[j] < arrInt[j - 1]) {
					int temp = arrInt[j];
					arrInt[j] = arrInt[j - 1];
					arrInt[j - 1] = temp;
				}
			}
		}
		return arrInt;
	}

	

	public static void printPerson(Person[] list) {
		for(Person p:list) {
			System.out.println(p);
		}
	}
	public static void printPerson(ArrayList<Person> list) {
		list.forEach(p->{
			System.out.println(p);
		});
	}
	// tu lam 
	public static ArrayList<Person> searchPersonV2(Person[] list ,String name) {
		
		ArrayList<Person> results = new ArrayList<Person>() ;
		
		// ghi lai ket qua 
		for(Person p : list) {
			if(p.getFirstName().contains(name)) {
				results.add(p);
			}
		}
		
		return results ;

	}
	
	// chữa về tìm kiếm xong bằng equalInocase ... sau đó là contains như ở dưới 
	public static Person[] search(Person[] list,String name) {
		Person[] results = null ; 
		// đếm số kết quả 
		int count = 0 ; 
		for(Person p : list) {
			if(p.getFirstName().contains(name) || p.getLastName().contains(name)) {
				count++ ; 
			}
		}
		// khởi tạo bộ nhớ cho mảng kết quả 	
		results = new Person[count] ; 
		count = 0 ;
		for(Person p : list) {
			if(p.getFirstName().contains(name) || p.getLastName().contains(name)) {
				results[count++] = p ;
			}
		}
		return results ; 
	}
	public static void main(String[] args) {
		
//		int[] arrInt = MyArrays.generateArray(20);
//		MyArrays.printArray(arrInt);
//		MyArrays.sortedArray(arrInt, true);
//		MyArrays.printArray(arrInt);

		int[][] arrInt = MyArrays.generateArray(2, 3);
		MyArrays.printArray(arrInt);
		
		
		
		Person[] list = MyArrays.generatePerson(20);
		MyArrays.printPerson(list);
		Person[] results = MyArrays.search(list,"Huyen");
		System.out.println("--------------------------------------------");
		System.out.println("Ket qua tim kiem bang mang tinh la:");
		MyArrays.printPerson(results);
		
		ArrayList<Person> result = MyArrays.searchPersonV2(list, "Huyen");
		System.out.println("--------------------------------------------");
		System.out.println("Ket qua tim kiem bang mang dong - ArrayList la:");
		MyArrays.printPerson(result);

	}

}
