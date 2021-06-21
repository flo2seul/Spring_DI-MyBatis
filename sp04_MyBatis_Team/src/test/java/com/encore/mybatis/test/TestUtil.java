package com.encore.mybatis.test;

import com.encore.mybatis.vo.Book;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//SqlSessionFactory를 생성하는 놈..
public class TestUtil {
	public static void printList(List<Book> list){
		for(int i=0; i<list.size();i++){
			System.out.println("<"+(i+1+"> 번째 도서...."+list.get(i).toString()));
		}
		System.out.println("\n");
	}
	
	public static SqlSessionFactory getSqlSessionFactory() throws IOException{
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		return factory;
	}
}
