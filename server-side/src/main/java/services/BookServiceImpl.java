package services;

import java.util.Map;

import dao.BookDao;
import dao.BookDaoImpl;
import models.Book;

public class BookServiceImpl implements BookService {

	BookDao bookDao;
	
	public BookServiceImpl() {
		this.bookDao = new BookDaoImpl();
	}

	
	@Override
	public Map<Integer, Book> getAll() {
		return this.bookDao.getAll();
	}


	@Override
	public Book getOne(int key) {
		return this.bookDao.getOne(key);
	}


	@Override
	public Map<Integer, Book> searchByGenre(String genre) {
		return this.bookDao.searchByGenre(genre);
	}
	
}
