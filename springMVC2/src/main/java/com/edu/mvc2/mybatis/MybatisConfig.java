package com.edu.mvc2.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {

	private static MybatisConfig instance;
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;

	private MybatisConfig() {
		String resource = "com/edu/mvc2/mybatis/config.xml";

		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 세션얻기
	public SqlSession getSqlSession() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		return sqlSession;
	}

	// 세션반납
	public void release(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	public static MybatisConfig getInstance() {

		if (instance == null) {
			instance = new MybatisConfig();
		}
		return instance;
	}
}
