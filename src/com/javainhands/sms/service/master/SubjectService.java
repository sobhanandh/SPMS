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
import com.javainhands.sms.model.master.Subject;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

public class SubjectService {

	public static void saveSubjectName(Subject type)throws SQLException {
	
		System.out.println("validating subject name request");
		if(type.getSubjectname() == null || type.getSubjectname().equals("")) {
			System.out.println("Invalid Subject Name");
			return;
		}
		
		System.out.println("creating sql insert statement");
		String sql = "INSERT INTO master_subject (subject_name, created_date, updated_date) VALUES (?,?,?)";
		System.out.println("creating prepared starement");
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		System.out.println("setting parameters for prepared statement");
		ps.setString(1, type.getSubjectname());
		ps.setDate(2, type.getCreatedDate());
		ps.setDate(3, type.getUpdatedDate());
		System.out.println("executing the prepared statement");
		int effected = ps.executeUpdate();
		
		if (effected == 1) {
			System.out.println("inseted subject name successfully");
		} else {
			System.out.println("error in inserting subject Type");
			return;
		}
	}
	
	public static void saveSubjectNameInitiate() throws SQLException {
			
		Scanner sc = new Scanner(System.in);
		Subject type = new Subject();
		System.out.println("Please Enter Subject Name");
		String subjectName = sc.next();
		
		type.setSubjectname(subjectName);
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		type.setUpdatedDate(new Date(System.currentTimeMillis()));	
			
		saveSubjectName(type);
		
		sc.close();
		
		}
		
	public static void main(String[] args) throws SQLException{
//		saveSubjectNameInitiate();
	//	findall();
		findSubjectId();
		
	}
public static void findSubjectId() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		Subject type = new Subject();
		
		System.out.println("please enter the subject id");
		int SubjectId = scanner.nextInt();
		
		if (  SubjectId <= 0 ) {
			System.out.println("invalid subject Id");
			return;
		}
		
		System.out.println("finding subject by id");
		System.out.println("creating sql statement");
		String sql = "select * from sms.master_subject where subject_id = (?)";
		
		
		
		System.out.println("creating statement for execution");
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ps.setInt(1, SubjectId);
		
		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();
		
		System.out.println("converting result set to list");
		List<Subject> list1 = new ArrayList<>();
		
		System.out.println("iterating result set");
		
		while (rs.next()) {
			
			type.setSubjectname(rs.getString("subject_name"));
			type.setSubjectId(rs.getInt("subject_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));

			System.out.println("adding to list");
			list1.add(type);
			System.out.println("adding to list");
			list1.add(type);
		}
		System.out.println("retrieved subject names successfully");
		System.out.println(list1);
		
		scanner.close();
	}

	
	public static void findall() throws SQLException{
		
		System.out.println("finding all subjects");
		
		System.out.println("creating sql statement");
		
		String sql = "SELECT * FROM sms. master_subject";
		System.out.println("creating statement for execution");
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		System.out.println("extracting result set");
		ResultSet rs = ps.executeQuery();
		System.out.println("converting result set to list");
		 List<Subject> list = new ArrayList<>();
		while (rs.next()) {
			Subject type = new Subject();
			type.setSubjectname(rs.getString("subject_name"));
			type.setSubjectId(rs.getInt("subject_id"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));
			
			System.out.println("adding to list");
			list.add(type);
		}
		
		System.out.println("retrieved subject names successfully");
		System.out.println(list);
		
		
		
	}
}
