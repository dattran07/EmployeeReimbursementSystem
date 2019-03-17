package com.revature.servlets.manager;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.utility.User;


public class UpdateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public UpdateRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!User.isManagerNull() && !User.isEmployee()) {
			RequestDao rd = new RequestDaoImpl();
			Request r = new Request();
			Manager m = new ManagerDaoImpl().getManagerById(User.getManagerId());
			int id = Integer.parseInt(request.getParameter("id"));
			Request req = rd.getRequestById(id);
			BigDecimal amt = req.getAmount();
			String type = req.getType();
			Employee e = req.getEmployee();
			String decision = "";
			if(!request.getParameter("decision").equals("Select a Decision")) {
				decision = request.getParameter("decision");
			}
			
			r.setId(id);
			r.setType(type);
			r.setStatus("resolved");
			r.setDecision(decision);
			r.setAmount(amt);
			r.setEmployee(e);
			r.setManager(m);
			rd.updateRequest(r);
			response.sendRedirect("managerhome");
		} else {
			response.sendRedirect("login");
		}

	}

}
