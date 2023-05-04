package com.javainhands.sms.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javainhands.sms.common.ConnEstablish;
import com.javainhands.sms.model.Section;

public class SectionService {
	public static void savesectionmain() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Section type = new Section();
		System.out.println("enter Section Name");
		String name = sc.nextLine();
		System.out.println("enter Section id");
		Integer classId = sc.nextInt();
		

		type.setName(name);
		type.setClassId(classId);
		type.setUpdatedDate(new Date(System.currentTimeMillis()));
		type.setCreatedDate(new Date(System.currentTimeMillis()));

		savesection(type);

		sc.close();

	}

	public static void savesection(Section type) throws SQLException {

		if (type.getName() == null || type.getName().equals("")) {
			System.out.println("invalid entry");
			return;
		}
		String sql = "insert into section(name, class_Id, created_date, updated_date) values (?,?,?,?)";
		PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);

		ps.setString(1, type.getName());
		ps.setInt(2, type.getClassId());
		ps.setDate(3, type.getCreatedDate());
		ps.setDate(4, type.getUpdatedDate());

		int execution = ps.executeUpdate();

		if (execution == 1) {
			System.out.println("executed sucsessfully");
		} else
			System.out.println("error in inserting Section details");
		return;
	}
public static void main(String[] args) throws SQLException {
	
//	 savesectionmain();
 // findall();
	 findbyId();
}
public static void findbyId ()throws SQLException {
	Scanner sc = new Scanner(System.in);
	String sql = "select * from section where class_id =(?)";
	PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
	System.out.println("please enter class_Id");
	int class_Id = sc.nextInt();
	if (class_Id <= 0) {
	System.out.println("please enter valide Class_Id");
	return;
	}
	ps.setInt(1,class_Id);
	ResultSet rs = ps.executeQuery();
	List<Section> list = new ArrayList<>();
	while (rs.next()) {
		Section type = new Section ();
		type.setClassId(rs.getInt("class_id"));
		type.setName(rs.getString("name"));
		type.setCreatedDate(rs.getDate("created_date"));
		type.setUpdatedDate(rs.getDate("updated_date"));
		
		
		list.add(type);
		
	}
	System.out.println(list);
	
}
public static void findall ()throws SQLException {
	
	String sql = "select * from section";
	
	PreparedStatement ps = ConnEstablish.init().prepareStatement(sql);
	List<Section> list = new ArrayList<>();
	ResultSet rs = ps.executeQuery();
	Section type = new Section();
	
	while(rs.next()) {
	type.setName(rs.getString("name"));
	type.setClassId(rs.getInt("class_Id"));
	type.setCreatedDate(rs.getDate("created_date"));
	type.setUpdatedDate(rs.getDate("updated_date"));
	list.add(type);
	}
	
	System.out.println(list);
	
}
}



