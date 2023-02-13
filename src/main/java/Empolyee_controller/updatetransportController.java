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
 * Servlet implementation class updatetransportController
 */
@WebServlet("/updatetransportController")
public class updatetransportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatetransportController() {
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
		
		
		String transport=request.getParameter("Transport_type");
		String vehical=request.getParameter("vehical");
		String Departure=request.getParameter("Departure");
		String Destination=request.getParameter("Destination");
		
		Transport_bo tb=new Transport_bo();
		
		tb.setTransport_type(transport);
		tb.setNumber(vehical);
		tb.setDep(Departure);
		tb.setDes(Destination);		
		
		int status=Emp_dao.UpdateTransport(tb);
		
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("AllTransportController");
			rd.forward(request, response);
		}
		
	
	}

}
