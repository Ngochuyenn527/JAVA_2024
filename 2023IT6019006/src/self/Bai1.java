package self;

import java.util.Scanner;

public class Bai1 {
	/**
	 * Tim ucln cua 2 so a, b ( 3 so a,b,c )
	 * @param a
	 * @param b
	 * @return
	 */
	public static int ucln2(int a, int b) {
		if(a%b ==0) {
			return b;
		}
		else {
			return ucln2(b,a%b);
		}	
	}
	
	/**
	 * Kiem tra 3 gtri co tao thanh tam giac
	 * @param args
	 */
	public static boolean tamgiac(int a,int b, int c) {
		boolean result = true;
		if(a+b > c || a+c > b || b+c > a) {
			return result;
		}
		else {
			result = false;
		}
		return result;
	}
	
	/**
	 * giải hệ 2 hoặc 3 pt
	 * @param args
	 */
	public static void he2pt(int a, int b, int c, int d, int e, int f) {
		float y = (float)(c*d-a*f)/(b*d-a*e);
		float x = (float)(c - (b*y)) / a;
		System.out.println("He pt co 2 nghiem x = "+x+" va y = "+y);
	}
	
	/**
	 * Tính diện tích bề mặt hình nón khi biết bán kính r và đường sinh l
	 * @param args
	 */
	public static double S_hnon(float r, float l) {
		if(r == 0 || l == 0) {
			return 0;
		}
		else {
			return Math.PI *r*(l+r);
		}
	}
	/**
	 * Tính điểm tích lũy của sv
	 * @param args
	 */
	public static double diem_1mon() {
		int dtp, dtk;
		double heso_dtp, heso_dtk;
		int so_dtp = 1+(int)(Math.random()*2);
		System.out.println("So diem thanh phan la: "+ so_dtp);
		double a[] = {0.1, 0.15, 0.2, 0.3};
		int sum = 0;
		double tong_heso_dtp = 0.0;
		
		for(int i=1; i<=so_dtp; i++) {
			//sinh ngau nhien dtp
			dtp = (int)(Math.random()*10);
			//sinh ngau nhien heso_dtp
			int element= (int)(Math.random()*a.length);
			heso_dtp = (double) a[element];
			//tinh (tong_heso_dtp) => để suy ra heso_dtk=(1-tong_heso_dtp);
			tong_heso_dtp+= heso_dtp;
			//tinh tong dtp*heso_dtp
			sum+=dtp*heso_dtp;
			System.out.println("Diem thanh phan thu "+i+" = "+ dtp + " co he so = "+ heso_dtp);
		}
		//sinh ngau nhien dtk
		dtk = (int)(Math.random()*10);
		//sinh ngau nhien heso_dtk
		heso_dtk = (double)(1.0-tong_heso_dtp);
		System.out.println("Diem tong ket co ket qua = "+dtk+" co he so = "+heso_dtk);
		
		double result = sum + dtk*heso_dtk;
		return result;
	}
	
	//điểm tích lũy = (số tín)*(điểm 1 môn) / (tổng số tín)
	public static float diem_tl() {
		//sinh ngẫu nhiên số môn học
		int somon = 1 + (int)(Math.random()*3);
		System.out.println("Sinh ngau nhien "+ somon+" mon hoc");
		
		int sotin, tong_sotin=0;
		int diemcacmon=0;
		for(int i=1; i<=somon; i++) {
			//sinh ngẫu nhiên số tín của 1 môn bất kỳ
			sotin = 1 + (int)(Math.random()*5);
			System.out.println("\nMon hoc thu "+i+" co "+sotin+" tin");
			//tính điểm của các môn 
			diemcacmon += Bai1.diem_1mon()*sotin;
			//tính tổng số tín để tính điểm tích lũy = (số tín)*(điểm 1 môn) / (tổng số tín)
			tong_sotin+= sotin;
		}
		return (float)(diemcacmon)/tong_sotin;
		
	}
	
	
	public static void main(String[] args) {
		int a = (int)(Math.random()*100);
		int b = (int)(Math.random()*100);
		int c = (int)(Math.random()*100);
		int d = (int)(Math.random()*100);
		int e = (int)(Math.random()*100);
		int f = (int)(Math.random()*100);
		int r = (int)(Math.random()*10);
		int l = (int)(Math.random()*10);


		System.out.println("UCLN cua 2 so a = "+a+" va b = "+b+ " la: "+Bai1.ucln2(a, b));
		System.out.println("UCLN cua 3 so a = "+a+" va b = "+b+" va c = "+c+" la: " +Bai1.ucln2(Bai1.ucln2(a, b),c));
		System.out.println();
		
		Bai1.tamgiac(a, b, c);
		System.out.println();
		
		Bai1.he2pt(a, b, c, d, e, f);
		System.out.println();
		
		System.out.println("Dien tich be mat hinh non = "+ Bai1.S_hnon(r, l));
		System.out.println();
		
		
		System.out.println(diem_tl());
		
		he2pt(1,4,5,7,4,3);
		
	}
	
	
	

}
