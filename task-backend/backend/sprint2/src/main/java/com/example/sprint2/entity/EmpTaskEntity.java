package com.example.sprint2.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmpTaskEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long emptaskentityId;
	
	private long taskId;
	private long empId;
	private String tasksTitle;
	private String description;
	private String taskStatus;
	private String startDate;
	private String endDate;
	
	public EmpTaskEntity(long taskId, long empId, String tasksTitle, String description, String startDate, String endDate) {
		this.taskId = taskId;
		this.empId = empId;
		this.tasksTitle = tasksTitle;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getTasksTitle() {
		return tasksTitle;
	}
	public void setTasksTitle(String tasksTitle) {
		this.tasksTitle = tasksTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "EmpTaskEntity [taskId=" + taskId + ", empId=" + empId + ", tasksTitle=" + tasksTitle + ", description="
				+ description + ",taskStatus=" + taskStatus + " ,startDate=" + startDate + ", endDate=" + endDate + " ]";
	}

}
