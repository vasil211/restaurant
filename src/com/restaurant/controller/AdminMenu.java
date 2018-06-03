package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.MenuDao;
import com.restaurant.dao.UserDao;


public class AdminMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDao dao;
    public AdminMenu() {
        super();
        dao = new MenuDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String forward = "";
		String action = request.getParameter("action");
       System.out.println(action);
		if (action.equalsIgnoreCase("delete")) {
			//int menu_Id = request.getParameter("menu_Id");
//			System.out.println(menu_Id);
//			dao.deleteFood(menu_Id);
			List<com.restaurant.model.Menu> menu = dao.getAllFood();
			request.setAttribute("menu", menu);
			for (com.restaurant.model.Menu temp : menu) {
			}
			request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
