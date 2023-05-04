/**
 * 
 */
package com.javainhands.sms.service.master;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.master.AdminType;

/**
 * @author Lakshmi Kiran
 * @apiNote Service class used for Admin Type operations like create, update,
 *          and find
 * @version 1.0
 */
public class AdminTypeService {

	public static void saveAdminType(AdminType type) throws SQLException {

		System.out.println("validating Admin Type Request");

		if (type.getAdmintype() == null || type.getAdmintype().equals("")) {
			System.out.println("invalid admin type");
			return;
		}

		System.out.println("creating sql insert statement");
		String sql = "INSERT INTO master_admin_type(admin_type, created_date, updated_date) VALUES (?,?,?)";

		System.out.println("creating prepared starement");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("setting parameters for prepared statement");
		ps.setString(1, type.getAdmintype());
		ps.setDate(2, type.getCreatedDate());
		ps.setDate(3, type.getUpdatedDate());

		System.out.println("executing the prepared statement");
		int effected = ps.executeUpdate();

		if (effected == 1) {
			System.out.println("inserted Admin Type successfully");
		} else {
			System.out.println("error in inserting Admin Type");
			return;
		}

	}

	public static void saveAdminTypeMain() throws SQLException {

		System.out.println("Reading input from console");
		Scanner scanner = new Scanner(System.in);

		System.out.println("please enter the admin type");
		String adminType = scanner.next();

		AdminType type = new AdminType();
		type.setAdmintype(adminType);
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		type.setUpdatedDate(new Date(System.currentTimeMillis()));

		System.out.println("calling saveAdminType method");
		saveAdminType(type);

		scanner.close();

	}

	public static void main(String[] args) throws SQLException {
		// saveAdminTypeMain();
		// findAll();
		findbyid();

	}

	public static void findbyid() throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("finding admin by id");
		System.out.println("creating sql statement");

		String sql = "select * from master_admin_type where admin_type_id = (?)";
		System.out.println("creating connection");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		System.out.println("please enter admin id ");
		int id = sc.nextInt();
		
		
		if (id <= 0) {
			System.out.println("invalid admin id, please enter valid number");
		} else
			ps.setInt(1, id);
		
		
		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();

		System.out.println("converting result set to list");
		List<AdminType> list = new ArrayList<>();
		System.out.println("iterating result set");
		while (rs.next()) {
			AdminType type = new AdminType();

			type.setAdmintype(rs.getString("admin_type"));
			type.setAdmintypeId(rs.getInt("admin_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list.add(type);

		}

		System.out.println(list);

	}

	public static void findAll() throws SQLException {
		System.out.println("finding all admin types");

		System.out.println("creating sql statement");
		String sql = "select * from master_admin_type";

		System.out.println("creating statement for execution");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();

		System.out.println("converting result set to list");
		List<AdminType> list = new ArrayList<>();

		System.out.println("iterating result set");
		while (rs.next()) {
			AdminType type = new AdminType();
			type.setAdmintype(rs.getString("admin_type"));
			type.setAdmintypeId(rs.getInt("admin_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list.add(type);
		}
		System.out.println("retrieved admin types successfully");
		System.out.println(list);
	}
}
