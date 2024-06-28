package on_class;

public class Triangle {
	private double a;
	private double b;
	private double c;

	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public void setA(double a) {
		this.a = a;
	}

	public void setB(double b) {
		this.b = b;
	}

	public void setC(double c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

	public TRI checkTriangle() {
		if (this.a <= 0 || this.b <= 0 || this.c <= 0) {
			return TRI.NONE;
		} else {
			if (a + b > c && a + c > b && b + c > a) {
				boolean isAB = a == b;
				boolean isAC = a == c;
				boolean isBC = b == c;

				if (isAB && isAC)
					return TRI.DEU;
				else {
					if (isAB || isBC || isAC)
						return TRI.CAN;
					else {
						boolean isA = (a * a == b * b + c * c);
						boolean isB = (b * b == a * a + c * c);
						boolean isC = (c * c == a * a + b * b);

						if (isA || isB || isC)
							return TRI.VUONG;
						else {
							return TRI.BT;
						}
					}
				}
			} else {
				return TRI.NONE;
			}
		}
	}

	public void printInfo() {
		System.out.println(this.toString());
		switch (this.checkTriangle()) {
		case DEU:
			System.out.println("\nTam giac deu");
			break;
		case VUONG:
			System.out.println("\nTam giac vuong");
			break;
		case CAN:
			System.out.println("\nTam giac can");
			break;
		case BT:
			System.out.println("\nTam giac binh thuong");
			break;
		case NONE:
			System.out.println("\nKhong la tam giac");
			break;
		}

	}

	public static void main(String[] args) {
		int a = (int) (Math.random() * 20);
		int b = (int) (Math.random() * 20);
		int c = (int) (Math.random() * 20);

		Triangle t = new Triangle(a, b, c);
		t.printInfo();
	}

}

enum TRI {
	NONE, BT, VUONG, DEU, CAN
}
