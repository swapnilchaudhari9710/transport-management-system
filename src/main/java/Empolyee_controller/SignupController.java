package Empolyee_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Empolyee_bo.Emp_bo;
import Empolyee_dao.Emp_dao;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pass");
		
		//pw.print(name+" "+email+" "+phone+" "+pwd);
		
		Emp_bo em=new Emp_bo();
		em.setName(name);
		em.setEmail(email);
		em.setPhone(phone);
		em.setPass(pwd);
		
		int status=Emp_dao.signup(em);
		if(status>0) {
			pw.print("you are successfully signup go to login");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		}
		else {
			pw.print("Somthing went Wrong....");
			RequestDispatcher rd=request.getRequestDispatcher("SignUp.html");;
			rd.include(request, response);
		}
	}

}
