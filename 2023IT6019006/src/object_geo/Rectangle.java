package object_geo;


public class Rectangle extends GeometricObject {

		private double width;
		private double length;

		public Rectangle() {

		}

		public Rectangle(int id, String color, boolean filledIn, double width, double length) {
			super(id, color, filledIn);
			this.width = width;
			this.length = length;
		}

		public double getWidth() {
			return width;
		}

		public double getLength() {
			return length;
		}

		public void setWidth(double width) {
			this.width = width;
		}

		public void setLength(double length) {
			this.length = length;
		}

		public double findArea() {
			return this.width * this.length;
		}

		public double findPerimeter() {
			return 2 * (this.width + this.length);
		}

		@Override
		public String toString() {
			return "Rectangle [" + super.toString() + ", width=" + width + ", length=" + length + "]";
		}



	}


