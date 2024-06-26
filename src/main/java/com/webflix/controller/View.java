package com.webflix.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View {
	
	private String viewPath;

	
	public View(String viewPath) {
		this.viewPath = viewPath;
	}
	
	//view를 출력하게끔 하는 Method
	public void render (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
	
	public void render (Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modelToRequestAttribute(model, request);
		System.out.println(viewPath);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
	
	private void modelToRequestAttribute (Map<String, Object> model, HttpServletRequest request) {
		model.forEach((key,value) -> request.setAttribute(key, value));
	}
}
