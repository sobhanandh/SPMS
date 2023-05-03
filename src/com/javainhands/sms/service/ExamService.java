package com.javainhands.sms.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.Exam;

public class ExamService {
public static void saveexammain() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		Exam type = new Exam();
		System.out.println("enter ExamId");
		Integer examId = sc.nextInt();
		System.out.println("enter classId");
		Integer classId = sc.nextInt();
		System.out.println("enter SubjectId");
		Integer subjectId = sc.nextInt();
		System.out.println("enter SectionId");
		Integer sectionId = sc.nextInt();
		System.out.println("enter marks");
		Integer marks = sc.nextInt();
		System.out.println("enter TeacherId");
		Integer teacherId = sc.nextInt();
		
		type.setExamId(examId);
		type.setClassId(classId);
		type.setSectionId(sectionId);
		type.setSubjectId(subjectId);
		type.setTeacherId(teacherId);
		type.setExamId(examId);
		type.setMarks(marks);
		type.setUpdatedDate(new Date(System.currentTimeMillis()));
		type.setCreatedDate(new Date(System.currentTimeMillis()));
		
		saveexam(type);
		
		sc.close();
}	
	
public static void saveexam(Exam type)throws SQLException {
	
	if (type.getExamId()== null || type.getExamId().equals("")) {
		System.out.println("invalid entry");
		return;
	}
	String sql = "insert into exam(exam_Id,subject_Id, Teacher_Id, class_Id, section_Id, created_date, updated_date) values (?,?,?,?,?,?)";
	
	PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
	
	ps.setInt(1, type.getExamId());
	ps.setInt(1, type.getSubjectId());
	ps.setInt(1, type.getTeacherId());
	ps.setInt(1, type.getClassId());
	ps.setInt(1, type.getSectionId());
	ps.setDate(5, type.getCreatedDate());
	ps.setDate(6, type.getUpdatedDate());
	
	int execution = ps.executeUpdate();
	
	if (execution == 1) {
		System.out.println("executed sucsessfully");
	}
	else 
		System.out.println("erroe in inserting Exam details");
	return;
}

public static void main(String[] args) throws SQLException {
	
	 saveexammain();
//   findall();
//	findbyId();
}
public static void findbyId ()throws SQLException {
	Scanner sc = new Scanner(System.in);
	String sql = "select * from section where exam_id =(?)";
	PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
	System.out.println("please enter exam_Id");
	int exam_Id = sc.nextInt();
	if (exam_Id <= 0) {
	System.out.println("please enter valid Exam_Id");
	return;
	}
	ps.setInt(1,exam_Id);
	ResultSet rs = ps.executeQuery();
	List<Exam> list = new ArrayList<>();
	while (rs.next()) {
		Exam type = new Exam ();
		type.setClassId(rs.getInt("class_id"));
		type.setExamId(rs.getInt("exam_id"));
		type.setSubjectId(rs.getInt("subject_id"));
		type.setSectionId(rs.getInt("section_id"));
		type.setTeacherId(rs.getInt("teacher_id"));
		type.setCreatedDate(rs.getDate("created_date"));
		type.setUpdatedDate(rs.getDate("updated_date"));
		
		
		list.add(type);
		
	}
	System.out.println(list);
	
}
public static void findall ()throws SQLException {
	
	String sql = "select * from exam";
	
	PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
	List<Exam> list = new ArrayList<>();
	ResultSet rs = ps.executeQuery();
	Exam type = new Exam();
	
	while(rs.next()) {
	type.setClassId(rs.getInt("class_Id"));
	type.setSectionId(rs.getInt("section_Id"));
	type.setSubjectId(rs.getInt("subject_Id"));
	type.setTeacherId(rs.getInt("teacher_Id"));
	type.setCreatedDate(rs.getDate("created_date"));
	type.setUpdatedDate(rs.getDate("updated_date"));
	list.add(type);
	}
	
	System.out.println(list);
	
}
}





