package object_geo;

import java.io.*;
import java.util.Collections;

import myio.*;

public class MANAGEMENTImpl2 extends MANAGEMENTImpl implements MANAGEMENT,SORTED {

	public MANAGEMENTImpl2() {
		super();
	}

	public MANAGEMENTImpl2(int n) {
		super(n);
	}
	
	public MANAGEMENTImpl2(int n,boolean isINC) {
		super(n);
		this.SortedByArea(isINC);
		this.exportFile("resultlist.txt");
	}

	@Override
	public boolean addGeo(GeometricObject go) {
		// TODO Auto-generated method stub
		boolean flag = super.addGeo(go);
		this.exportFile("resultlist.txt");
		return true;
	}
//
//	@Override
//	public boolean editGeo(GeometricObject go) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean delGeo(GeometricObject go) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public void printInfo() {
		AppendStr as = new AppendStr();

		this.list.forEach(go -> {
			String strout = "";

			if (go instanceof Circle) {
				System.out.print("Circle: ");
				strout = "Circle: ";
			} else {
				System.out.print("Rectangle: ");
				strout = "Rectangle: ";

			}
			System.out.printf("%10.2f - %10.2f\n", go.findArea(), go.findPerimeter());
			strout += go.findArea() + " - " + go.findPerimeter() + "\n";
			as.setStr(strout);
		});
		try {
			StringReader in = new StringReader(as.getStr());
			FileWriter out = new FileWriter("file6.txt");
			MyStream.copy(in, out);
			in.close();
			out.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void SortedByArea(boolean isINC) {
		// TODO Auto-generated method stub
		
		if(isINC) {
			Collections.sort(this.list);
		}
		else {
			Collections.sort(this.list, Collections.reverseOrder());
		}
	}

	@Override
	public void SortedByPerimeter(boolean isINC) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private void exportFile(String filename) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			
			for(GeometricObject go: this.list) {
				out.writeObject(go);
			}
			out.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}

//noi chuoi
class AppendStr {
	private StringBuilder str;

	public AppendStr() {
		this.str = new StringBuilder();
	}

	public AppendStr(StringBuilder str) {
		this.str = new StringBuilder();
	}

	public String getStr() {
		return str.toString();
	}

	public void setStr(String strout) {
		this.str.append(strout);
	}


}
