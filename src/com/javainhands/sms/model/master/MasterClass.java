package com.javainhands.sms.model.master;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author pooja
 * @apiNote model class used for MasterClass Operations
 * @version 1.0
 */
public class MasterClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5863864052925378679L;

	private Integer classId;
	private String standard;
	private Date createdDate;
	private Date updatedDate;

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
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
		return "MasterClass [classId=" + classId + ", standard=" + standard + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
