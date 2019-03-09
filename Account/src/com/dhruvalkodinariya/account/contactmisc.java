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

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class contactmisc
 */
@WebServlet("/contactmisc")
public class contactmisc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactmisc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Hello from contactmisc get</h2>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		try {
			HttpSession session = request.getSession(false);
			String db = (String)session.getAttribute("compdb");
			Connection c = DB.getConnection(db);
			if(action.equals("view")) {
				int id = Integer.parseInt(request.getParameter("id"));
				PreparedStatement pstmt = (PreparedStatement) c.prepareStatement("SELECT *FROM `Contacts` where cont_id= ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					out.println("<div id=\"ledgersingleview\">\n" + 
							"    <div class=\"btnContainer\" class=\"dataDiv\" style=\"display:inline-block;margin-bottom: 5px\" recid=\"34\">\n" + 
							"        <input type=\"button\" id=\"editButton\" value=\"Edit\" cusid="+rs.getString(1)+" class=\"buttonAction\">\n" + 
							"		<input type=\"button\" value=\"Delete\" class=\"buttonAction\">\n" + 
							"		<input type=\"button\" value=\"Archive\" class=\"buttonAction\">\n" + 
							"		<input type=\"button\" value=\"Print\" class=\"buttonAction\">\n" + 
							"		<input type=\"button\" value=\"Back\" class=\"buttonAction\" id=\"backButton\">\n" + 
							"\n" + 
							"    </div>\n" + 
							"    <div style=\"clear: both\"></div>\n" + 
							"    <div class=\"viewseperator\"></div>\n" + 
							"    <div id=\"others\" style=\"margin-top: 15px\">\n" + 
							"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
							"            <div class=\"dataTitle\" >Basic Details</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"labelmd\" style=\"width:140px;\">Contact  Name</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(2)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"labelmd\" style=\"width:140px;\">Name on invoice</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(3)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\">Contact Nos.</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(7)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\">E-mail</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(8)+"</td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"        \n" + 
							"                        \n" + 
							"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
							"            <div class=\"dataTitle\" >Tax Details</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">GST</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(9)+"</td>\n" + 
							"                </tr>\n" + 
							"               	<tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">PAN</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(10)+"</td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"        <div class=\"borderBottom\"></div>\n" + 
							"        <div class=\"dataDiv\" id=\"addressdetails\">\n" + 
							"            <div class=\"dataTitle\" >Address Details</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Billing Address</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(11)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\"></td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(12)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\"></td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(13)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\"></td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(14)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\"></td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(15)+", "+rs.getString(16)+", "+rs.getString(17)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" rowspan=\"2\" valign=\"top\" style=\"padding-top: 6px;\">Shipping  Address</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(11)+"</td>\n" + 
							"                </tr>\n" + 
							"                 <tr>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(12)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td></td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(13)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td></td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(14)+"</td>\n" + 
							"                </tr>\n" + 
							"               \n" + 
							"                <tr>\n" + 
							"                    <td></td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(15)+", "+rs.getString(16)+", "+rs.getString(17)+"</td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
							"            <div class=\"dataTitle\" >Opening Balance</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Amount</td>\n" + 
							"                    <td class=\"amount viewtext\">"+rs.getString(26)+"</td>\n" + 
							"                </tr>\n" + 
							"               	<tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">type</td>\n" + 
							"  					<td  class=\"viewtext\">"+rs.getString(27)+"</td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
							"            <div class=\"dataTitle\">Other</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Currency</td>\n" + 
							"                    <td class=\"viewtext\">"+rs.getString(25)+"</td>\n" + 
							"                </tr>\n" + 
							"               	<tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Due in Days</td>\n" + 
							"  					<td class=\"viewtext\">"+rs.getString(6)+"</td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Notes</td>\n" + 
							"  					<td class=\"viewtext\">"+rs.getString(28)+"</td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>");
					out.println("<script>"+
							"$(document).ready(function(){"+
								"var cedit = contactView($(\"#ledgersingleview\"));"+
								"cedit.initContactView();"+
							"});"+
						 "</script>");
				}
				
			}
			else if(action.equals("edit")) {
				
				int id = Integer.parseInt(request.getParameter("id"));
				PreparedStatement pstmt = (PreparedStatement) c.prepareStatement("SELECT *FROM `Contacts` where cont_id= ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					out.println("<div id=\"LedgerEdit\">\n" + 
							"	<div id=\"ledgercreditors\">\n" + 
							"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
							"            <div class=\"dataTitle\" >Basic Details</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"labelmd\" style=\"width:140px;\">Contact  Name</td>\n" + 
							"                    <td><input id=\"cust_name\" type=\"text\"  style=\"width:233px;\" name=\"cust_name\" placeholder=\"Contact Name\" value=\""+rs.getString(2)+"\"/></td>\n" +
							" 						 <input type=\"hidden\" id=\"cont_id\" name=\"cont_id\" value=\""+rs.getString(1)+"\"/>"+
							"							<input type=\"hidden\" id=\"cont_type\" value=\""+rs.getString(27)+"\"/>"+
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"labelmd\" style=\"width:140px;\">Name on invoice</td>\n" + 
							"                    <td><input id=\"name_in_invoice\" type=\"text\"  style=\"width:233px;\" name=\"name_in_invoice\" placeholder=\"Contact Name on invoice\" value=\""+rs.getString(3)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\">Contact Nos.</td>\n" + 
							"                    <td><input id=\"mobile_no\" type=\"text\"  style=\"width:233px;\" name=\"mobile_no\" placeholder=\"Contact no\" value=\""+rs.getString(7)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\">E-mail</td>\n" + 
							"                    <td><input id=\"email\" type=\"text\"  style=\"width:233px;\" name=\"email\" placeholder=\"Email\" value=\""+rs.getString(8)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"        \n" + 
							"                        \n" + 
							"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
							"            <div class=\"dataTitle\" >Tax Details</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">GST</td>\n" + 
							"                    <td><input id=\"gst_no\" type=\"text\"  style=\"width:233px;\" name=\"gst_no\" placeholder=\"GST\" value=\""+rs.getString(9)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"               	<tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">PAN</td>\n" + 
							"                    <td><input id=\"pan_no\" type=\"text\"  style=\"width:233px;\" name=\"pan_no\" placeholder=\"PAN\" value=\""+rs.getString(10)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"        <div class=\"borderBottom\"></div>\n" + 
							"        <div class=\"dataDiv\" id=\"addressdetails\">\n" + 
							"            <div class=\"dataTitle\" >Address Details</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Billing Address</td>\n" + 
							"                    <td><input id=\"bill_addr_1\" type=\"text\"  style=\"width:233px;\" name=\"bill_addr_1\"  placeholder=\"Street\" value=\""+rs.getString(11)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\"></td>\n" + 
							"                    <td><input id=\"bill_addr_2\"type=\"text\"  style=\"width:233px;\" name=\"bill_addr_2\" placeholder=\"Landmark\" value=\""+rs.getString(12)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\"></td>\n" + 
							"                    <td><input id=\"bill_addr_3\"type=\"text\"  style=\"width:233px;\" name=\"bill_addr_3\" placeholder=\"Subarea\" value=\""+rs.getString(13)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\"></td>\n" + 
							"                    <td><input id=\"bill_city\"type=\"text\"  style=\"width:112px;\"  name=\"bill_city\"  placeholder=\"City\" value=\""+rs.getString(15)+"\"/>&nbsp;<input id=\"bill_pincode\" type=\"text\"  style=\"width:113px;\" name=\"bill_pincode\" placeholder=\"Pincode\" value=\""+rs.getString(14)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\"></td>\n" + 
							"                    <td><input id=\"bill_state\" type=\"text\"  style=\"width:112px;\" name=\"bill_state\" placeholder=\"State\" value=\""+rs.getString(16)+"\"/>&nbsp;<input id=\"bill_country\" type=\"text\"  style=\"width:113px;\" name=\"bill_country\" placeholder=\"Country\" value=\""+rs.getString(17)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" rowspan=\"2\" valign=\"top\" style=\"padding-top: 6px;\">Shipping  Address<br/><a href=\"javascript:void(0)\" id=\"addbilladdress\" class=\"bottomTitle\">As above</a></td>\n" + 
							"                    <td><input id=\"ship_addr_1\" type=\"text\"  style=\"width:233px;\" name=\"ship_addr_1\" placeholder=\"Street\" value=\""+rs.getString(18)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                 <tr>\n" + 
							"                    <td><input id=\"ship_addr_2\" type=\"text\"  style=\"width:233px;\" name=\"ship_addr_2\" placeholder=\"Landmark\" value=\""+rs.getString(19)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td></td>\n" + 
							"                    <td><input id=\"ship_addr_3\" type=\"text\"  style=\"width:233px;\" name=\"ship_addr_3\" placeholder=\"Subarea\" value=\""+rs.getString(20)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td></td>\n" + 
							"                    <td><input id=\"ship_city\" type=\"text\"  style=\"width:112px;\" name=\"ship_city\" placeholder=\"City\" value=\""+rs.getString(22)+"\"/>&nbsp;<input id=\"ship_pincode\" type=\"text\"  style=\"width:113px;\" name=\"ship_pincode\"  placeholder=\"Pincode\" value=\""+rs.getString(21)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"               \n" + 
							"                <tr>\n" + 
							"                    <td></td>\n" + 
							"                    <td><input id=\"ship_state\" type=\"text\"  style=\"width:112px;\" name=\"ship_state\" placeholder=\"State\" value=\""+rs.getString(23)+"\"/>&nbsp;<input id=\"ship_country\" type=\"text\"  style=\"width:113px;\" name=\"ship_country\" placeholder=\"Country\" value=\""+rs.getString(24)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
							"            <div class=\"dataTitle\" >Opening Balance</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Amount</td>\n" + 
							"                    <td><input id=\"current_balance\" type=\"text\"  style=\"width:233px;\" name=\"current_balance\" placeholder=\"Amount\"  value=\""+rs.getString(26)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"               	<tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">type</td>\n" + 
							"  					<td style=\"font-size:14px;\"><input style=\"width:20px;\" type=\"radio\" name=\"cont_is\" value=\"Payable\"> Payable<input id=\"cont_is\" type=\"radio\" style=\"width:20px;\" name=\"cont_is\" value=\"Receivable\" />Receivable</td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
							"            <div class=\"dataTitle\">Other</div>\n" + 
							"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Currency</td>\n" + 
							"                    <td><input id=\"currency\" type=\"text\"  style=\"width:233px;\" name=\"currency\" placeholder=\"Currency\" value=\""+rs.getString(25)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"               	<tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;\">Due in Days</td>\n" + 
							"  					<td><input type=\"text\" id=\"cont_due_days\" style=\"width:233px;\" name=\"cont_due_days\" value=\""+rs.getString(6)+"\"/></td>\n" + 
							"                </tr>\n" + 
							"                <tr>\n" + 
							"                    <td class=\"label\" style=\"width:140px;vertical-align: top;\">Notes</td>\n" + 
							"  					<td><textarea id=\"note\" style=\"width:233px;height:125px;\" name=\"note\" value=\""+rs.getString(28)+"\"/></textarea></td>\n" + 
							"                </tr>\n" + 
							"            </table>\n" + 
							"        </div>\n" + 
							"    <div style=\"clear:both;\"></div>\n" + 
							"    <div class=\"layout horizontal-reverse flex\">\n" + 
							"		<button class=\"buttonAction\" id=\"cancelButton\">Cancel</button>\n" + 
							"		<button class=\"buttonAction\" id=\"updateContactBtn\">Update</button>\n" + 
							"	</div>\"\n" + 
							"</div>\n" + 
							"</div>");
					out.println("<script>"+
							"$(document).ready(function(){"+
							"var cedit = contactView($(\"#LedgerEdit\"));"+
							"cedit.initContactEdit();"+
							"});"+
							 "</script>");
				}
			}
			else if(action.equals("add")) {
				out.println("<div id=\"ContactAdd\">\n" + 
						"	<div id=\"ledgercreditors\">\n" + 
						"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
						"            <div class=\"dataTitle\" >Basic Details</div>\n" + 
						"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
						"                <tr>\n" + 
						"                    <td class=\"labelmd\" style=\"width:140px;\">Contact  Name</td>\n" + 
						"                    <td><input id=\"cust_name\" type=\"text\"  style=\"width:230px;\" name=\"cust_name\" placeholder=\"Contact Name\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"labelmd\" style=\"width:140px;\">Name on invoice</td>\n" + 
						"                    <td><input id=\"name_in_invoice\" type=\"text\"  style=\"width:230px;\" name=\"name_in_invoice\" placeholder=\"Contact Name on invoice\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\">Contact Nos.</td>\n" + 
						"                    <td><input id=\"mobile_no\" type=\"text\"  style=\"width:230px;\" name=\"mobile_no\" placeholder=\"Contact no\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\">E-mail</td>\n" + 
						"                    <td><input id=\"email\" type=\"text\"  style=\"width:230px;\" name=\"email\" placeholder=\"Email\"/></td>\n" + 
						"                </tr>\n" + 
						"            </table>\n" + 
						"        </div>\n" + 
						"        \n" + 
						"                        \n" + 
						"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
						"            <div class=\"dataTitle\" >Tax Details</div>\n" + 
						"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\" style=\"width:140px;\">GST</td>\n" + 
						"                    <td><input id=\"gst_no\" type=\"text\"  style=\"width:230px;\" name=\"gst_no\" placeholder=\"GST\"/></td>\n" + 
						"                </tr>\n" + 
						"               	<tr>\n" + 
						"                    <td class=\"label\" style=\"width:140px;\">PAN</td>\n" + 
						"                    <td><input id=\"pan_no\" type=\"text\"  style=\"width:230px;\" name=\"pan_no\" placeholder=\"PAN\"/></td>\n" + 
						"                </tr>\n" + 
						"            </table>\n" + 
						"        </div>\n" + 
						"        <div class=\"borderBottom\"></div>\n" + 
						"        <div class=\"dataDiv\" id=\"addressdetails\">\n" + 
						"            <div class=\"dataTitle\" >Address Details</div>\n" + 
						"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\" style=\"width:140px;\">Billing Address</td>\n" + 
						"                    <td><input id=\"bill_addr_1\" type=\"text\"  style=\"width:230px;\" name=\"bill_addr_1\"  billing=\"false\" placeholder=\"Line 1\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\"></td>\n" + 
						"                    <td><input id=\"bill_addr_2\"type=\"text\"  style=\"width:230px;\" name=\"bill_addr_2\" billing=\"false\" placeholder=\"Line 2\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\"></td>\n" + 
						"                    <td><input id=\"bill_addr_3\"type=\"text\"  style=\"width:230px;\" name=\"bill_addr_3\" billing=\"false\" placeholder=\"Line 3\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\"></td>\n" + 
						"                    <td><input id=\"bill_city\"type=\"text\"  style=\"width:112px;\"  name=\"bill_city\" billing=\"false\" placeholder=\"City\"/>&nbsp;<input id=\"regpincode\" type=\"text\"  style=\"width:113px;\" name=\"bill_pincode\" billing=\"false\" placeholder=\"Pincode\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\"></td>\n" + 
						"                    <td><input id=\"bill_state\" type=\"text\"  style=\"width:112px;\" name=\"bill_state\" billing=\"false\" placeholder=\"State\" />&nbsp;<input id=\"regcountry\" type=\"text\"  style=\"width:113px;\" name=\"bill_country\" billing=\"false\" placeholder=\"Country\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\" rowspan=\"2\" valign=\"top\" style=\"padding-top: 6px;\">Shipping  Address<br/><a href=\"javascript:void(0)\" id=\"addbilladdress\" class=\"bottomTitle\">As above</a></td>\n" + 
						"                    <td><input id=\"ship_addr_1\" type=\"text\"  style=\"width:230px;\" name=\"ship_addr_1\" placeholder=\"Line 1\"/></td>\n" + 
						"                </tr>\n" + 
						"                 <tr>\n" + 
						"                    <td><input id=\"ship_addr_2\" type=\"text\"  style=\"width:230px;\" name=\"ship_addr_2\"  placeholder=\"Line 2\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td></td>\n" + 
						"                    <td><input id=\"ship_addr_3\" type=\"text\"  style=\"width:230px;\" name=\"ship_addr_3\"  placeholder=\"Line 3\"/></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td></td>\n" + 
						"                    <td><input id=\"ship_city\" type=\"text\"  style=\"width:112px;\" name=\"ship_city\"  placeholder=\"City\"/>&nbsp;<input id=\"ship_pincode\" type=\"text\"  style=\"width:113px;\" name=\"ship_pincode\"  placeholder=\"Pincode\"/></td>\n" + 
						"                </tr>\n" + 
						"               \n" + 
						"                <tr>\n" + 
						"                    <td></td>\n" + 
						"                    <td><input id=\"ship_state\" type=\"text\"  style=\"width:112px;\" name=\"ship_state\"  placeholder=\"State\"/>&nbsp;<input id=\"ship_country\" type=\"text\"  style=\"width:113px;\" name=\"ship_country\"  placeholder=\"Country\"/></td>\n" + 
						"                </tr>\n" + 
						"            </table>\n" + 
						"        </div>\n" + 
						"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
						"            <div class=\"dataTitle\" >Opening Balance</div>\n" + 
						"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\" style=\"width:140px;\">Amount</td>\n" + 
						"                    <td><input id=\"current_balance\" type=\"text\"  style=\"width:230px;\" name=\"current_balance\" placeholder=\"Amount\" value=\"0.00\" /></td>\n" + 
						"                </tr>\n" + 
						"               	<tr>\n" + 
						"                    <td class=\"label\" style=\"width:140px;\">type</td>\n" + 
						"  					<td style=\"font-size:14px;\"><input style=\"width:20px;\" id=\"cont_is\" type=\"radio\" name=\"cont_is\" value=\"payable\" checked> Payable<input type=\"radio\" style=\"width:20px;\" name=\"cont_is\" value=\"receivable\">Receivable</td>\n" + 
						"                </tr>\n" + 
						"            </table>\n" + 
						"        </div>\n" + 
						"        <div class=\"dataDiv\" id=\"basicdetails\">\n" + 
						"            <div class=\"dataTitle\">Other</div>\n" + 
						"            <table cellspacing=\"0\" width=\"100%\" class=\"tdPadding\">\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\" style=\"width:140px;\">Currency</td>\n" + 
						"                    <td><input id=\"currency\" type=\"text\"  style=\"width:230px;\" name=\"currency\" placeholder=\"Currency\" value=\"Rupees\"/></td>\n" + 
						"                </tr>\n" + 
						"               	<tr>\n" + 
						"                    <td class=\"label\" style=\"width:140px;\">Due in Days</td>\n" + 
						"  					<td><input type=\"text\" id=\"cont_due_days\" style=\"width:230px;\" name=\"cont_due_days\" value=\"0\"></td>\n" + 
						"                </tr>\n" + 
						"                <tr>\n" + 
						"                    <td class=\"label\" style=\"width:140px;vertical-align: top;\">Notes</td>\n" + 
						"  					<td><textarea id=\"note\" name=\"note\" style=\"width:230px;height:125px;\"></textarea></td>\n" + 
						"                </tr>\n" + 
						"            </table>\n" + 
						"        </div>\n" + 
						"    <div style=\"clear:both;\"></div>\n" + 
						"    <div class=\"layout horizontal-reverse flex\">\n" + 
						"		<button class=\"buttonAction\" id=\"cancelBtn\">Cancel</button>\n" + 
						"		<button class=\"buttonAction\" id=\"addBtn\">Save</button>\n" + 
						"	</div>\"\n" + 
						"</div>\n" + 
						"</div>\n" + 
						"<script type=\"text/javascript\">\n" + 
						"$(\"input\").add(\"textarea\").addClass(\"input_text\");\n" + 
						"</script>");
				out.println("<script>"+
						"$(document).ready(function(){"+
						"var cedit = contactView($(\"#ContactAdd\"));"+
						"cedit.initContactAddView();"+
						"});"+
						 "</script>");
			}
			else{}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Database connection error");
		}
		
	}

}
