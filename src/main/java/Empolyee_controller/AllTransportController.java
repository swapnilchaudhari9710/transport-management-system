package Empolyee_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Empolyee_bo.Transport_bo;
import Empolyee_dao.Emp_dao;

/**
 * Servlet implementation class AllTransportController
 */
@WebServlet("/AllTransportController")
public class AllTransportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllTransportController() {
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
		
		pw.print("<a href='Home.html'><button>Back Home</button></a>");
		
		pw.print("<table border='1px' width='100%'> ");
		pw.print("<tr><th>transport_type</th><th>vehical_no</th><th>Departure</th><th>Destination</th> <th>Edit</th><th>Delete</th></tr>");
		
	List<Transport_bo> list=Emp_dao.getalltransport();
	
	for(Transport_bo tb:list) {
		pw.print("<tr><td>"+tb.getTransport_type()+"</td><td>"+tb.getNumber()+"</td><td>"+tb.getDep()+"</td><td>"+tb.getDes()+"</td>  <td><a href='EditTransport?vehical_no="+tb.getNumber()+"'>edit</a></td>   <td><a href='DeleteTransport?vehical_no="+tb.getNumber()+"'>delete</a></td></tr>");
		
	}
	   pw.print("</table>");
	}

}
