package com.dhruvalkodinariya.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class LoginValidate
 */
@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pass = request.getParameter("pass");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Connection c = DB.getConnection("ACCOUNT");
			PreparedStatement pstmt = (PreparedStatement) c.prepareStatement("SELECT *FROM `Companies` where BINARY user_name= ? and BINARY password= ? ");
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
//			Statement st = c.createStatement();
//			String sql="SELECT *FROM `Companies` where user_name=\"user\" and password=\"pass\";
			ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			
          HttpSession session = request.getSession();
          
//          session.setMaxInactiveInterval(1*60);
          session.setAttribute("uname",user);
          session.setAttribute("company",rs.getString(2));
          session.setAttribute("compdb",rs.getString(1));
          String str = (String)session.getAttribute("uname");
          out.println("Hello "+str);

          String redirect = response.encodeRedirectURL(request.getContextPath() + "/UserHome.jsp" );
          response.sendRedirect(redirect);
      }
      else{
          out.println("<p id='errMsg'>Username or Password Invalid!!</p>");
          request.getRequestDispatcher("/Login.jsp").include(request, response);
      }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
	}

}
