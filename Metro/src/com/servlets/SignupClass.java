package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servie.Userservice;
import com.servie.UserserviceImpl;
import com.users.User;

/**
 * Servlet implementation class SignupClass
 */
@WebServlet("/SignupServlet")
public class SignupClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Userservice userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	userService = new UserserviceImpl(); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String action=request.getParameter("comm");
	PrintWriter pw = response.getWriter();
	if(action.equals("Signup"))
	{
		String Firstname=request.getParameter("fname");
		String Lastname= request.getParameter("lname");

		String Username= request.getParameter("uname");

		String Password= request.getParameter("pass");

		String Cpassword= request.getParameter("cpass");

		String Email= request.getParameter("email");

		String Phone= request.getParameter("phonenum");

		String Age= request.getParameter("age");
		User u= new User();
		u.setFirstname(Firstname);
		u.setLastname(Lastname);
		u.setUsername(Username);
		u.setPassword(Password);
		u.setCpassword(Cpassword);
		u.setEmail(Email);
		u.setPhone(Phone);
		u.setAge(Age);
		
		try {
			userService.updateuser(u);
			{ 
				response.setContentType("text/html");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		else if(action.equals("Login"))
	{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
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
