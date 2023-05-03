package com.javainhands.sms.service.master;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.master.StaffType;

public class StaffService {

	public static void saveStaffType(StaffType type) throws SQLException {
		System.out.println("validating Staff Type Request");

		if (type.getStafftype() == null || type.getStafftype().equals("")) {
			System.out.println("invalid staff type");
			return;
		}

		System.out.println("creating sql insert statement");
		String sql = "INSERT INTO master_staff_type(staff_type, created_date, updated_date) VALUES (?,?,?)";
		System.out.println("creating prepared starement");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("setting parameters for prepared statement");
		ps.setString(1, type.getStafftype());
		ps.setDate(2, type.getCreatedDate());
		ps.setDate(3, type.getUpdatedDate());

		System.out.println("executing the prepared statement");
		int effected = ps.executeUpdate();

		if (effected == 1) {
			System.out.println("inserted staff Type successfully");
		} else {
			System.out.println("error in inserting staff Type");
			return;
		}
	}

	public static void saveStaffTypeMain() throws SQLException {

		System.out.println("Reading input from console");
		Scanner scanner = new Scanner(System.in);

		System.out.println("please enter the staff type");
		String staffType = scanner.next();

		StaffType type = new StaffType();
		type.setStafftype(staffType);
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		type.setUpdatedDate(new Date(System.currentTimeMillis()));

		System.out.println("calling saveAdminType method");
		saveStaffType(type);

		scanner.close();

	}

	public static void main(String[] args) throws SQLException {
//		saveStaffTypeMain();
		// findAll();
		findStaffId();

	}

	public static void findStaffId() throws SQLException {

		Scanner scanner = new Scanner(System.in);

		StaffType type = new StaffType();

		System.out.println("please enter the staff id");
		int staffTypeId = scanner.nextInt();

		if (staffTypeId <= 0) {
			System.out.println("invalid staff type Id");
			return;
		}

		System.out.println("finding staff by id");
		System.out.println("creating sql statement");
		String sql = "select * from sms.master_staff_type where staff_type_id = (?)";

		System.out.println("creating statement for execution");

		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		ps.setInt(1, staffTypeId);

		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();

		System.out.println("converting result set to list");
		List<StaffType> list1 = new ArrayList<>();

		System.out.println("iterating result set");

		while (rs.next()) {

			type.setStafftype(rs.getString("staff_type"));
			type.setStafftypeId(rs.getInt("staff_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list1.add(type);
			System.out.println("adding to list");
			list1.add(type);
		}
		System.out.println("retrieved staff types successfully");
		System.out.println(list1);

		scanner.close();
	}

	public static void findAll() throws SQLException {
		System.out.println("finding all staff types");

		System.out.println("creating sql statement");
		String sql = "select * from master_staff_type";

		System.out.println("creating statement for execution");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();

		System.out.println("converting result set to list");
		List<StaffType> list = new ArrayList<>();

		System.out.println("iterating result set");
		while (rs.next()) {
			StaffType type = new StaffType();
			type.setStafftype(rs.getString("staff_type"));
			type.setStafftypeId(rs.getInt("staff_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list.add(type);
		}
		System.out.println("retrieved staff types successfully");
		System.out.println(list);
	}
}
