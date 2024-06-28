package model;

import java.util.List;

public interface MobileManager {

	public boolean addMobile(Mobile m);

	public boolean editMobile(Mobile m);

	public boolean delMobile(Mobile m);

	public List<Mobile> searchMobile(String name);

	public List<Mobile> sortedMobile(double price);

}
