package edu.uic.ids.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.uic.ids.model.Connect;
import edu.uic.ids.model.TableSelect;
/**
* Servlet implementation class BmiServlet
*/
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public LoginServlet() {
 super();
 // TODO Auto-generated constructor stub
 }
 /**
 * @see HttpServlet#doGet(
 HttpServletRequest request, HttpServletResponse response)
 */
 protected void doGet(
 HttpServletRequest request,
 HttpServletResponse response) throws ServletException,
 IOException {
 // TODO Auto-generated method stub
 }
 /**
 * @see HttpServlet#doPost(
 HttpServletRequest request, HttpServletResponse response)
 */
 protected void doPost(
 HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
	 HttpSession session = request.getSession();
	 Connect connect = (Connect) session.getAttribute("connect");
	 TableSelect tableselect = (TableSelect) session.getAttribute("tableselect");
	/* bmiBean.setUnits(request.getParameter("units"));
	 bmiBean.setWeight(Double.parseDouble(request.getParameter("weight")));
	 bmiBean.setHeight(Double.parseDouble(request.getParameter("height")));
	 bmiBean.computeBmi();*/
	 connect.setUsername(request.getParameter("username"));
	 connect.setPassword(request.getParameter("password"));
	 connect.setupcon();
	 try {
		tableselect.init();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 request.setAttribute("tableselect", tableselect);
	 // System.out.println("BMI = " + bmiBean.getBmi());
	 RequestDispatcher dispatcher =
	 request.getRequestDispatcher("/tableselect.jsp");
	 dispatcher.forward(request, response);
	 }
	 }
 
