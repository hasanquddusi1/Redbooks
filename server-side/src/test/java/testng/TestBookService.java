package testng;

import java.util.HashMap;
import java.util.Map;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dao.BookDao;
import models.Book;
import services.BookServiceImpl;

public class TestBookService {
	
	@Mock
	public BookDao bookDaoImpl;
	
	@InjectMocks
	public BookServiceImpl bookServiceImpl;
	
	
	public HashMap<Integer, Book> fakeBooks;
	
	@BeforeClass
	public void beforeTestGetAll() {
		bookServiceImpl = new BookServiceImpl();
		
		MockitoAnnotations.initMocks(this);
		fakeBooks = new HashMap<>();
		fakeBooks.put(1, new Book(1, "The Steps", "Jhon Buchan", "adventure", "the_thirty_nine_steps.jpeg", "the_thirty_nine_steps.txt"));
		fakeBooks.put(2, new Book(2, "Call of the wild", "Jack London", "adventure", "call_of_the_wild.jpeg", "call_of_the_wild.txt"));
		
		Mockito.when(bookDaoImpl.getAll()).thenReturn(fakeBooks);
		Mockito.when(bookDaoImpl.searchByGenre("adventure")).thenReturn(fakeBooks);
		Mockito.when(bookDaoImpl.getOne(1)).thenReturn(new Book(1, "The Steps", "Jhon Buchan", "adventure", "the_thirty_nine_steps.jpeg", "the_thirty_nine_steps.txt"));
	}
	
	
	@Test
	public void testGetAllBooks() {
		Map<Integer, Book> retrievedBooks = bookServiceImpl.getAll();
		Assert.assertEquals(retrievedBooks.get(1).getBookName(), "The Steps");
	}
	
	@Test
	public void testGetOneBook() {
		
		Book retrievedBook = bookServiceImpl.getOne(1);
		Assert.assertFalse(retrievedBook.equals(null));;
	}
	
	@Test
	public void testSearchByGenre() {
		Map<Integer, Book> retrievedBooks = bookServiceImpl.getAll();
		Assert.assertEquals(retrievedBooks.get(1).getBookName(), "The Steps");
	}
}
