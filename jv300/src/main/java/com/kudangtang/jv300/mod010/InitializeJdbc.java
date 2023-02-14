package com.kudangtang.jv300.mod010;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeJdbc implements ServletContextListener {
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";
	
	/**
	 * 서버가 Start up 될 때 실행될 메소드
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized is called");
		ServletContext context = event.getServletContext();		
		InputStream is = null;
		BufferedReader reader = null;
		Map<String, String> jdbcMap = new HashMap<String, String>();		
		try {
			is = context.getResourceAsStream(JDBC_FILE_PATH);
			reader = new BufferedReader(new InputStreamReader(is));
			String record = null;
			
			while ((record = reader.readLine()) != null) {
				String[] fields = record.split("=");	//"=" 기준으로 문자열 자르기
				jdbcMap.put(fields[0], fields[1]);	//jdbcMap 에 key, value 담기
			}
			//jdbcMap 에 담긴 값 가져오기 (map객체.get("key"))
			String jdbcDriver = jdbcMap.get("jdbc.driver");
			String jdbcURL = jdbcMap.get("jdbc.url");
			String userName = jdbcMap.get("jdbc.username");
			String password = jdbcMap.get("jdbc.password");
			
			System.out.println("jdbcDriver=" + jdbcDriver);
			System.out.println("jdbcURL=" + jdbcURL);
			System.out.println("userName=" + userName);
			System.out.println("password=" + password);
			
			/**
			 * DataSource 객체가 생성되면서 아래 과정의 내부의 메소드가 동작됨
			 * 클래스를 로딩하면서 jdbcDriver 를 연결
			 * jdbc.properties 의 값들로 Connection 을 생성
			 */
			DataSource dataSource = new DataSource(jdbcDriver, jdbcURL, 
												userName, password);
		}		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 서버가 Shut down 될 때 실행될 메소드
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed is called");
			
	}
	

}
