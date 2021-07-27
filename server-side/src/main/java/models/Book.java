package models;

public class Book {
	private String bookName;
	private String bookAuthor;
	private int bookId;
	private String genre;
	private String img_path;
	private String file_path;
		
	
	public Book(int bookId, String bookName, String bookAuthor, String genre, String img_path, String file_path) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookId = bookId;
		this.genre = genre;
		this.img_path = img_path;
		this.file_path = file_path;
	}
	
	
	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getImg_path() {
		return img_path;
	}


	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}


	public String getFile_path() {
		return file_path;
	}


	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	

}
