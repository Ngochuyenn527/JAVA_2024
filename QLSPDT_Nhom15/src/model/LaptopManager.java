package model;

import java.util.List;

public interface LaptopManager {

	public boolean addLaptop(Laptop l);

	public boolean editLaptop(Laptop l);

	public boolean delLaptop(Laptop l);

	public List<Laptop> searchLaptop(String name);

	public List<Laptop> sortedLaptop();
}
