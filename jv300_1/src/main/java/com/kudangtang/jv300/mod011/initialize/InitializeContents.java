package com.kudangtang.jv300.mod011.initialize;

import java.io.InputStream;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.kudangtang.jv300.mod011.dao.DataSourceManager;


@WebListener
public class InitializeContents implements ServletContextListener{
public static DataSourceManager dataSource;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized is called.");
		ServletContext context = sce.getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/classes/JDBC.txt");
		Properties proper = new Properties();
		try {
			proper.load(is);
			String jdbcDriver = proper.getProperty("JDBC.DRIVER");
			String jdbcUrl = proper.getProperty("JDBC.URL");
			String jdbcId = proper.getProperty("JDBC.USERID");
			String jdbcPw = proper.getProperty("JDBC.USERPW");
			
			System.out.println(jdbcDriver);
			System.out.println(jdbcUrl);
			System.out.println(jdbcId);
			System.out.println(jdbcPw);
			
			dataSource = new DataSourceManager(jdbcDriver, jdbcUrl, jdbcId, jdbcPw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed is called.");
		
	}

}
