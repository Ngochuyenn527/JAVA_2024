
package utilities;

public class MyStrings {

	/**
	 *đếm số ký tự giống nhau trong chuỗi
	 *@param str chuỗi ký tự đầu vào
	 *@param ch : ký tự cần đếm số lương
	 *@param isIgnoreCase phân biệt chữ hoa chữ thường
	 *@return kết quả đếm 
	 */
	public static int countChar(String str, char ch, boolean isIgnoreCase) {
		//nếu ta bỏ qua kiểu chữ
		if(isIgnoreCase) {
			str = str.toLowerCase();
			ch = Character.toLowerCase(ch);
		}
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}
	
	public static String formatString(String str) {
		char[] chs= {
				'~','`','@','#','$','%','^','&','*','(',')',
				'_','-','+','=','<','>','/','{','}','[',']','\'','\\',
				'9','8','7','6','5','4','3','2','1','0', '?','.',',','!',';'
		};
		
		//loại bỏ ký tự đặc biệt trong mảng chs
		for(char ch : chs) {
			str=str.replace(ch,' ');
		}
		
		str=str.trim();
		str=str.replaceAll("\\s+", " ");
		return str;
		
	}
	
	/**
	 * Đếm số lượng chuỗi ký tự trong một chuỗi ký tự
	 * @param str chuỗi đầu vào
	 * @return số lượng chuỗi
	 */
	public static int countWords(String str) {
//		int count=1;
//		for(int i=0;i<str.length()-1;i++) {
//			if(str.charAt(i)==' ' && str.charAt(i+1)==Character.i) {
//				count++;
//			}
//		}
//		if(str.charAt(0)==' ') count--;
//		return count;
		
		//cách làm tốt hơn
		str = MyStrings.formatString(str);
		System.out.println(str);
		
		//đếm số từ = số dấu cách + 1;
		return MyStrings.countChar(str, ' ', false)+1;
	}
	
	
	public static String getWords(String str, byte nWords) {
		//chuẩn hóa chuỗi
		str = MyStrings.formatString(str);
		
		//xác định vị trí cắt chuỗi
		int count = 0; //đếm số dấu cách
		int i;
		for(i=0; i< str.length(); i++) {
			if(str.charAt(i) == ' ') {
				count++;
			}
			if(count == nWords) break;
		}
		
		//return result  i là số từ chạy được
		if(i<str.length()-1) {
			return str.substring(0,i);
		}
		else {
			return str;
		}	
	}
	
	public static void main(String[] args) {
		String str = "Cong hoa xa    hoi chu nghia viet nam   ";
		System.out.println("Co "+countChar(str, 'c', false));
		System.out.println(formatString(str));
		System.out.println("Co "+countWords(str)+" tu trong cau");
		System.out.println(getWords(str, (byte)2));
	}
}
//baitap:  #abc###nhd##abc##nhd#kio#lod#abc
//thống kê số lần xuất hiện


