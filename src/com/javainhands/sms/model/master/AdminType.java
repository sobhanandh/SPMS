package com.javainhands.sms.model.master;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author honey
 * @apiNote model class used for AdminType Operations
 * @version 1.0
 */
public class AdminType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2880919794520925249L;

	private Integer admintypeId;
	private String admintype;
	private Date createdDate;
	private Date updatedDate;

	public Integer getAdmintypeId() {
		return admintypeId;
	}

	public void setAdmintypeId(Integer admintypeId) {
		this.admintypeId = admintypeId;
	}

	public String getAdmintype() {
		return admintype;
	}

	public void setAdmintype(String admintype) {
		this.admintype = admintype;
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
		return "AdminType [admintypeId=" + admintypeId + ", admintype=" + admintype + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}