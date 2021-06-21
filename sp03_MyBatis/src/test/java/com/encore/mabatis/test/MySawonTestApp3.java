package com.encore.mabatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;


public class MySawonTestApp3 {
	public static void main(String[] args) throws Exception {
		//1. 팩토리 얻어온다.
		SqlSessionFactory factory = FactoryService.getFactory();
		
		//2. openSession()으로 SqlSession 받아온다.. 디비 연결 쿼리문 실행할 수 있다.
		SqlSession session=factory.openSession();
		
		List<MySawon> list=session.selectList("mysawonMapper.sawonList");
		System.out.println(list);
	}

}
