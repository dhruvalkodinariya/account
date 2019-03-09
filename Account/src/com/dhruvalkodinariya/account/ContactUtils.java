package com.dhruvalkodinariya.account;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ContactUtils {
	
	public static void addContact(Contacts contact,Connection c) {
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) c.prepareStatement("INSERT INTO `Contacts`(`cust_name`, `name_in_invoice`, `company`, `cont_type`, `cont_due_days`, `mobile_no`, `email`, `gst_no`, `pan_no`, `bill_addr_1`, `bill_addr_2`, `bill_addr_3`, `bill_pincode`, `bill_city`, `bill_state`, `bill_country`, `ship_addr_1`, `ship_addr_2`, `ship_addr_3`, `ship_pincode`, `ship_city`, `ship_state`, `ship_country`, `currency`, `current_balance`, `cont_is`, `note`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, contact.getCust_name());
			pstmt.setString(2, contact.getName_in_invoice());
			pstmt.setString(3, "Compnany");
			pstmt.setString(4, "Type");
			pstmt.setString(5, contact.getCont_due_days());
			pstmt.setString(6, contact.getMobile_no());
			pstmt.setString(7, contact.getEmail());
			pstmt.setString(8, contact.getGst_no());
			pstmt.setString(9, contact.getPan_no());
			pstmt.setString(10, contact.getBill_addr_1());
			pstmt.setString(11, contact.getBill_addr_2());
			pstmt.setString(12, contact.getBill_addr_3());
			pstmt.setString(13, contact.getBill_pincode());
			pstmt.setString(14, contact.getBill_city());
			pstmt.setString(15, contact.getBill_state());
			pstmt.setString(16, contact.getBill_country());
			pstmt.setString(17, contact.getShip_addr_1());
			pstmt.setString(18, contact.getShip_addr_2());
			pstmt.setString(19, contact.getShip_addr_3());
			pstmt.setString(20, contact.getShip_pincode());
			pstmt.setString(21, contact.getShip_city());
			pstmt.setString(22, contact.getShip_state());
			pstmt.setString(23, contact.getShip_country());
			pstmt.setString(24, contact.getCurrency());
			pstmt.setString(25, contact.getCurrent_balance());
			pstmt.setString(26, contact.getCont_is());
			pstmt.setString(27, contact.getNote());
			int rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void editContact(Contacts contact,Connection c) {
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) c.prepareStatement("UPDATE `Contacts` SET `cust_name`=?,`name_in_invoice`=?,`company`=?,`cont_type`=?,`cont_due_days`=?,`mobile_no`=?,`email`=?,`gst_no`=?,`pan_no`=?,`bill_addr_1`=?,`bill_addr_2`=?,`bill_addr_3`=?,`bill_pincode`=?,`bill_city`=?,`bill_state`=?,`bill_country`=?,`ship_addr_1`=?,`ship_addr_2`=?,`ship_addr_3`=?,`ship_pincode`=?,`ship_city`=?,`ship_state`=?,`ship_country`=?,`currency`=?,`current_balance`=?,`cont_is`=?,`note`=? WHERE `cont_id`=?");
			pstmt.setString(1, contact.getCust_name());
			pstmt.setString(2, contact.getName_in_invoice());
			pstmt.setString(3, "Compnany");
			pstmt.setString(4, "Type");
			pstmt.setString(5, contact.getCont_due_days());
			pstmt.setString(6, contact.getMobile_no());
			pstmt.setString(7, contact.getEmail());
			pstmt.setString(8, contact.getGst_no());
			pstmt.setString(9, contact.getPan_no());
			pstmt.setString(10, contact.getBill_addr_1());
			pstmt.setString(11, contact.getBill_addr_2());
			pstmt.setString(12, contact.getBill_addr_3());
			pstmt.setString(13, contact.getBill_pincode());
			pstmt.setString(14, contact.getBill_city());
			pstmt.setString(15, contact.getBill_state());
			pstmt.setString(16, contact.getBill_country());
			pstmt.setString(17, contact.getShip_addr_1());
			pstmt.setString(18, contact.getShip_addr_2());
			pstmt.setString(19, contact.getShip_addr_3());
			pstmt.setString(20, contact.getShip_pincode());
			pstmt.setString(21, contact.getShip_city());
			pstmt.setString(22, contact.getShip_state());
			pstmt.setString(23, contact.getShip_country());
			pstmt.setString(24, contact.getCurrency());
			pstmt.setString(25, contact.getCurrent_balance());
			pstmt.setString(26, contact.getCont_is());
			pstmt.setString(27, contact.getNote());
			pstmt.setInt(28, contact.getCont_id());
			int rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
