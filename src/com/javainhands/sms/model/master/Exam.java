package com.javainhands.sms.model.master;

import java.io.Serializable;
import java.sql.Date;
/**
 * @author sarath
 * @apiNote model class used for Exam
 * @version 1.0
 */

public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7192770233381963114L;
	
	private Integer examTypeId;
	private String examType;
	private Date createdDate;
	private Date updatedDate;
	public Integer getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(Integer examTypeId) {
		this.examTypeId = examTypeId;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
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
		return "Exam [examTypeId=" + examTypeId + ", examType=" + examType + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
	
	
}
