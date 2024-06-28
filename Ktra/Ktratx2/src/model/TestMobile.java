package model;

import java.io.*;
import java.util.*;

public class TestMobile {
        private static ArrayList<Mobile> list = new ArrayList<>();
        
	public static void main(String[] args) {
// số phần tử   
		int n = 1 + (int) (Math.random() * 6);
                
		MobileManagerImpl mmi = new MobileManagerImpl();
		System.out.println("List: ");
		System.out.println("---------------------------------");
		mmi.generateList(n);
		mmi.printList();
                
                try{
                    FileOutputStream of = new FileOutputStream("Mobile.bin");
                    ObjectOutputStream out = new ObjectOutputStream(of);
                    out.writeInt(2); // số lượng bản ghi trợ giúp đọc
                    out.writeUTF("List: ");
                    for(Mobile mobile : list) {
			out.writeObject(mobile);
                    }
                    
                    // khai báo 1 Mobile mẫu để test các chức năng
                    Mobile m = new Mobile(7, "Sony", 7777777, 7, "BlueSky", 7.7);
		
                    // add
                    if (mmi.addMobile(m)) {
                            System.out.println("\nAdd successful! List after add:");
                            System.out.println("---------------------------------");
                            mmi.printList();
                            
                            out.writeUTF("\nList after add:");                        
                            out.writeUTF("--------------------------------------");
                            for(Mobile mobile : list) {
                                out.writeObject(mobile);
                            }
                    } 
                    else {
                            System.out.println("------Add fail--------");
                    }

                    // edit
                    if (mmi.editMobile(m)) {
                            System.out.println("\nEdit successful! List after edit:");
                            System.out.println("---------------------------------");
                            mmi.printList();
                            
                            out.writeUTF("\nList after edit:");                        
                            out.writeUTF("--------------------------------------");
                            for(Mobile mobile : list) {
                                out.writeObject(mobile);
                            }
                    } 
                    else {
                            System.out.println("------Edit fail--------");
                    }

                    // delete
                    if (mmi.delMobile(m)) {
                            System.out.println("\nDelete successful! List after delete:");
                            System.out.println("---------------------------------");
                            mmi.printList();
                            
                            out.writeUTF("\nList after edit:");                        
                            out.writeUTF("--------------------------------------");
                            for(Mobile mobile : list) {
                                out.writeObject(mobile);
                            }
                    } 
                    else {
                            System.out.println("------Delete fail--------");
                    }

                    // search
                    System.out.println("\nMobile list has name is \"Iphone\": ");
                    System.out.println("---------------------------------");
                    List<Mobile> results = mmi.searchMobile("Iphone");
                    for (Mobile mobile : results) {
                            System.out.println(mobile);
                    }
                    
                    out.writeUTF("\nMobile list has name is \"Iphone\":");                        
                    out.writeUTF("--------------------------------------");
                    for(Mobile mobile : results) {
                        out.writeObject(mobile);
                    }
                    

                    // sort tang dan
                    mmi.sortedMobile(0);
                    System.out.println("\nList after sort price: ");
                    System.out.println("---------------------------------");
                    mmi.printList();
                    
                    out.writeUTF("\nList after sort price: ");                        
                    out.writeUTF("--------------------------------------");
                    for(Mobile mobile : list) {
                        out.writeObject(mobile);
                    }
                    
                }
                catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

