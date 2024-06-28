package on_class;

public abstract class Manager {
	
	public abstract String getInfo(Person p);
	
	public String getDetails(Person p) {
		return this.getInfo(p);
	}
}
