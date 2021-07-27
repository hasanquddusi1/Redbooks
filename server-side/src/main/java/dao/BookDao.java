package dao;

import java.util.Map;

import models.Book;

public interface BookDao {
	Map<Integer, Book> getAll();
	Book getOne(int key);
	Map<Integer, Book> searchByGenre(String genre);
}
