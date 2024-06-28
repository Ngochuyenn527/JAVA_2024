package self;

public class Geometric {
	private int id;
	private String color;
	private boolean filledIn;

	public Geometric() {

	}

	public Geometric(int id, String color, boolean filledIn) {
		this.id = id;
		this.color = color;
		this.filledIn = filledIn;
	}

	public int getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

	public boolean isFilledIn() {
		return filledIn;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setFilledIn(boolean filledIn) {
		this.filledIn = filledIn;
	}

	@Override
	public String toString() {
		return "Geometric [id=" + id + ", color=" + color + ", filledIn=" + filledIn + "]";
	}
	
	

}
