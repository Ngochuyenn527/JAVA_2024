package object_geo;

import java.util.ArrayList;

import java.util.*;

import on_class.*;

public class MANAGEMENTImpl implements MANAGEMENT {

	protected ArrayList<GeometricObject> list;
	
	public MANAGEMENTImpl() {
		this.generateList(10);

	}
	
	public MANAGEMENTImpl(int n) {
		this.generateList(n);
	}

	@Override
	public boolean addGeo(GeometricObject go) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(GeometricObject item :this.list) {
			if(item.getId() == go.getId()) {
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			this.list.add(go);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean editGeo(GeometricObject go) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delGeo(GeometricObject go) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void generateList(int n) {
		// TODO Auto-generated method stub
		this.list = new ArrayList<>(n);
		
		HashMap<Integer, GeometricObject> tmp = new HashMap<>();
		
		GeometricObject go;
		int value;

		while(tmp.size() < n) {
			
			value = (int) (Math.random() * 100);
			
			if (!tmp.containsKey(value)){
				if (Utilities.isPrime(value)) {
					go = new Circle(2, "RED", true, value);
				} else {
					go = new Rectangle(3, "BLUE", true, value * 2, value);
				}
				//thiet lap id
				go.setId(value);
				this.list.add(go);
				tmp.put(value, go);

			}
		}
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		this.list.forEach(go -> {

			if (go instanceof Circle) {
				System.out.print("Circle: ");
			} 
			else {
				System.out.print("Rectangle: ");
			}
			System.out.println(go.findArea() + " - " + go.findPerimeter());
		});
	}

	@Override
	public void printInfoDetails() {
		// TODO Auto-generated method stub
		this.list.forEach(go ->{
			System.out.println(go.toString());
		});
		
	}

}
