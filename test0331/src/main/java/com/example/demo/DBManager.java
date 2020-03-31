package com.example.demo;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.bytecode.annotation.MemberValueVisitor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MemberVo;

public class DBManager {
	
	private static SqlSessionFactory factory;
	static {
		

		
		
		try {
			Reader reader =   Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static MemberVo selectMember(String username) {
		MemberVo m = null;
		SqlSession session = factory.openSession();
		m = session.selectOne("member.selectMember",username);
		session.close();
		return m;
	}
	
	
	public static int insertMember(MemberVo m) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("member.insertMember", m);
		session.commit();
		session.close();
		return re;
	}

}
