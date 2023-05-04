package com.javainhands.sms.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.Student;

public class StudentService {
	
	public static void saveStudent() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		Student type = new Student();
		
		System.out.println("Enter Student Name");
		String studentname = sc.nextLine();
		System.out.println("Enter Student Email");
		String email = sc.nextLine();
		System.out.println("Enter Parent Mobile Number");
		String ParentMobile = sc.nextLine();
		
		type.setStudentName(studentname);
		type.setEmail(email);
		type.setParentMobile(ParentMobile);
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		type.setUpdatedDate(new Date(System.currentTimeMillis()));
		
		
			saveStudentMain(type);
		
		
	}
	public static void saveStudentMain(Student type) throws SQLException{
		
		if (type.getStudentName() == null || type.getStudentName().equals("") ) {
			
			System.out.println("please entered a valid name");
			
			return;
		}
		
		String sql = "insert into student (student_name, email, parent_mobile, created_date, updated_date) values (?,?,?,?,?)";
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ps.setString(1 , type.getStudentName());
		ps.setString(2, type.getEmail());
		ps.setString(3, type.getParentMobile());
		ps.setDate(4, type.getCreatedDate());
		ps.setDate(5, type.getUpdatedDate());
		
		Integer exigution = ps.executeUpdate();
		
		if (exigution == 1) {
			System.out.println("Updated Successfully");
		}
		else 
			System.out.println("exigution failed, please try again");
	}
	
	public static void main(String[] args) throws SQLException {
		// saveStudent();
		//findall();
		findbyId();
		
	}
	public static void findbyId()throws SQLException {
		Scanner sc = new Scanner (System.in);
		String sql = "select * from student where student_id =(?)";
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		System.out.println("please enter student_id");
		int Student_id = sc.nextInt();
		if(Student_id <=0) {
			System.out.println("please enter valid student id ");
			return;
		}
		ps.setInt(1, Student_id);
		ResultSet rs = ps.executeQuery();
		List<Student> list = new ArrayList<>();
		
		while(rs.next()) {
			Student type = new Student();
			type.setStudentId(rs.getInt("Student_id"));
			type.setStudentName(rs.getString("student_name"));
			type.setEmail(rs.getString("email"));
			type.setParentMobile(rs.getString("parent_mobile"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));
			
			list.add(type);
		}
		System.out.println(list);
	}
	
	public static void findall() throws SQLException{
		
		String sql = "select * from student";
		
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Student> list = new ArrayList<>();
		
		while(rs.next()){
			Student type = new Student();
			
			type.setStudentName(rs.getString("student_name"));
			type.setEmail(rs.getString("email"));
			type.setParentMobile(rs.getString("parent_mobile"));
			type.setCreatedDate(rs.getDate("created_date"));
			type.setUpdatedDate(rs.getDate("updated_date"));
			
			list.add(type);
		}
		
		System.out.println(list);
		
	}
	
}
