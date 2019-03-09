package com.dhruvalkodinariya.account;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

/**
 * Servlet implementation class contactmain
 */
@WebServlet("/contactmain")
public class contactmain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public contactmain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Hello from contactmain get</h2>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
//		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println(action);
//		System.out.println(action.equals("getcontent"));
		try {	
				HttpSession session = request.getSession(false);
				String db = (String)session.getAttribute("compdb");
				Connection c = DB.getConnection(db);
				Statement st = c.createStatement();
				if(action.equals("getcontent")) {
					ResultSet rs = st.executeQuery("SELECT *FROM `Contacts`");
			        
			        
					out.println("<html><body>");
					out.println("<div id=\"ContactListView\"><div class=\"contacts-inner\">\n" + 
							"<div class=\"actionButtonDiv layout horizontal flex\">" +
					"<div class=\"flex\"></div>" +
					"<div>" +
						"<button class=\"buttonAction\" id=\"addNewContactBtn\">NEW</button>" +
						"<button class=\"buttonAction\" id=\"searchContactBtn\">SEARCH</button>" +
					"</div>" +
				"</div>"+
							"			<ul>\n" + 
							"				<li class=\"heading\">\n" + 
							"					<a href=\"#\" class=\"layout horizontal flex\">\n" + 
							"						<div class=\"flex\"></div>\n" + 
							"						<div class=\"flex-3\">Name</div>\n" + 
							"						<div class=\"flex-2\" style=\"text-align:right\">Amount</div>\n" + 
							"						<div class=\"flex-2\"></div>\n" + 
							"						<div class=\"flex-4\">Email</div>\n" + 
							"						<div class=\"flex-2\">Mobile</div>\n" + 
							"					</a>\n" + 
							"				</li>\n");
										while(rs.next()){
											out.println("<li class=\"list-item\">\n" + 
							"					<a href=\"#\" class=\"layout horizontal flex\" cusid="+rs.getString(1)+">\n" + 
							"						<input class=\"flex\" type=\"checkbox\" name=\"\">\n" + 
							"						<div class=\"flex-3\">"+rs.getString(2)+"</div>\n" + 
							"						<div class=\"amount flex-2\" style=\"text-align:right\">"+rs.getString(26)+"</div>\n" + 
							"						<div class=\"flex-2\" style=\"text-align:center\">"+rs.getString(27)+"</div>\n" + 
							"						<div class=\"flex-4\">"+rs.getString(8)+"</div>\n" + 
							"						<div class=\"flex-2\">"+rs.getString(7)+"</div>\n" + 
							"					</a>\n" + 
							"				</li>\n"); 
										}
				}
				else if(action.equals("addnew")){
					String data = request.getParameter("data");
					Gson gson = new Gson();
					Contacts contact= gson.fromJson(data, Contacts.class);
					ContactUtils.addContact(contact,c);
				}
				else if(action.equals("editcontact")){
					String data = request.getParameter("data");
					Gson gson = new Gson();
					Contacts contact= gson.fromJson(data, Contacts.class);
					System.out.println(contact.getCont_id());
					ContactUtils.editContact(contact,c);
				}
				
				
				
		} catch (Exception e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Database connection error");
//			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		out.println("</div></div>");
		out.println("<script src=\"js/contactmain.js\"></script>");
		out.println("<script>"+
				"$(document).ready(function(){"+
					"var cedit = contactView($(\"#ContactListView\"));"+
					"cedit.initContactListView();"+
				"});"+
			 "</script>");
		out.println("</body></html>");
	}

}
