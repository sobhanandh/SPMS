package com.javainhands.sms.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sarath
 * @apiNote model class used for allocation
 * @version 1.0
 */

public class Allocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8769639637714157030L;

	private Integer allocationId;
	private Integer allocationTypeId;
	private Integer studentId;
	private Integer teacherId;
	private Integer subjectId;
	private Integer classId;
	private Integer sectionId;
	private Date createdDate;
	private Date updatedDate;

	public Integer getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(Integer allocationId) {
		this.allocationId = allocationId;
	}

	public Integer getAllocationTypeId() {
		return allocationTypeId;
	}

	public void setAllocationTypeId(Integer allocationTypeId) {
		this.allocationTypeId = allocationTypeId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
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
		return "Allocation [allocationId=" + allocationId + ", allocationTypeId=" + allocationTypeId + ", studentId="
				+ studentId + ", teacherId=" + teacherId + ", subjectId=" + subjectId + ", classId=" + classId
				+ ", sectionId=" + sectionId + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
