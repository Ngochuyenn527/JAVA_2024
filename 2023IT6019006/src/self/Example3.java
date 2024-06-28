package self;

public class Example3 {
	public static long Giaithua(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		else {
			return n*Giaithua(n-1);
		}
	}
	public static void main(String[] args) {
		int n = (int)(Math.random()*20);
		System.out.println(n);
		long result = Giaithua(n);
		System.out.println(result);
	}

}
