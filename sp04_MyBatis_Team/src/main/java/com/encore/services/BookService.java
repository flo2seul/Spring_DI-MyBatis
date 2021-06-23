package com.encore.services;

import java.util.List;

import com.encore.mybatis.vo.Book;


public interface BookService {
	void addBook(Book book) throws Exception;
	void updateBook(Book book) throws Exception;
	Book getBook(String isbn) throws Exception;
	List<Book> getBookList(Book book) throws Exception;


}
