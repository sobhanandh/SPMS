package com.javainhands.sms.model.master;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author honey
 * @apiNote model class used for Staff type Operations
 * @version 1.0
 */
public class StaffType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8561622224607197909L;

	private Integer stafftypeId;
	private String stafftype;
	private Date createdDate;
	private Date updatedDate;

	public Integer getStafftypeId() {
		return stafftypeId;
	}

	public void setStafftypeId(Integer stafftypeId) {
		this.stafftypeId = stafftypeId;
	}

	public String getStafftype() {
		return stafftype;
	}

	public void setStafftype(String stafftype) {
		this.stafftype = stafftype;
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
		return "StaffType [stafftypeId=" + stafftypeId + ", stafftype=" + stafftype + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
