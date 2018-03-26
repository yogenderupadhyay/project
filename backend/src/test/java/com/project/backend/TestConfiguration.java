package com.project.backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		context.getBean("userDAO");
		System.out.println("Successfully created instance.");
	}
}
