package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LaptopManagerImpl implements LaptopManager {
	private List<Laptop> list = new ArrayList<Laptop>();

	public LaptopManagerImpl(int n) {
		this.generateList(n);
	}

	public LaptopManagerImpl() {
		this.generateList(10);
	}

	public void generateList(int n) {
		// TODO Auto-generated method stub

		this.list = new ArrayList<Laptop>(n);
		HashMap<Integer, Laptop> tmp = new HashMap<Integer, Laptop>();//
		Laptop l;
		int value;
		while (tmp.size() < n) {
			value = (int) (Math.random() * 100);
			if (!tmp.containsKey(value)) {
				l = Laptop.createProduct(value);
				tmp.put(value, l);

				this.list.add(l);
			}
		}

	}

	@Override
	public boolean addLaptop(Laptop l) {
		boolean flag = false;
		for (Laptop item : this.list) {
			if (item.getProduct_id() == l.getProduct_id()) {
				flag = true;
				break;
			}
		}
		if (flag) {
			return false;
		} else {
			this.list.add(l);
			return true;
		}
	}

	@Override
	public boolean editLaptop(Laptop l) {
		for (Laptop laptop : list) {
			if (laptop.getProduct_id() == l.getProduct_id()) {
				Scanner sc = new Scanner(System.in);

				System.out.println("1.edit id " + "2.edit name " + "3.edit price " + "4.edit total "
						+ "5.edit tour name " + "6.edit tour time" + "7.edit tour price");
				System.out.println("Which information you want to edit?");
				int n = sc.nextInt();
				if (n == 1) {
					System.out.println("1.edit id ");
					l.setProduct_id(sc.nextInt());
				} else if (n == 2) {
					System.out.println("2.edit name ");
					l.setProduct_name(sc.nextLine());
				} else if (n == 3) {
					System.out.println("3.edit price ");
					l.setProduct_price(sc.nextDouble());
				} else if (n == 4) {
					System.out.println("4.edit total ");
					l.setProduct_total(sc.nextInt());
				} else if (n == 5) {
					System.out.println("5.edit tour name ");
					l.setLaptop_type(sc.nextLine());
				} else if (n == 6) {
					System.out.println("6.edit tour time");
					l.setLaptop_ram(sc.nextInt());
				} else {
					return false;
				}

				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delLaptop(Laptop l) {
		for (Laptop laptop : list) {
			if (l.getProduct_id() == l.getProduct_id()) {
				list.remove(l);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Laptop> searchLaptop(String name) {
		List<Laptop> result = new ArrayList<>();
		for (Laptop laptop : list) {
			if (laptop.getProduct_name().contains(name)) {
				result.add(laptop);
			}
		}
		return result;
	}

	@Override
	public List<Laptop> sortedLaptop() {
		Collections.sort(list, new Comparator<Laptop>() {

			@Override
			public int compare(Laptop o1, Laptop o2) {
				double result = o1.getProduct_price() - o2.getProduct_price();
				if (result > 0)
					return 1;
				else if (result < 0)
					return -1;
				else
					return 0;
			}

		});
		return list;
	}

	public void printInfo() {
		for (Laptop laptop : list) {
			System.out.println(laptop);
		}
	}

}
