package objects;

//public class GeometricObject {
public abstract class GeometricObject implements Comparable<GeometricObject> {

	private int id;
	private String color;
	private boolean filledIn;

	public GeometricObject() {

	}

	public GeometricObject(int id, String color, boolean filledIn) {
		this.id = id;
		this.color = color;
		this.filledIn = filledIn;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilledIn() {
		return filledIn;
	}

	public void setFilledIn(boolean filledIn) {
		this.filledIn = filledIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract double findArea();

	public abstract double findPerimeter();

	public void showInfo(GeometricObject go) {
		if (go instanceof Circle && go.findArea() >= 0 && go.findArea() <= 2000) {
			System.out.print("C:");
		} else {
			System.out.print("R:");
		}

//	System.out.println(go);
//	System.out.println(go.findArea());
		System.out.printf("%5d\t", go.getId());

		System.out.printf("%10.2f\n", go.findArea());
	}

	public int compareTo(GeometricObject o) {
		double value = this.findArea() - o.findArea();
		if (value > 0) {
			return 1;
		} else if (value < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "GeometricObject [id=" + id + ", color=" + color + ", filledIn=" + filledIn + "]";
	}

}
