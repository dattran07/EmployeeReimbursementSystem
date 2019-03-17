package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.model.Request;

public interface RequestDao {
	Request getRequestById(int id);
	Request getRequestById(int id, Connection con);
	List<Request> getRequest(int employeeId);
	List<Request> getPendingRequest(int managerId);
	List<Request> getResolvedRequests(int managerId);
	List<Request> getRequestsByEmployeeId(int managerId);
	List<Request> getPendingRequestsByEmployeeId(int employeeId);
	List<Request> getResolvedRequestsByEmployeeId(int employeeId);
	void addRequest(Request r);
	void updateRequest(Request r);
}
