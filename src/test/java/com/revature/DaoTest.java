package com.revature;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;

public class DaoTest {
	
	static EmployeeDaoImpl edimpl = new EmployeeDaoImpl();
	static ManagerDaoImpl mdimpl = new ManagerDaoImpl();
	static RequestDaoImpl rdimpl = new RequestDaoImpl();
	
	@Test
	public void testGetEmployeeById() {
		Employee emp = new Employee(9, "Maryjo", "Platt", "mplatt8", "O4TQmGdgIPl1", 9, "312 Mallory Trail");
		assertEquals(emp, edimpl.getEmployeeById(9));
	}
	
	@Test
	public void testGetEmployeeByUsername() {
		Employee emp = new Employee(13, "Keenan", "Bourton", "kbourtonc", "I9d5jx3vvMc", 2, "1840 Utah Circle");
		assertEquals(emp, edimpl.getEmployeeByUsername("kbourtonc"));
	}
	
	@Test
	public void testGetManagerById() {
		Manager man = new Manager(6, "Robbert", "Millership", "rmillership5", "0Y12rnZ");
		assertEquals(man, mdimpl.getManagerById(6));
	}
	
	@Test
	public void testGetManagerByUsername() {
		Manager man = new Manager(3, "Oates", "Gierhard", "ogierhard2", "5t08Pzs");
		assertEquals(man, mdimpl.getManagerByUsername("ogierhard2"));
	}
	
	@Test
	public void testGetRequestById() {
		BigDecimal amount = new BigDecimal ("65.78");
		Employee employee = edimpl.getEmployeeById(9);
		Manager manager = mdimpl.getManagerById(5);
		Request req = new Request(21, "Sales Expense", "resolved", "approve", amount, employee, manager);
		assertEquals(req, rdimpl.getRequestById(21));
	}
	
	@Test
	public void testGetSumByType() {
		BigDecimal sum = new BigDecimal("363.22");
		assertEquals(sum, rdimpl.getSumByType("Other"));
	}
	
}

