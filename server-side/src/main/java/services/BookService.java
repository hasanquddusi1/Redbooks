package services;

import java.util.Map;

import models.Book;

public interface BookService {
	Map<Integer, Book> getAll();
	Book getOne(int key);
	Map<Integer, Book> searchByGenre(String genre);
}
