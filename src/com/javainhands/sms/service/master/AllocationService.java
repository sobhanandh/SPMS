package com.javainhands.sms.service.master;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.Allocation;
import com.javainhands.sms.model.master.MasterAllocation;


public class AllocationService {

	public static void saveMasterAllocationType(MasterAllocation type) throws SQLException {
		System.out.println("validating Allocation Type Request");

		if (type.getAllocationType() == null || type.getAllocationType().equals("")) {
			System.out.println("invalid allocation type");
			return;
		}

		System.out.println("creating sql insert statement");
		String sql = "INSERT INTO master_allocation_type(allocation_type, created_date, updated_date) VALUES (?,?,?)";
		System.out.println("creating prepared starement");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("setting parameters for prepared statement");
		ps.setString(1, type.getAllocationType());
		ps.setDate(2, type.getCreatedDate());
		ps.setDate(3, type.getUpdatedDate());

		System.out.println("executing the prepared statement");
		int effected = ps.executeUpdate();

		if (effected == 1) {
			System.out.println("inserted allocation Type successfully");
		} else {
			System.out.println("error in inserting allocation Type");
			return;
		}
	}

	public static void saveAllocationTypeMain() throws SQLException {

		System.out.println("Reading input from console");
		Scanner scanner = new Scanner(System.in);

		System.out.println("please enter the allocation type");
		String allocationType = scanner.next();

		MasterAllocation type = new MasterAllocation();
		type.setAllocationType(allocationType);
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		type.setUpdatedDate(new Date(System.currentTimeMillis()));

		System.out.println("calling saveAllocationType method");
		saveMasterAllocationType(type);

		scanner.close();

	}

	public static void main(String[] args) throws SQLException {
//		saveAllocationTypeMain();
		findAll();
//		findAllocationId();
		
	}

	public static void findAllocationId() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		MasterAllocation type = new MasterAllocation();
				
		System.out.println("please enter the allocation id");
		int allocationTypeId = scanner.nextInt();
		
		if (  allocationTypeId <= 0 ) {
			System.out.println("invalid allocation type Id");
			return;
		}
		
		System.out.println("finding allocation by id");
		System.out.println("creating sql statement");
		String sql = "select * from sms.master_allocation_type where allocation_type_id = (?)";
		
		
		
		System.out.println("creating statement for execution");
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ps.setInt(1, allocationTypeId);
		
		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();
		
		System.out.println("converting result set to list");
		List<MasterAllocation> list1 = new ArrayList<>();
		
		System.out.println("iterating result set");
		
		while (rs.next()) {
			
			type.setAllocationType(rs.getString("allocation_type"));
			type.setAllocationTypeId(rs.getInt("allocation_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list1.add(type);
			System.out.println("adding to list");
			list1.add(type);
		}
		System.out.println("retrieved allocation types successfully");
		System.out.println(list1);
		
		scanner.close();
	}

	public static void findAll() throws SQLException {
		System.out.println("finding all allocation types");

		System.out.println("creating sql statement");
		String sql = "select * from master_allocation_type";

		System.out.println("creating statement for execution");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();

		System.out.println("converting result set to list");
		List<MasterAllocation> list1 = new ArrayList<>();

		System.out.println("iterating result set");
		while (rs.next()) {
			MasterAllocation type = new MasterAllocation();
			type.setAllocationType(rs.getString("allocation_type"));
			type.setAllocationTypeId(rs.getInt("allocation_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list1.add(type);
		}
		System.out.println("retrieved allocation types successfully");
		System.out.println(list1);
	}
}

