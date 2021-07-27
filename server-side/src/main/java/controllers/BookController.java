package controllers;

import org.eclipse.jetty.util.ajax.JSONObjectConvertor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.*;

import io.javalin.http.Context;
import services.BookService;
import services.BookServiceImpl;


public class BookController {
	static BookService bookService = new BookServiceImpl();
	
	
	public static void getAllBooks(Context context) {
		
		context.json(bookService.getAll());
	}
	
	public static <JSONObject> void getOneBook(Context context) {
		String body = context.body();
		JsonObject convertedObject = new Gson().fromJson(body, JsonObject.class);
		int key = convertedObject.get("book_id").getAsInt();
		context.json(bookService.getOne(key));
	}
	public static <JSONObject> void searchByGenre(Context context) {
		String body = context.body();
		JsonObject convertedObject = new Gson().fromJson(body, JsonObject.class);
		String genre = convertedObject.get("genre").getAsString();
		context.json(bookService.searchByGenre(genre));
	}
}
