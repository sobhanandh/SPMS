package com.javainhands.sms.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.Staff;

public class StaffService {
	
	public static void savestaff()throws SQLException {
		
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("Enter staff name");
		String staffName = sc.next();
		System.out.println("Enter email");
		String email = sc.next();
		System.out.println("mobile");
		String mobile = sc.next();
		System.out.println("enter password");
		String password = sc.next();
		
		Staff type = new Staff();
		
		type.setStaffName(staffName);
		type.setEmail(email);
		type.setMobile(mobile);
		type.setPassword(password);
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		type.setUpdatedDate(new Date(System.currentTimeMillis()));
		
		staffsavemain(type);
		sc.close();
	}
	
	public static void staffsavemain(Staff type)throws SQLException{
		
		if (type.getStaffName() == null || type.getStaffName().equals("") ) {
			System.out.println("invalid entry");
			return;
			
		}
		
		String sql = "insert into sms.staff (staff_name, email, mobile, password, created_date, updated_date ) values (?,?,?,?,?,?)";

		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ps.setString(1, type.getStaffName());
		ps.setString(2, type.getEmail());
		ps.setString(3, type.getMobile());
		ps.setString(4, type.getPassword());
		ps.setDate(5, type.getCreatedDate());
		ps.setDate(6, type.getUpdatedDate());
		
		Integer execution = ps.executeUpdate();
		
		if (execution == 1) {
			System.out.println("data entered successfully");
		}
		
		else {
			System.out.println("execution failed");
			return;
		}
		
		
	}

	public static void main(String[] args) throws SQLException {
		
		//savestaff();
//		findall();
		findbyid ();
		
	}
	 public static void findbyid () throws SQLException {
		  Scanner sc = new Scanner (System.in);
		 String sql = "select * from staff where staff_id =(?)";
		 PreparedStatement ps =ConnEstablish.init().prepareStatement(sql);
		 System.out.println("please enter valid staff_id");
		 int staff_id =sc.nextInt();
		 if (staff_id <= 0) {
			 System.out.println("please enter valid staff_id");
			 return ;
		 }
		 ps.setInt(1, staff_id);
		 ResultSet rs = ps.executeQuery();
		 List<Staff> list = new ArrayList<>();
		 while (rs.next()) {
			 Staff type =new Staff ();
			 type.setStaffId(rs.getInt("staff_id"));
			 type.setStaffName(rs.getString("staff_name"));
			 type.setEmail(rs.getString("email"));
			 type.setMobile(rs.getString("mobile"));
			 type.setPassword(rs.getString("password"));
			 type.setStaffTypeId(rs.getInt("staff_type_id"));
			 type.setCreatedDate(rs.getDate("created_date"));
			 type.setUpdatedDate(rs.getDate("updated_date"));
			 
			 list.add(type);
			 
		 }
		 System.out.println(list);

	 }
	
	public static void findall() throws SQLException {
		
		String sql = "Select * from staff";
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Staff> list = new ArrayList<>();
		
		while(rs.next()) {
			
			Staff type = new Staff();
			
			type.setStaffName(rs.getString("staff_name"));
			type.setEmail(rs.getString("email"));
			type.setMobile(rs.getString("mobile"));
			type.setPassword(rs.getString("password"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));
			
			list.add(type);
		}
		
		System.out.println(list);
	}
	
}
