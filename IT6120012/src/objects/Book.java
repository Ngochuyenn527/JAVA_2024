package objects;

public class Book {
	// constants
	//final trống sự ghi đè
	public static final short BOOK_ID=0;
	public static final String BOOK_TITLE="no book_title";
	public static final String BOOK_AUTHOR="no book_author";
	public static final String BOOK_SUMMARY="no book_summary";
	public static final String BOOK_DETAILS="no book_details";
	public static final String BOOK_IMAGES="no book_images";
	public static final short BOOK_NUMBER_PAGES=0;
	public static final float BOOK_PRICES=0;
	public static final String BOOK_NOTES="no book_node";
		
	
	//classes'variable
	private String book_title;
	private short book_id;
	private short book_number_page;
	private float book_prices;
	private String book_author;
	private String book_summary;
	private String book_details;
	private String book_images;
	private String book_notes;
	private String book_publisher;
	private String book_publisher_address;

	
	//constructor methods
	public Book( short book_id,String book_title,short book_number_page, float book_prices,String book_author,String book_summary,String book_details,String book_images,String book_notes) {
		this.book_title=book_title;
		this.book_id=book_id;
		this.book_number_page=book_number_page;
		this.book_prices=book_prices;
		this.book_author= book_author;
		this.book_summary=book_summary;
		this.book_details=book_details;
		this.book_images=book_images;
		this.book_notes=book_notes;	
	}
	

	public Book() {
		this(Book.BOOK_ID,Book.BOOK_TITLE,Book.BOOK_NUMBER_PAGES,Book.BOOK_PRICES, Book.BOOK_AUTHOR,Book.BOOK_SUMMARY,Book.BOOK_DETAILS,Book.BOOK_IMAGES,Book.BOOK_NOTES);
	}
	
	//Getter and Setter
	public String getBook_title() {
		return book_title;
	}
	public short getBook_id() {
		return book_id;
	}
	public short getBook_number_page() {
		return book_number_page;
	}
	public float getBook_prices() {
		return book_prices;
	}
	public String getBook_author() {
		return book_author;
	}
	public String getBook_summary() {
		return book_summary;
	}
	public String getBook_details() {
		return book_details;
	}
	public String getBook_images() {
		return book_images;
	}
	public String getBook_notes() {
		return book_notes;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public String getBook_publisher_address() {
		return book_publisher_address;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public void setBook_id(short book_id) {
		this.book_id = book_id;
	}
	public void setBook_number_page(short book_number_page) {
		this.book_number_page = book_number_page;
	}
	public void setBook_prices(float book_prices) {
		this.book_prices = book_prices;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public void setBook_summary(String book_summary) {
		this.book_summary = book_summary;
	}
	public void setBook_details(String book_details) {
		this.book_details = book_details;
	}
	public void setBook_images(String book_images) {
		this.book_images = book_images;
	}
	public void setBook_notes(String book_notes) {
		this.book_notes = book_notes;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public void setBook_publisher_address(String book_publisher_address) {
		this.book_publisher_address = book_publisher_address;
	}

	
	
	@Override
	public String toString() {
		return "Book [book_title=" + book_title + ", book_id=" + book_id + ", book_number_page=" + book_number_page
				+ ", book_prices=" + book_prices + ", book_author=" + book_author + ", book_summary=" + book_summary
				+ ", book_details=" + book_details + ", book_images=" + book_images + ", book_notes=" + book_notes
				+ ", book_publisher=" + book_publisher + ", book_publisher_address=" + book_publisher_address + "]";
	}
	
	
	public static void main(String[] args) {
		Book b = new Book();
		b.setBook_id((short)100);
		b.setBook_title("Lap trinh huong doi tuong");
		System.out.println(b);
		
	}
}
