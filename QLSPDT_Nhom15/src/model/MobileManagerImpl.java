package model;

import java.util.*;

public class MobileManagerImpl implements MobileManager {

	private ArrayList<Mobile> list = new ArrayList<>();

	public MobileManagerImpl() {
		this.generateList(5);
	}

	public MobileManagerImpl(ArrayList<Mobile> list, int n) {
		this.generateList(n);
		this.list = list;
	}

	@Override
	public boolean addMobile(Mobile m) {
		boolean find = false;
		for (Mobile mobile : this.list) {
			if (mobile.getProduct_id() == m.getProduct_id()) {
				find = true;
				break;
			}
		}
		if (find) {
			return false;
		} else {
			this.list.add(m);
			return true;
		}
	}

	@Override
	public boolean editMobile(Mobile m) {
		for (Mobile mobile : this.list) {
			if (mobile.getProduct_id() == m.getProduct_id()) {
				this.list.remove(mobile);
				this.list.add(m);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delMobile(Mobile m) {
		for (Mobile mobile : this.list) {
			if (mobile.getProduct_id() == m.getProduct_id()) {
				this.list.remove(mobile);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Mobile> searchMobile(String name) {
		List<Mobile> results = new ArrayList<>();
		for (Mobile mobile : this.list) {
			if (mobile.getProduct_name().contains(name)) {
				results.add(mobile);
			}
		}
		return results;
	}

	public List<Mobile> searchMobile_id(int id) {
		List<Mobile> results = new ArrayList<>();
		for (Mobile mobile : this.list) {
			if (mobile.getProduct_id() == id) {
				results.add(mobile);
			}
		}
		return results;
	}

	public List<Mobile> searchMobile_price(double price) {
		List<Mobile> results = new ArrayList<>();
		for (Mobile mobile : this.list) {
			if (mobile.getProduct_price() == price) {
				results.add(mobile);
			}
		}
		return results;
	}

	public List<Mobile> searchMobile_total(int total) {
		List<Mobile> results = new ArrayList<>();
		for (Mobile mobile : this.list) {
			if (mobile.getProduct_total() == total) {
				results.add(mobile);
			}
		}
		return results;
	}

	public List<Mobile> searchMobile_color(String color) {
		List<Mobile> results = new ArrayList<>();
		for (Mobile mobile : this.list) {
			if (mobile.getColor().contains(color)) {
				results.add(mobile);
			}
		}
		return results;
	}

	public List<Mobile> searchMobile_ss(double ss) {
		List<Mobile> results = new ArrayList<>();
		for (Mobile mobile : this.list) {
			if (mobile.getScreensize() == ss) {
				results.add(mobile);
			}
		}
		return results;
	}

	@Override
	public List<Mobile> sortedMobile(double price) {
		Collections.sort(this.list, new Comparator<Mobile>() {
			@Override
			public int compare(Mobile o1, Mobile o2) {
				double value = o1.getProduct_price() - o2.getProduct_price();
				if (value > 0) {
					return 1;
				} else if (value < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		return this.list;
	}

	public List<Mobile> sortedByProductId(List<Mobile> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingInt(Mobile::getProduct_id));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	public List<Mobile> sortedByProductName(List<Mobile> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparing(Mobile::getProduct_name));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	public List<Mobile> sortedByProductPrice(List<Mobile> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingDouble(Mobile::getProduct_price));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	public List<Mobile> sortedByProductTotal(List<Mobile> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingInt(Mobile::getProduct_total));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	public List<Mobile> sortedByColor(List<Mobile> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparing(Mobile::getColor));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	public List<Mobile> sortedByScreensize(List<Mobile> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingDouble(Mobile::getScreensize));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	/**
	 * khởi tạo danh sách sinh ngẫu nhiên các phần tử
	 * 
	 * @param n là số đối tượng được tạo
	 * @return
	 */

	public ArrayList<Mobile> generateList(int n) {
		Mobile m;

		HashMap<Integer, Mobile> ids = new HashMap<>();

		// name
		String[] name = { "Iphone", "Oppo", "Samsung", "Xiaomi", "Nokia" };

		// color
		String[] col = { "Green", "Red", "Purple", "Yellow", "Brown", "Black", "White" };

		// screensize
		double[] ss = { 6.1, 5.8, 5.7, 6.9, 7.1, 5.5 };

		int element;
		while (this.list.size() < n) {

			element = 1 + (int) (Math.random() * 100);

			if (!ids.containsKey(element)) {
				m = new Mobile();

				m.setProduct_id(element);
				ids.put(element, m);

				element = (int) (Math.random() * name.length);
				m.setProduct_name(name[element]);

				element = (10000 + (int) (Math.random() * 10000000));
				m.setProduct_price(element);

				element = (int) (Math.random() * 100);
				m.setProduct_total(element);

				element = (int) (Math.random() * col.length);
				m.setColor(col[element]);

				element = (int) (Math.random() * ss.length);
				m.setScreensize(ss[element]);

				this.list.add(m);
			}
		}
		return this.list;

	}

	public void printList() {
		for (Mobile mobile : this.list) {
			System.out.println(mobile);
		}
	}

}
