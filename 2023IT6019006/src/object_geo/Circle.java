package object_geo;


public class Circle extends GeometricObject {

		private double radius;

		public Circle() {

		}

		public Circle(int id, String color, boolean filledIn, double radius) {
			super(id, color, filledIn);
			this.radius = radius;
		}

		public double getRadius() {
			return radius;
		}

		public void setRadius(double radius) {
			this.radius = radius;
		}

		public double findArea() {
			return Math.PI * Math.pow(this.radius, 2);
		}

		public double findPerimeter() {
			return 2 * Math.PI * this.radius;
		}

		@Override
		public String toString() {
			return "Circle [" + super.toString() + ", radius=" + radius + "]";
		}

		


	}
