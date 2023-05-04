package com.javainhands.sms.service.master;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.master.MasterClass;

public class ClassService {
	public static void saveMasterClass(MasterClass type) throws SQLException {
		System.out.println("validating Class Request");

		if (type.getStandard() == null || type.getStandard().equals("")) {
			System.out.println("invalid Class");
			return;
		}

		System.out.println("creating sql insert statement");
		String sql = "INSERT INTO master_class(Standard, created_date, updated_date) VALUES (?,?,?)";
		System.out.println("creating prepared statement");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("setting parameters for prepared statement");
		ps.setString(1, type.getStandard());
		ps.setDate(2, type.getCreatedDate());
		ps.setDate(3, type.getUpdatedDate());


		System.out.println("executing the prepared statement");
		int effected = ps.executeUpdate();

		if (effected == 1) {
			System.out.println("inserted Class successfully");
		} else {
			System.out.println("error in inserting Class");
			return;
		}
	}

	public static void saveClassMain() throws SQLException {

		System.out.println("Reading input from console");
		Scanner scanner = new Scanner(System.in);

		System.out.println("please enter the Class");
		String MasterClass = scanner.next();

		MasterClass type = new MasterClass();
		type.setStandard(MasterClass);
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		type.setUpdatedDate(new Date(System.currentTimeMillis()));

		System.out.println("calling saveClass method");
		saveMasterClass(type);

		scanner.close();

	}

	public static void main(String[] args) throws SQLException {
		//saveClassMain();
		//findAll();
		findClassId();
		
	}

	public static void findClassId() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		MasterClass type = new MasterClass();
		
		System.out.println("please enter the Class id");
		int ClassId = scanner.nextInt();
		
		if (  ClassId <= 0 ) {
			System.out.println("invalid Class Id");
			return;
		}
		
		System.out.println("finding Class id");
		System.out.println("creating sql statement");
		String sql = "select * from master_class where class_id = (?)";
		
		
		
		System.out.println("creating statement for execution");
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ps.setInt(1, ClassId);
		
		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();
		
		System.out.println("converting result set to list");
		List<MasterClass> list1 = new ArrayList<>();
		
		System.out.println("iterating result set");
		
		while (rs.next()) {
			
			type.setStandard(rs.getString("Standard"));
			type.setClassId(rs.getInt("Class_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list1.add(type);
		}
		System.out.println("retrieved Classes successfully");
		System.out.println(list1);
		
		scanner.close();
	}

	public static void findAll() throws SQLException {
		System.out.println("finding all Classes");

		System.out.println("creating sql statement");
		String sql = "select * from master_class";

		System.out.println("creating statement for execution");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();

		System.out.println("converting result set to list");
		List<MasterClass> list = new ArrayList<>();

		System.out.println("iterating result set");
		while (rs.next()) {
			MasterClass type = new MasterClass();
			type.setStandard(rs.getString("Standard"));
			type.setClassId(rs.getInt("Class_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list.add(type);
		}
		System.out.println("retrieved Classes successfully");
		System.out.println(list);
	}
	

}
