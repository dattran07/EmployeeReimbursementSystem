package com.revature.servlets.expense;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.utility.User;


public class CertificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CertificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((!User.isManagerNull() && !User.isEmployee())) {
			RequestDao rd = new RequestDaoImpl();
			ObjectMapper om = new ObjectMapper();
			PrintWriter pw = response.getWriter();
			BigDecimal amount = rd.getSumByType("Certification");
			String requestString = om.writeValueAsString(amount);
			requestString = "{\"requests\":" + requestString + "}";
			pw.print(requestString);
		} else {
			request.getRequestDispatcher("Views/Login.html").forward(request, response);
		}
	}

}
