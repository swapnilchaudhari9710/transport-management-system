package Empolyee_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Empolyee_bo.Transport_bo;
import Empolyee_dao.Emp_dao;

/**
 * Servlet implementation class TransportController
 */
@WebServlet("/TransportController")
public class TransportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransportController() {
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
		
		String trans=request.getParameter("Transport_type");
		String num=request.getParameter("number");
		String dep=request.getParameter("dep");
		String des=request.getParameter("des");
		
		Transport_bo tb=new Transport_bo(trans, num, dep, des);
		
		int status= Emp_dao.addtransport(tb);
		
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("AllTransportController");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("addtransport.html");
			rd.include(request, response);
		}
	}

}
