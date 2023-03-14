package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		
		switch(path)
		{
			case "/reg" :
			
				getRegistrationPage(request,response);
				break;
			case "/log" :
				
				getCustomerLoginPage(request,response);
				
				break;	
			case "/register" :
				getLoginPage(request,response);
				break;
			case "/customerlogin":
				getCustomerLogin(request,response);
				break;
			case "/retry":
				getCustomerLoginPage(request,response);
				break;
			default :
				getStartUpPage(request,response);
				break;
		}
	}

	
	private void getCustomerLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("cust_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException ex) 
		{
			
			ex.printStackTrace();
		} 
		catch (IOException ex) 
		{
			
			ex.printStackTrace();
		}
	}


	private void getCustomerLogin(HttpServletRequest request, HttpServletResponse response) 
	{
		String email = request.getParameter("tbmail");
		String pwd = request.getParameter("tbpass");
		
		boolean b =DataAccess.validation(email, pwd);
		
		try 
		{
			if(b)
			{
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			SuccessPage sp =new SuccessPage();
			request.setAttribute("successDetails", sp);
			rd.forward(request, response);
			}
			else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
			}
		} 
		catch (ServletException e) 
		{
			
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		String n = request.getParameter("tbname");
		String g = request.getParameter("gender");
		String e = request.getParameter("tbmail");
		String p = request.getParameter("tbpass");
		long m = Long.parseLong(request.getParameter("tbmob"));
		String s = request.getParameter("ddlstate");
		
		Customer c = new Customer(n, g, e, p, m, s);
		
		DataAccess.inserting(c);
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("cust_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException ex) 
		{
			
			ex.printStackTrace();
		} 
		catch (IOException ex) 
		{
			
			ex.printStackTrace();
		}
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("cust_registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_homepage.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
