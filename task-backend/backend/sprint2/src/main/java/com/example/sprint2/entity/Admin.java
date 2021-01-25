package com.example.sprint2.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	private long empId;
	private String password;
	private LocalDate authenticationDate;
	
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getAuthenticationDate() {
		return authenticationDate;
	}
	public void setAuthenticationDate(LocalDate authenticationDate) {
		this.authenticationDate = authenticationDate;
	}
	
}
