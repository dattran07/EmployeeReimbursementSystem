package com.revature.servlets.manager.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;
import com.revature.model.Manager;
import com.revature.utility.User;

public class GetManagerNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetManagerNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!User.isManagerNull() && !User.isEmployee()) {
			ManagerDao md = new ManagerDaoImpl();
			ObjectMapper om = new ObjectMapper();
			PrintWriter pw = response.getWriter();
			List<Manager> manager = md.getManagerFullName();
			String requestString = om.writeValueAsString(manager);
			requestString = "{\"requests\":"+requestString+"}";
			pw.print(requestString);
		} else {
			request.getRequestDispatcher("Views/Login.html").forward(request, response);
		}
	}

}
