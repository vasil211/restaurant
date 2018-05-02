package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.UserDao;
import com.restaurant.model.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/userList.jsp";
	
	private UserDao dao;

	public UserController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
//		String forward = "";
//		String action = request.getParameter("action");
//       System.out.println(action);
//		if (action.equalsIgnoreCase("delete")) {
//			String user_Id = request.getParameter("user_Id");
//			System.out.println(user_Id);
//			dao.deleteUser(user_Id);
//			forward = LIST_USER;
//			request.setAttribute("users", dao.getAllUsers());
//		} else if (action.equalsIgnoreCase("edit")) {
//			forward = INSERT_OR_EDIT;
//			int user_Id = integerParsing(request.getParameter("user_Id"));
//			User user = dao.getUserById(user_Id);
//			request.setAttribute("user", user);
//		} else if (action.equalsIgnoreCase("listUser")) {
//			List<User> users = dao.getAllUsers();
//			int f = 0;
//			for(int i= 0; i >users.size();i++) {
//				f++;
//			}
//			System.out.println(f);
//			request.setAttribute("users",users);
//			forward = LIST_USER;
//		} else {
//			forward = INSERT_OR_EDIT;
//		}
//
//		RequestDispatcher view = request.getRequestDispatcher(forward);
//		view.forward(request, response);
//	}
//
//	private int integerParsing(String parameter) {
//		// TODO Auto-generated method stub
//		return 0;
=======
		String forward = "";
		String action = request.getParameter("action");
       System.out.println(action);
		if (action.equalsIgnoreCase("delete")) {
			String user_Id = request.getParameter("user_Id");
			System.out.println(user_Id);
			dao.deleteUser(user_Id);
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			String user_Id = request.getParameter("user_Id");
			User user = dao.getUserById(user_Id);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("listUser")) {
			List<User> users = dao.getAllUsers();
			int f = 0;
			for(int i= 0; i >users.size();i++) {
				f++;
			}
			System.out.println(f);
			request.setAttribute("users",users);
			forward = LIST_USER;
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
>>>>>>> ac99de9924e1b835ae5d2147887c8f597fd36894
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String hashedPass= dao.hash(password);
		User user = dao.checkIfUserExist(uname, hashedPass);
		if (user != null) {
			request.getSession().setAttribute("isLogged", true);
			request.getSession().setAttribute("Uname", user.getUname());
			
			request.getSession().setAttribute("role_Id", user.getRole().getId());
			
			response.sendRedirect(request.getContextPath() + "/dashboard");
		} else {
			String  wrongNameOrPass = "Wrong Name Or Pass";
			response.sendRedirect(request.getContextPath() + "/user.jsp?error=" + wrongNameOrPass);
		}

	}

}
