package Empolyee_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Empolyee_bo.Driver_bo;
import Empolyee_bo.Transport_bo;
import Empolyee_dao.Emp_dao;

/**
 * Servlet implementation class updateController
 */
@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateController() {
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
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String vehical=request.getParameter("vehical");
		String license=request.getParameter("license");
		String city=request.getParameter("city");
		String aadhar=request.getParameter("aadhar");
		
		Driver_bo db=new Driver_bo();
		
		db.setId(id);
		db.setName(name);
		db.setPhone(phone);
		db.setVehical(vehical);
		db.setLicense(license);
		db.setCity(city);
		db.setAadhar(aadhar);
		
		int status=Emp_dao.UpdateDriver(db);
		
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("AllDriverController");
			rd.forward(request, response);
		}
		
	}

}
