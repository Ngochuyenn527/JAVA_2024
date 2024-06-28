package myio;

import java.io.*;

public class MyFile {
	public static void textOutputFile() throws IOException {
		// ghi file
		FileWriter of = new FileWriter("CA2.txt");
		PrintWriter out = new PrintWriter(of);
		out.println(12345);
		out.println("HELLO WORLD");
		out.println(199.67);
		out.println(false);

		out.close();

	}

	public static void textInputFile() throws IOException {
		// doc file
		FileReader inFileReader = new FileReader("CA2.txt");
		BufferedReader in = new BufferedReader(inFileReader);
		String tmpStr;
		int anInt;
		double aDouble;
		boolean aBoolean;

		tmpStr = in.readLine();
		anInt = Integer.parseInt(tmpStr);
		System.out.println(anInt);

		tmpStr = in.readLine();
		System.out.println(tmpStr);

		tmpStr = in.readLine();
		aDouble = Double.parseDouble(tmpStr);
		System.out.println(aDouble);

		tmpStr = in.readLine();
		aBoolean = Boolean.parseBoolean(tmpStr);
		System.out.println(aBoolean);

		in.close();
	}

	/**
	 * ghi dữ liệu ra file nhị phân
	 * 
	 * @throws IOException
	 * 
	 */

	public static void binaryOutputFile() throws IOException {
		FileOutputStream of = new FileOutputStream("CA2.bin");
		DataOutputStream out = new DataOutputStream(of);
		out.writeInt(2); // số lượng bản ghi trợ giúp đọc
		for (int i = 0; i < 2; i++) {
			out.writeInt(123 + i);
			out.writeUTF("HELLO WORLD");
			out.writeDouble(123.45 + i);
			out.writeBoolean(false);
		}
		out.close();
	}
	
	/**
	 * đọc dữ liệu từ file nhị phân
	 * @param args
	 */
	public static void binaryInputFile() throws IOException {
		FileInputStream inf = new FileInputStream("CA2.bin");
		DataInputStream in = new DataInputStream(inf);
		int reCount;
		String aStr;
		int anInt;
		double aDouble;
		boolean aBoolean;

		reCount = in.readInt();
		for(int i=0; i< reCount; i++) {
			anInt = in.readInt();
			System.out.println(anInt);

			aStr = in.readUTF();
			System.out.println(aStr);

			aDouble = in.readDouble();
			System.out.println(aDouble);

			aBoolean = in.readBoolean();
			System.out.println(aBoolean);
		}
		in.close();
		
	}

	public static void main(String[] args) {
//		try {
//			MyFile.textOutputFile();
//
//			MyFile.textInputFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			MyFile.binaryOutputFile();
			
			MyFile.binaryInputFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
