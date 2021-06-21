package com.encore.mabatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;


public class MySawonTestApp2 {
	public static void main(String[] args) throws Exception {
		//1. SqlMapConfig.xml 파일을 읽어들인다.
		Reader r= Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. SqlSessionFactory 리턴 받는다.
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. SqlSession 리턴 받는다.
		SqlSession session = factory.openSession();
		
		System.out.println("===========================================");
		/*
		 * sql
		 */
		
		List<MySawon> list=session.selectList("mysawonMapper.sawonList");
		for(MySawon v : list)
			System.out.println(v.getId()+","+v.getName()+","+v.getAge());
	}

}
