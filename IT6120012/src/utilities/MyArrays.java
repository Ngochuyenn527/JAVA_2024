package utilities;

import objects.*;

import java.util.*;

/**
 * Sinh ngẫu nhiên mảng nguyên int 1 chiều với n phần tử
 * 
 * @param - số phần tử của mảng n
 * @return - mảng có giá trị ngẫu nhiên trong khoảng [0-100) sx snt first, else
 *         sau
 */

public class MyArrays {
	public static int[] generateArray(int n) {
		int[] arrInt = new int[n];
		for (int i = 0; i < n; i++) {
			arrInt[i] = (int) (Math.random() * 100);
		}
		return arrInt;
	}

	// muốn dùng Person cần phải import objects.*
	public static Person[] generatePerson(int n) {
		// Mảng trung gian
		Person[] list = new Person[n];

		// Danh sách tên
		String[] firstNames = { "Huyen", "Duong", "Phuong", "Ngoc", "Ha", "May", "Tuan", "Trung" };

		// Danh sách họ
		String[] lastNames = { "Bui", "Nguyen", "Duong", "Ngo", "Tran", "Roan", "Giang", "Trung" };

		// Sinh ngẫu nhiên phần tử mảng
		int index;
		for (int i = 0; i < list.length; i++) {
			// Cấp phát bộ nhớ cho phần tử mảng
			list[i] = new Person();

			// Ngẫu nhiên tên
			index = (int) (Math.random() * firstNames.length);
			list[i].setFirstName(firstNames[index]);

			// Ngẫu nhiên họ
			index = (int) (Math.random() * lastNames.length);
			list[i].setLastName(lastNames[index]);

			// Ngẫu nhiên tuổi
			index = 18 + (int) (Math.random() * 5);
			list[i].setAge((byte) index);
		}
		return list;
	}

	// bubbleSort tang dan
	public static int[] sortedArray(int[] arrInt, boolean isINC) {
		// xác định hướng sắp xếp
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

	public static int[] filterArray(int[] arrInt, boolean isINC) {
		int[] temp1 = new int[arrInt.length]; // lưu nguyên tố
		int[] temp2 = new int[arrInt.length]; // lưu 0 nguyên tố
		int t1 = 0, t2 = 0;
		for (int value : arrInt) {
			if (basic.Example3.isPrime(value)) {
				temp1[t1++] = value;
			} else {
				temp2[t2++] = value;
			}
		}

		// gộp mảng temp2 vào sau temp1
		for (int i = t1; i < temp1.length; i++) {
			temp1[i] = temp2[i - t1];
		}
		return temp1;
	}
	
//Tìm kiếm kiểu mảng tĩnh
	public static Person[] searchPerson(Person[] list, String name) {
		//Khai báo mảng kết quả
		//Person [] results = new Person[list.length];
		Person [] results = null;
		//đếm số kết quả
		int count =0;
		for(Person p : list) {
			//muốn so sánh phải dùng equalsIgnoreCase
			//if(p.getFirstName() == name) => SAI
			if(p.getFirstName().equalsIgnoreCase(name)){
				count++;
			}
		}
		//.equalsIgnoreCase(name): tên ý
		//.contains(name): chuỗi chứa cái tên ý
		
		//khởi tạo bộ nhớ
		results = new Person[count];
		
		//ghi nhận kết quả
		count =0;
		for(Person p : list) {
			if(p.getFirstName().equalsIgnoreCase(name)) {
				results[count++] = p;
			}
		}
		return results;
	}

	
//Tìm kiếm kiểu mảng động
	public static ArrayList<Person> searchPersonV2(Person [] list, String name){
		//Mảng trung gian
		ArrayList<Person> results2 = new ArrayList<Person>() ;
		
		//Ghi nhận
		//.equalsIgnoreCase(name): tên ý
		//.contains(name): chuỗi chứa cái tên ý
		for(Person p : list) {
			if(p.getFirstName().contains(name)) {
				results2.add(p);
			}
		}
		
		return results2;
	}
	
	
	
	
	
	public static void printArray(int[] arrInt) {
		for (int value : arrInt) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static void printPerson(Person[] list) {
		for (Person p : list) {
			System.out.println(p);
		}
	}
	
	public static void printPerson(ArrayList<Person> list) {
//		for (Person p : list) {
//			System.out.println(p);
//		}
		list.forEach(p->{
			System.out.println(p);
		});
	}

	public static void main(String[] args) {

		// Sinh mảng
		int[] arrInt = MyArrays.generateArray(20);
		// In mảng
		MyArrays.printArray(arrInt);

		// Sắp xếp mảng ban đầu
		arrInt = MyArrays.sortedArray(arrInt, false);
		// In mảng
		MyArrays.printArray(arrInt);

		// Sắp xếp đưa số nguyên tố lên đầu
		arrInt = MyArrays.filterArray(arrInt, true);
		// In mảng
		MyArrays.printArray(arrInt);

//Person list

		// Sinh mang
		Person[] list = MyArrays.generatePerson(20);
		MyArrays.printPerson(list);
		
		System.out.println("\n---------------");
		Person [] results = MyArrays.searchPerson(list, "Trung");
		MyArrays.printPerson(results);
		
		System.out.println("\n---------------");
		ArrayList<Person> results2 = MyArrays.searchPersonV2(list, "Trung");
		MyArrays.printPerson(results2);
	}

}
