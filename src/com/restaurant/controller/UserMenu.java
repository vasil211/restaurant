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
import com.restaurant.model.Menu;

public class UserMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDao dao;

	public UserMenu() {
		super();
		dao = new MenuDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getSession().getAttribute("isLogged") != null) {
			int roleId = (int) request.getSession().getAttribute("role_Id");
		    List<com.restaurant.model.Menu> menu = dao.getAllFood();
			request.setAttribute("menu", menu);
			for (com.restaurant.model.Menu temp : menu) {
			}
			request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
			
		} else {
			 List<com.restaurant.model.Menu> menu = dao.getAllFood();
				request.setAttribute("menu", menu);
				for (com.restaurant.model.Menu temp : menu) {
				}
				request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
