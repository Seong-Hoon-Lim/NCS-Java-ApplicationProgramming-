package com.kudangtang.jv300.mod009;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeCourseContents implements ServletContextListener {
	
	/**
	 * 서버가 Start up 될 때 실행될 메소드
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized is called");
		ServletContext context = sce.getServletContext();
		
		InputStream is = null;
		BufferedReader reader = null;
		List<String[]> contentList = new ArrayList<String[]>();
		
		try {
			is = context.getResourceAsStream("/WEB-INF/classes/course_contents.txt");
			reader = new BufferedReader(new InputStreamReader(is));
			String record = null;
			while ((record = reader.readLine()) != null) {
				String[] fields = record.split("\t");
				contentList.add(fields);
				//requestScope 를 가리킴
				context.setAttribute("contentList", contentList);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 서버가 Shut down 될 때 실행될 메소드
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed is called");
			
	}
	

}
