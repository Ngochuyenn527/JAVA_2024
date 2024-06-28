package objects;

import java.util.*;
import basic.Example3;

public class TestGeometricObject {
	private ArrayList<GeometricObject> list;

	public TestGeometricObject() {

	}

//	public static ArrayList <GeometricObject> generateList(int n){
//		ArrayList <GeometricObject> list = new ArrayList<>(n);

	public void generateList(int n) {
		this.list = new ArrayList<>(n);
		ArrayList<Integer> ids = new ArrayList<Integer>(); // ds id duoc luu

		// sinh ngau nhien
		GeometricObject go;

		int element;
		double r, w, l;
		while (this.list.size() < n) {
			element = (int) (Math.random() * 100);

			if (!ids.contains(element)) {

				ids.add(element);
				if (Example3.isPrime(element)) {
					r = (Math.random() * 100);
					go = new Circle(element, "red", true, r);
				} else {
					w = (Math.random() * 100);
					l = (Math.random() * 100);
					go = new Rectangle(element, "green", false, w, l);
					if (w == l)
						;
				}
				this.list.add(go); // đưa vào ds
			}
		}

	}

	// java 5
	public void printList() {
		this.list.forEach(go -> {
			go.showInfo(go);
		});
	}

	/**
	 * tìm ra hình tròn co S nam trogn khoang
	 * 
	 * <i> Update: 16/12/2023</i>
	 * 
	 * @param list
	 * @param min_area
	 * @param max_area
	 * @return
	 */
	public ArrayList<GeometricObject> searchArea(double min_area, double max_area) {
		System.out.println("HInh tron co dien tich nam trong khoang cho truoc la:");
		ArrayList<GeometricObject> results = new ArrayList<>();
		this.list.forEach(go -> {
			if (go instanceof Circle) {
				if (go.findArea() >= min_area && go.findArea() <= max_area) {
					results.add(go);
				}
			}
		});
		return results;
	}

	// liet ke cac hinh vuong trong danh sach
	public ArrayList<GeometricObject> searchSquare() {
		System.out.println("Hinh vuong:");
		ArrayList<GeometricObject> results1 = new ArrayList<>();
		this.list.forEach(go -> {
			if (go instanceof Rectangle) {
				Rectangle check = (Rectangle) go;

				if (check.getLength() == check.getWidth()) {
					results1.add(go);
				}
			}

		});
		return results1;
	}

	// tinh tong dien tich hcn
//	public static int sumArea(ArrayList<GeometricObject> list){
//		System.out.print("Tong dien tich cac hinh chu nhat la: ");
//		int sumrec=0;
//		for(GeometricObject rec : list) {
//			sumrec+=rec.findArea();
//		}
//		return sumrec;
//		
//	}	
	public double sumArea() {
		System.out.print("Tong dien tich cac hinh chu nhat la: ");
		Area a = new Area();
		this.list.forEach(go -> {
			if (go instanceof Rectangle) {
				a.addArea(go.findArea());
			}
		});
		return a.getArea();
	}

	// Sắp xếp diện tích của các hình tròn và hcn theo một thứ tự

//	public static void sortGeometricObjects(ArrayList<GeometricObject> list) {
//		Collections.sort(list, Comparator.comparing(GeometricObject::findArea));
//	}

	public void sortedByArea(boolean isINC) {
		if (isINC) {
			Collections.sort(this.list);
		} else {
			Collections.sort(this.list, Collections.reverseOrder());
		}
	}

	public void sortedByPerimeter(boolean isINC) {

//		sortedByPeri peri = new sortedByPeri();
//		
//		if(isINC) {
//			Collections.sort(list);
//		}
//		else {
//			Collections.sort(list, peri.reversed());
//		}
//		return list;

		if (isINC) {
			Collections.sort(this.list, new sortedByPeri());
		} else {
			Collections.sort(this.list, new sortedByPeri().reversed());
		}
	}

	public boolean addList(GeometricObject g) {
		boolean find = false; // xac nhan su chua ton tai cua id
		for (GeometricObject go : this.list) {
			if (g.getId() == go.getId()) {
				find = true;
				break;
			}
		}
		if (find)
			return false;
		else {
			this.list.add(g);
			return true;
		}
	}

	public boolean editList(GeometricObject g) {
		boolean result = false;
		for (GeometricObject geometricObject : this.list) {
			if (geometricObject.getId() == g.getId()) {
				this.list.remove(geometricObject);
				this.list.add(g);
				result = true;
			}
		}
		return result;
	}

	public boolean delList(GeometricObject g) {
		boolean result = false;
		for (GeometricObject geometricObject : this.list) {
			if (geometricObject.getId() == g.getId()) {
				list.remove(geometricObject);
				result = true;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// số phần tử
		int n = 10 + (int) (Math.random() * 11);

		// lấy danh sách
//		ArrayList <GeometricObject> list = TestGeometricObject.generateList(n);
		TestGeometricObject tgo = new TestGeometricObject();

		// sorted
		tgo.generateList(n);
//		tgo.sortedByArea(true);

		// print
		tgo.printList();

//		TestGeometricObject.printList(TestGeometricObject.searchArea(list, 0, 2000));
//		System.out.println("Truoc khi sap xep");
//		TestGeometricObject.printList(list);
//		System.out.println("Sau khi sap xep");
//		TestGeometricObject.printList(sortedByArea(list, false));

	}

}

//innerclass: class lớp nội
class Area {
	private double area;

	public Area() {
		this.area = 0.0;
	}

	public void addArea(double value) {
		this.area += value;
	}

	public double getArea() {
		return this.area;
	}
}

class sortedByPeri implements Comparator<GeometricObject> {
	@Override
	public int compare(GeometricObject o1, GeometricObject o2) {
		// TODO Auto-generated method stub
		double value = o1.findPerimeter() - o2.findPerimeter();
		if (value > 0) {
			return 1;
		} else if (value < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
