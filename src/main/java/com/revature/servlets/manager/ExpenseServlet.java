package com.revature.servlets.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.utility.User;

public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rq;
		if (!User.isManagerNull()) {
			rq = request.getRequestDispatcher("Views/Manager/Expenses.html");
		} else {
			rq = request.getRequestDispatcher("Views/Login.html");
		}
		rq.forward(request, response);
	}

}
