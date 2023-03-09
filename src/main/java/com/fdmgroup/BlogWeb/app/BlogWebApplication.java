package com.fdmgroup.BlogWeb.app;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BlogWebApplication {

	public static void main(String[] args) {
		makeH2Dir();
		SpringApplication.run(BlogWebApplication.class, args);
	}
	private static String createH2DirPath() {
		String osName = System.getProperty("os.name").toLowerCase();
		
		String dir;
		
		if(osName.contains("win")) {
			dir = System.getenv("APPDATA") + "\\";
		} else if(osName.contains("mac")) {
			dir = System.getProperty("user.home") + "/Library/Application Support/";
		} else {
			throw new UnsupportedOperationException("Your operating system is not supported by this application.");
		}
		
		dir += "TestBlogApp";
		
		return dir;
	}
	
	private static void makeH2Dir() {
		String h2DirPath = createH2DirPath();
		new File(h2DirPath).mkdirs();
	}
}


