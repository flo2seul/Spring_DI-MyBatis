package com.encore.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.encore.mybatis.vo.Book;
import com.encore.services.BookDAO;
import com.encore.services.BookService;
import com.encore.services.impl.BookDAOImpl;
import com.encore.services.impl.BookServiceImpl;

public class MyBatisTestApp {
	
	///Main method
	public static void main(String[] args) throws Exception{
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/config/bookservice.xml"	 }  );
								
		//==> IoC Container 로 부터 획득한 BookDAO 인스턴스 획득
		BookService bookService = (BookService)context.getBean("bookServiceImpl");
		
		//==> Test 용 book instance 생성  
		Book book = new Book("1111","오래된미래","사회","??","2015-02-25","헬레나",14000,"krw","올해의 추천 도서");		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
		//1.BookService.addBook(book) Test
		System.out.println(":: 1. add(INSERT)  ? ");
		bookService.addBook(book);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//2.BookService.getBook(bookId) Test
		book = bookService.getBook("1111");
		System.out.println(":: 2. get(SELECT)  ? "+book);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//3.BookService.uadateBook(book) Test
		book.setPrice(20000);
		System.out.println(":: 3. update(UPDATE)  ? ");
		bookService.updateBook(book);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//4.BookService.getBook(bookId) Test
		book = bookService.getBook("1111");
		System.out.println(":: 4. get(SELECT)  ? "+book);

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//5.BookDAO.removeBook(bookId) Test
		//==> BookService 에는 removeBook가 없으므로, DAO에서 직접 호출 Test
		BookDAO bookDAO = (BookDAO)context.getBean("bookDAOImpl");
		System.out.println(":: 5. remove(DELETE)  ? "+bookDAO.removeBook("1111"));
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//6.BookService.getBookList() Test
		System.out.println(":: 6. all Book(SELECT)  ? ");
		List<Book> list = bookService.getBookList(new Book());
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 도서 정보... ");
			System.out.println( list.get(i).toString() );
		}
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
			

	}//end of main
}//end of class




