package com.encore.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.encore.mybatis.vo.Book;
/*
 * FileName : MyBatisTestApp101.java
  * ㅇ SqlMapConfig01.xml / mybatis-bookservice-mapping10.xml
  * ㅇ TestUtil.java 을 이용 Test . 
  * ㅇ 이거 돌아가면 MyBatis Framework 단위테스트는 잘 된거다...mybatis-bookservice-mapping10.xml은 문제 없다.
  * 
  * ㅇ 다음은 Persistance Logic 단위테스트 : MyBatisTestApp102.java
  * ㅇ MyBatisbookDAOImpl10 / bookADO 추가해야한다.
  */
public class MyBatisTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		SqlSession session = null;
		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> Test 용 book instance 생성  
		Book book = new Book("1111","오래된미래","사회","??","2015-02-25","헬레나",14000,"krw","올해의 추천 도서");		
		
//		//1. book10.addbook Test  :: books table age/grade/redDate 입력값 확인할것 : OK 
//		System.out.println(":: 1. addbook(INSERT)  ? "
//													+ session.insert("book.addBook",book)); //1
//													  session.commit();
		//2. book10.getbook Test :: 주몽 inert 확인 
		System.out.println(":: 2. getbook(SELECT)  ? ");
		System.out.println(" :: "+session.selectOne("book.getBook",book.getIsbn()) );
		
		
		//3. book10.uadatebook Test  :: books table age/redDate 입력값 확인할것 : OK
		//                                                    :: 주몽 ==> 온달 수정
		book.setTitle("바보 온달과 평강공주");
		System.out.println(":: 3. update(UPDATE)  ? "
													+ session.update("book.updateBook",book));//1
											  		  session.commit();
		 
		//4. book10.getbookList Test  :: Dynamic Query 확인 id=book04/name=온달 검색
		System.out.println(":: 4. getbookList(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("book.getbookList",book) );
		
		//5. book10.removebook Test
		System.out.println(":: 5. Use10.removebook (DELETE)  ? "
								+session.delete("book.removeBook",book.getIsbn()) );//1
								 session.commit();
		
		//6. book10.getbookList Test  :: Dynamic Query 확인 id=book04/name=온달 검색
		System.out.println(":: 6. getbookList(SELECT)  ? ");
		TestUtil.printList((List) session.selectList("book.getbookList",book) ); //이때 위의 기능 리턴타입이 0인걸 확인하자
	
		//7. book10.getbookList Test  :: Dynamic Query 확인 id=null/name=null 인경우
		book.setIsbn(null);
		book.setTitle(null);
		System.out.println(":: 7. getbookList(SELECT)  ? ");
		TestUtil.printList( (List) session.selectList("book.getbookList",book) );
		
	}//end of main
}//end of class




