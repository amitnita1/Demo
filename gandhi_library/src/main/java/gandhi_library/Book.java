package gandhi_library;

public class Book {
     private String bookName;
     private int id;
	public Book(String bookName, int id) {
		super();
		this.bookName = bookName;
		this.id = id;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
     
     
