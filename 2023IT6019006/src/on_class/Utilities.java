package on_class;

public class Utilities {
	/**
	 * Phương thức kiểm tra một giá trị nguyên dương n có phải là nguyên tố?
	 * <i>Update 27/03/2024</i>
	 * @author Huyen
	 * @param n - giá trị cần được ktra nguyên tố
	 * @return - true / false
	 */
	public static boolean isPrime(int n) {
		boolean flag = true;
		if(n<2) {
			flag = false;
		}
		else {
			for(int v=2; v <= (int)(Math.sqrt(n)); v++) {
				if(n%v==0) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * This method is used to get UCLN value from two int params <br>
	 * <i>Update: 03/04/2024 </i>
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getUCLN(int a, int b) {
		int ucln = -1;
		
		if(a*b != 0) {
			while(a!=b) {
				if(a>b) {
					a-=b;
				}
				else {
					b-=a;
				}
			}
			ucln = a;
		}
		return ucln;
	}
		
	public static void main(String[] args) {
		//khai báo đối tượng
//1		Utilities util = new Utilities();  
		
		//Sinh ngau nhien gtri nguyen duong n
		int n = (int)(Math.random()*100);
		
//2		boolean result = Utilities.isPrime(n);    
		
		//in thong tin
		if(Utilities.isPrime(n)) {
			System.out.println("n = "+n+" la so nguyen to");
		}
		else {
			System.out.println("n = "+n+" khong la so nguyen to");
		}
	}

}
