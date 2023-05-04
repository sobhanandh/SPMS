package com.javainhands.sms.model;

import java.io.Serializable;
import java.sql.Date;


/**
 * @author Shoban
 * @apiNote model class for student operations
 * @version 1.0
 */

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5966749471424445912L;

	private Integer studentId;
	private String studentName;
	private String email;
	private String parentMobile;
	private Date createdDate;
	private Date updatedDate;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParentMobile() {
		return parentMobile;
	}

	public void setParentMobile(String parentMobile) {
		this.parentMobile = parentMobile;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", email=" + email
				+ ", parentMobile=" + parentMobile + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

}
