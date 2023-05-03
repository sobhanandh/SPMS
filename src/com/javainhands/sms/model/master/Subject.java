package com.javainhands.sms.model.master;

import java.io.Serializable;
import java.sql.Date;


/**
 * @author honey
 * @apiNote model class used for Subject Operations
 * @version 1.0
 */
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 893274529163723869L;

	private Integer subjectId;
	private String subjectname;
	private Date createdDate;
	private Date updatedDate;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
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
		return "Subject [subjectId=" + subjectId + ", subjectname=" + subjectname + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
