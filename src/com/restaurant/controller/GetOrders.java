package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.OrderDao;
import com.restaurant.dao.UserDao;

public class GetOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDao dao;

	public GetOrders() {
		super();
		dao = new OrderDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("isLogged") != null) {

			int roleId = (int) request.getSession().getAttribute("role_Id");
			if (roleId == 1) {
				List<com.restaurant.model.Order> orders = dao.getAllWaitingOrders();

				request.setAttribute("order", orders);
				for (com.restaurant.model.Order temp : orders) {
					System.out.println(temp.getOrderId());
					request.getRequestDispatcher("/WEB-INF/orders.jsp").forward(request, response);
				}
			} else {
				List<com.restaurant.model.Order> orders = dao.getAllWaitingOrders();

				request.setAttribute("order", orders);
				for (com.restaurant.model.Order temp : orders) {
					System.out.println(temp.getOrderId());
					request.getRequestDispatcher("/WEB-INF/orders.jsp").forward(request, response);
				}
				// response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=notLoggedIn");
			}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
