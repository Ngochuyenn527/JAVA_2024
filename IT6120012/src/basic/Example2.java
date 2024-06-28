package basic;

public class Example2 {

	public static void main(String[] args) {
		
        int n = (int) (Math.random()*100);
        boolean flag = true;
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
        if(flag) {
        	System.out.println("n="+n+" la so nguyen to");
        }
        else {
        	System.out.println("n="+n+" khong la so nguyen to");
        }

	}
}
