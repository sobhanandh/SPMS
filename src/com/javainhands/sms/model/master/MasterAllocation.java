package com.javainhands.sms.model.master;

import java.io.Serializable;
import java.sql.Date;


/**
 * @author Shoban Anandh
 * @apiNote model used for master allocationtype
 * @version 1.0
 */

public class MasterAllocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4932296352720364952L;

	private Integer allocationTypeId;
	private String allocationType;
	private Date createdDate;
	private Date updatedDate;

	public Integer getAllocationTypeId() {
		return allocationTypeId;
	}

	public void setAllocationTypeId(Integer allocationTypeId) {
		this.allocationTypeId = allocationTypeId;
	}

	public String getAllocationType() {
		return allocationType;
	}

	public void setAllocationType(String allocationType) {
		this.allocationType = allocationType;
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
		return "AllocationType [allocationTypeId=" + allocationTypeId + ", allocationType=" + allocationType
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
