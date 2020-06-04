package common;

import java.util.LinkedList;

import domain.Book;

public class BookDataStore {
	// 图书存储:必须为static才能实现对象共享
	private static LinkedList<Book> bookList = new LinkedList<Book>();

	// 返回图书集合
	public LinkedList<Book> getBookList() {
		return bookList;
	}
}
