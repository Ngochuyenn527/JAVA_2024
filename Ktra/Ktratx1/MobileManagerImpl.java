package ktratx1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MobileManagerImpl implements MobileManager {
	
	private ArrayList<Mobile> list = new ArrayList<>();
	
	/**
	 * khởi tạo 2 Constructor để gọi đến hàm generateList()
	 */
	public MobileManagerImpl() {
		this.generateList(5);
	}
	
	public MobileManagerImpl(int n) {
		this.generateList(n);
	}
	
	@Override
	public boolean addMobile(Mobile m) {
		boolean find = false;
		for (Mobile mobile : this.list) {
			if(mobile.getProduct_id() == m.getProduct_id()) {
				find = true;
				break;
			}
		}
		if(find) {
			return false;
		}
		else {
			this.list.add(m);
			return true;
		}
	}


	@Override
	public boolean editMobile(Mobile m) {
		for (Mobile mobile : this.list) {
			if(mobile.getProduct_id() == m.getProduct_id()) {
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
			if(mobile.getProduct_id() == m.getProduct_id()) {
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
			if(mobile.getProduct_name().contains(name)) {
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
				if(value > 0) {
					return 1;
				}
				else if(value < 0) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});
		return this.list;
	}
	
	/**
	 * khởi tạo danh sách sinh ngẫu nhiên các phần tử
	 * @param n là số đối tượng được tạo
	 */
	public void generateList(int n) {
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
			
			element = (int) (Math.random() * 100);
			
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
	}

	
	public void printList() {
		for (Mobile mobile : this.list) {
			System.out.println(mobile);
		}
	}
}
