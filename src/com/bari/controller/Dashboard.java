package com.bari.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bari.dao.UserDao;
import com.bari.model.User;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	public Dashboard() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("isLogged") != null) {
			int roleId = (int) request.getSession().getAttribute("roleId");
			if (roleId == 1) {
				RequestDispatcher view = request.getRequestDispatcher("/listuser.jsp");
				List<User> users = dao.getAllUsers();

				request.setAttribute("users", users);
				for (User temp : users) {
					System.out.println(temp.getUname());
				}
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/main.jsp");
				request.setAttribute("userRole", request.getSession().getAttribute("roleId"));
				view.forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp?error=notLoggedIn");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		doGet(request, response);
	}

}
