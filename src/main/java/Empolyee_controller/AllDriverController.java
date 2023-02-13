package Empolyee_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Empolyee_bo.Driver_bo;
import Empolyee_dao.Emp_dao;

/**
 * Servlet implementation class AllDriverController
 */
@WebServlet("/AllDriverController")
public class AllDriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AllDriverController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.print("<a href='Home.html'><button>Back Home</button></a>");
		
		pw.print("<table border='1px' width='100%'> ");
		pw.print("<tr><th>ID</th><th>NAME</th><th>PHONE_NO.</th><th>VEHICAL_NO.</th><th>LICENSE_NO.</th><th>CITY</th><th>AADHAR_NO.</th> <th>Edit</th><th>Delete</th></tr>");
		
	List<Driver_bo> list=Emp_dao.getalldriver();
	
	for(Driver_bo db:list) {
		pw.print("<tr><td>"+db.getId()+"</td><td>"+db.getName()+"</td><td>"+db.getPhone()+"</td><td>"+db.getVehical()+"</td><td>"+db.getLicense()+"</td><td>"+db.getCity()+"</td><td>"+db.getAadhar()+"</td>  <td><a href='EditDriver?id="+db.getId()+"'>edit</a></td>   <td><a href='DeleteDriver?id="+db.getId()+"'>delete</a></td></tr>");
		
	}
	   pw.print("</table>");
	
		
		
	}

}	
	


