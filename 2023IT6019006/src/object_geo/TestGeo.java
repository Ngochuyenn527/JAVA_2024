package object_geo;

import java.io.*;

public class TestGeo {
	public static void main(String[] args) {
//		MANAGEMENT m = new MANAGEMENTImpl(20);
//		m.printInfoDetails();
//		m.printInfo(); //in dien tich chu vi
		
		int n = (int)(Math.random()*10) + 5;
		MANAGEMENT m = new MANAGEMENTImpl2(n,true); //sx tang dan
//		MANAGEMENT m = new MANAGEMENTImpl2(10,false); // sx giam

		m.printInfo();
		System.out.println("---------------------------");

		
		int radius = (int)(Math.random()*100);
		GeometricObject go = new Circle(45,"PINK", true, radius);
		
		if(m.addGeo(go)) {
//			m.printInfoDetails();
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("resultlist.txt"));
				for(int i=0; i<=n; i++) { // <=n vì add thêm 1 ptu có id=45
						System.out.println(in.readObject().toString());
				}
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("------KHONG THANH CONG--------");
		}
	}

}
 