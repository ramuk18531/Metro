package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servie.Userservice;
import com.servie.UserserviceImpl;
import com.users.User;

/**
 * Servlet implementation class IndexClass
 */
@WebServlet("/Indexservlet")
public class IndexClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Userservice userService;
@Override
public void init() throws ServletException {

	 userService=new UserserviceImpl();
}	
	/**
     * Default constructor. 
     */
    public IndexClass() {
        // TODO Auto-generated constructor stub
    					}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	String action=request.getParameter("command");
	PrintWriter pw=response.getWriter();
	if(action.equals("Login"))
	{
		String Username=request.getParameter("uname");
		String Password=request.getParameter("password");
		User u=new User();
		u.setUsername(Username);
		u.setPassword(Password);
		
		try {
			boolean isUserAvailable=userService.validate(u);
		if(isUserAvailable)
		{ 
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		}
		else{
			response.setContentType("text/html");
			response.getWriter().println("wrong user details");
			RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			rd.include(request, response);
		}
			//RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			//rd.include(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	else if(action.equals("Sign Up"))
	{	
		response.setContentType("text/html");
		RequestDispatcher rd=request.getRequestDispatcher("signup.html");
		rd.forward(request, response);
	}
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
