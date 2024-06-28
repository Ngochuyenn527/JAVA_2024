package basic;

public class Example3 {
	/**
	 * this method is used to check aint value is prime?
	 * <i>Update 02/11/2023 </i>
	 *
	 * @param n
	 * @return
	 */

	public static boolean isPrime(int n){
		boolean flag = true;
		//kiem tra
        if(n<2) {
        	flag = false;
        }
        else {
        	for(int v=2; v<=(int)(Math.sqrt(n)); v++) {
        		if(n%v==0) {
        			flag = false;
        			break;
        		}
        	}
        }
        return flag;
	}
	/*
	public static int getUCLN(int a, int b) {
		if(a%b==0) return b;
		else return getUCLN(b, a%b);
	}
	public static int getUCLN(int a, int b, int c) {
		if(getUCLN(a,b)%c==0)return c;
		else return getUCLN(c,getUCLN(a,b)%c);
	}
	*/
	
	
	public static int getucln(int a, int b) {
		int ucln = -1;
		if(a*b!=0) {
			while(a!=b) {
				if(a>b) {
					a-=b;
				}
				else {
					b-=a;
				}
			}
			ucln = a; //ucln = b
		}
		return ucln;
	}
	public static int getucln(int a, int b, int c) {
		return getucln(getucln(a, b), c);
		
	}

	public static void main(String[] args) {
		// Khai báo thể hiện đối tượng để thực hiện
		// A a = new A();
		// Example3 ex = new Example3();
		//Object ex1 = new Example3(); Object là bố, Example3 là con
		
		int n = (int)(Math.random()*100);
		//Nhan ket qua
		//boolean flag = ex.isPrime(n);
		if(Example3.isPrime(n)) {
        	System.out.println("n="+n+" la so nguyen to");
        }
        else {
        	System.out.println("n="+n+" khong la so nguyen to");
        }
		
		
		int x = (int)(Math.random()*100);
		int y = (int)(Math.random()*100);
		int z = (int)(Math.random()*100);

		System.out.println("UCLN cua x="+x+" va y="+y+" la: "+Example3.getucln(x, y)); 
		System.out.println("UCLN cua x="+x+" va y="+y+" va z="+z+" la: "+Example3.getucln(getucln(x,y), z)); 
	}
}
