package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.UserDao;
import com.restaurant.model.User;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	public Dashboard() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SESIQ!!!!!
		if (request.getSession().getAttribute("isLogged") != null) {
			// !!
			int roleId = (int) request.getSession().getAttribute("role_Id");
			if (roleId == 1) {
				RequestDispatcher view = request.getRequestDispatcher("/adminFirstPage.jsp");
				request.setAttribute("userRole", request.getSession().getAttribute("role_Id"));
//				List<User> user = dao.getAllUsers();
//
//				request.setAttribute("user", user);
//				for (User temp : user) {
//					System.out.println(temp.getUname());
//				}
//				view.forward(request, response);
			} else if (roleId == 2) {

				RequestDispatcher view = request.getRequestDispatcher("/menu.jsp");
				request.setAttribute("userRole", request.getSession().getAttribute("role_Id"));
				view.forward(request, response);
			} else if (roleId == 3) {

			} else if (roleId == 4) {

			}
		}

		else {
			response.sendRedirect(request.getContextPath() + "/index.jsp?error=notLoggedIn");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		doGet(request, response);
	}

}
