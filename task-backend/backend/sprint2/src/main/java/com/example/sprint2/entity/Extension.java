package com.example.sprint2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Extension {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long extensionId;
	private long empId;
	private long taskId;
	private String extensionStatus = "Pending";
	private String extensionReason;
	private String revisedDate;
	
	public long getExtensionId() {
		return extensionId;
	}
	public void setExtensionId(long extensionId) {
		this.extensionId = extensionId;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getExtensionStatus() {
		return extensionStatus;
	}
	public void setExtensionStatus(String extensionStatus) {
		this.extensionStatus = extensionStatus;
	}
	public String getExtensionReason() {
		return extensionReason;
	}
	public void setExtensionReason(String extensionReason) {
		this.extensionReason = extensionReason;
	}
	public String getRevisedDate() {
		return revisedDate;
	}
	public void setRevisedDate(String revisedDate) {
		this.revisedDate = revisedDate;
	}

}
