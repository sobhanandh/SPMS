package com.javainhands.sms.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.Admin;

public class AdminService {
	
	public static void saveadminmain() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		Admin type = new Admin();
		System.out.println("enter admin Name");
		String adminName = sc.nextLine();
		System.out.println("enter admin Email");
		String email = sc.nextLine();
		System.out.println("enter admin Mobile");
		String mobile = sc.nextLine();
		System.out.println("enter admin Password");
		String password = sc.nextLine();
		
		type.setAdminName(adminName);
		type.setEmail(email);
		type.setMobile(mobile);
		type.setPassword(password);
		type.setUpdatedDate(new Date(System.currentTimeMillis()));
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		
		saveadmin(type);
		
		sc.close();
		
	}
	
	public static void saveadmin(Admin type)throws SQLException {
		
		if (type.getAdminName()== null || type.getAdminName().equals("")) {
			System.out.println("invalid entry");
			return;
		}
		 
		String sql = "insert into app_admin(admin_name, email, mobile, a_password, created_date, updated_date) values (?,?,?,?,?,?)";
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ps.setString(1, type.getAdminName());
		ps.setString(2, type.getEmail());
		ps.setString(3, type.getMobile());
		ps.setString(4, type.getPassword());
		ps.setDate(5, type.getCreatedDate());
		ps.setDate(6, type.getUpdatedDate());
		
		int exigution = ps.executeUpdate();
		
		if (exigution == 1) {
			System.out.println("exiguted sucsessfully");
		}
		else System.out.println("erroe in inserting admin details");
		return;
	}

	public static void main(String[] args) throws SQLException {
		
//		 saveadminmain();
//       findall();
		findbyId();
	}
	public static void findbyId ()throws SQLException {
		Scanner sc = new Scanner(System.in);
		String sql = "select * from app_admin where admin_id =(?)";
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		System.out.println("please enter Admin_Id");
		int admin_id = sc.nextInt();
		if (admin_id <= 0) {
		System.out.println("please enter valide Admin_Id");
		return;
		}
		ps.setInt(1,admin_id);
		ResultSet rs = ps.executeQuery();
		List<Admin> list = new ArrayList<>();
		while (rs.next()) {
			Admin type = new Admin ();
			type.setAdminId(rs.getInt("admin_id"));
			type.setAdminName(rs.getString("admin_name"));
			type.setEmail(rs.getString("email"));
			type.setMobile(rs.getString("mobile"));
			type.setPassword(rs.getString("a_password"));
			type.setAdminTypeId(rs.getInt("admin_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));
			
			
			list.add(type);
			
		}
		System.out.println(list);
		
		
	}
	
	public static void findall ()throws SQLException {
		
		String sql = "select * from app_admin";
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		List<Admin> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		Admin type = new Admin();
		
		while(rs.next()) {
		type.setAdminName(rs.getString("admin_name"));
		type.setEmail(rs.getString("email"));
		type.setMobile(rs.getString("mobile"));
		type.setPassword(rs.getString("a_password"));
		type.setCreatedDate(rs.getDate("created_date"));
		type.setUpdatedDate(rs.getDate("updated_date"));
		list.add(type);
		}
		
		System.out.println(list);
		
	}
}
