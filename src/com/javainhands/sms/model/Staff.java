package com.javainhands.sms.model;

import java.io.Serializable;
import java.sql.Date;


/**
 * @author pooja
 * @apiNote model class for staff operations
 * @version 1.0
 */
public class Staff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6373516654875072774L;

	private Integer staffId;
	private String staffName;
	private String email;
	private String mobile;
	private String password;
	private Integer staffTypeId;
	private Date createdDate;
	private Date updatedDate;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStaffTypeId() {
		return staffTypeId;
	}

	public void setStaffTypeId(Integer staffTypeId) {
		this.staffTypeId = staffTypeId;
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
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + ", staffTypeId=" + staffTypeId + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
