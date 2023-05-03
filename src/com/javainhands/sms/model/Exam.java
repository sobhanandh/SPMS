package com.javainhands.sms.model;

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
	private static final long serialVersionUID = -3355461336975295279L;

	private Integer examId;
	private Integer examTypeId;
	private Integer classId;
	private Integer studentId;
	private Integer subjectId;
	private Integer sectionId;
	private Integer marks;
	private Integer teacherId;
	private Date createdDate;
	private Date updatedDate;

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Integer getExamTypeId() {
		return examTypeId;
	}

	public void setExamTypeId(Integer examTypeId) {
		this.examTypeId = examTypeId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
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
		return "Exam [examId=" + examId + ", examTypeId=" + examTypeId + ", classId=" + classId + ", studentId="
				+ studentId + ", subjectId=" + subjectId + ", sectionId=" + sectionId + ", marks=" + marks
				+ ", teacherId=" + teacherId + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
