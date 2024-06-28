package object_geo;

import java.io.Serializable;

//public class GeometricObject {
	public abstract class GeometricObject implements Comparable<GeometricObject>, Serializable{

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

		

		@Override
		public String toString() {
			return "GeometricObject [id=" + id + ", color=" + color + ", filledIn=" + filledIn + "]";
		}
		
		@Override
		public int compareTo(GeometricObject o) {
			// TODO Auto-generated method stub
			double result = this.findArea() - o.findArea();
			if(result > 0) return 1;
			else if(result < 0) return -1;
			else return 0;
			
		}

	}


