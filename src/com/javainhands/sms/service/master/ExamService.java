package com.javainhands.sms.service.master;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.master.Exam;
import com.javainhands.sms.model.master.StaffType;

public class ExamService {

	public static void saveExamType(Exam type) throws SQLException {
		System.out.println("validating Exam Type Request");

		if (type.getExamType() == null || type.getExamType().equals("")) {
			System.out.println("invalid exam type");
			return;
		}

		System.out.println("creating sql insert statement");
		String sql = "INSERT INTO master_exam_type(exam_type, created_date, updated_date) VALUES (?,?,?)";
		System.out.println("creating prepared starement");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("setting parameters for prepared statement");
		ps.setString(1, type.getExamType());
		ps.setDate(2, type.getCreatedDate());
		ps.setDate(3, type.getUpdatedDate());

		System.out.println("executing the prepared statement");
		int effected = ps.executeUpdate();

		if (effected == 1) {
			System.out.println("inserted exam Type successfully");
		} else {
			System.out.println("error in inserting exam Type");
			return;
		}
	}

	public static void saveExamTypeMain() throws SQLException {

		System.out.println("Reading input from console");
		Scanner scanner = new Scanner(System.in);

		System.out.println("please enter the exam type");
		String examType = scanner.next();

		Exam type = new Exam();
		type.setExamType(examType);
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		type.setUpdatedDate(new Date(System.currentTimeMillis()));

		System.out.println("calling saveExamType method");
		saveExamType(type);

		scanner.close();

	}

	public static void main(String[] args) throws SQLException {
//		saveExamTypeMain();
		findAll();
//		findExamId();
		
	}

	public static void findExamId() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		Exam type = new Exam();
				
		System.out.println("please enter the exam id");
		int examTypeId = scanner.nextInt();
		
		if (  examTypeId <= 0 ) {
			System.out.println("invalid exam type Id");
			return;
		}
		
		System.out.println("finding exam by id");
		System.out.println("creating sql statement");
		String sql = "select * from sms.master_exam_type where exam_type_id = (?)";
		
		
		
		System.out.println("creating statement for execution");
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ps.setInt(1, examTypeId);
		
		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();
		
		System.out.println("converting result set to list");
		List<Exam> list1 = new ArrayList<>();
		
		System.out.println("iterating result set");
		
		while (rs.next()) {
			
			type.setExamType(rs.getString("exam_type"));
			type.setExamTypeId(rs.getInt("exam_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list1.add(type);
			System.out.println("adding to list");
			list1.add(type);
		}
		System.out.println("retrieved exam types successfully");
		System.out.println(list1);
		
		scanner.close();
	}

	public static void findAll() throws SQLException {
		System.out.println("finding all exam types");

		System.out.println("creating sql statement");
		String sql = "select * from master_exam_type";

		System.out.println("creating statement for execution");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();

		System.out.println("converting result set to list");
		List<Exam> list1 = new ArrayList<>();

		System.out.println("iterating result set");
		while (rs.next()) {
			Exam type = new Exam();
			type.setExamType(rs.getString("exam_type"));
			type.setExamTypeId(rs.getInt("exam_type_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list1.add(type);
		}
		System.out.println("retrieved exam types successfully");
		System.out.println(list1);
	}
}
