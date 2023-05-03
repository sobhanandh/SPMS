package com.javainhands.sms.model;

import java.io.Serializable;
import java.sql.Date;


/**
 * @author pooja
 * @apiNote model class used for admin operations
 * @version 1.0
 */
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1530970339872465912L;

	private Integer adminId;
	private String adminName;
	private String email;
	private String mobile;
	private String password;
	private Integer adminTypeId;
	private Date createdDate;
	private Date updatedDate;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public Integer getAdminTypeId() {
		return adminTypeId;
	}

	public void setAdminTypeId(Integer adminTypeId) {
		this.adminTypeId = adminTypeId;
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
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + ", adminTypeId=" + adminTypeId + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
