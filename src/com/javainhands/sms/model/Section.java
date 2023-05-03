package com.javainhands.sms.model;

import java.io.Serializable;
import java.sql.Date;
/**
 * @author Shoban Anandh
 * @apiNote model class for section operations
 * @version 1.0
 * 
 */

public class Section implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2917607818481136189L;

	private Integer sectionId;
	private String name;
	private Integer classId;
	private Date createdDate;
	private Date updatedDate;

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
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
		return "Section [sectionId=" + sectionId + ", name=" + name + ", classId=" + classId + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
