package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.MenuDao;

public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDao dao;
       
  
    public HomePage() {
        super();
        dao = new MenuDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getParameter("action");
		System.out.println("action: " + action);
		if (action.equalsIgnoreCase("home")) {
			request.getRequestDispatcher("/homePage.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("menu")) {
			List<com.restaurant.model.Menu> menu = dao.getAllFood();
			request.setAttribute("menu", menu);
			for (com.restaurant.model.Menu temp : menu) {
			}
			request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
			
		} else if (action.equalsIgnoreCase("Account")) {
			request.getRequestDispatcher("/homePage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
			}
		}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
