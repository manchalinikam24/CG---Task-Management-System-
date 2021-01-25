package com.example.sprint2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class EmployeeTasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empTaskId;
	private long taskId;
	private long empId;
	private String startDate;
	private String endDate;
//	
//	@ManyToMany(mappedBy = "emptask1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Tasks> task;
	
	public long getEmpTaskId() {
		return empTaskId;
	}
	public void setEmpTaskId(long empTaskId) {
		this.empTaskId = empTaskId;
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
//	public List<Tasks> getTask() {
//		return task;
//	}
//	public void setTask(List<Tasks> task) {
//		this.task = task;
//	}
//
//	
}
