package com.example.sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprint2.dao.TaskManagementDAOEmployeeInterface;
import com.example.sprint2.entity.Admin;
import com.example.sprint2.entity.Employee;
import com.example.sprint2.exception.ResourceNotFoundException;
import com.example.sprint2.service.TaskManagementServiceInterface;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TaskManagementAuthenticationController {
	
	@Autowired
	TaskManagementServiceInterface service;
	
	@Autowired
	TaskManagementDAOEmployeeInterface empDao;
	
	@GetMapping("/loginAdminController/{id}/{password}")
	public String loginAdminController(@PathVariable("id") long id, @PathVariable("password") String password) {
		Object obj = null;
			obj = service.loginAdmin(id, password);
			if (obj != null)
			return "Login successfull";
		else
			return "Id or password is incorrect";
	}
	
	
	@GetMapping("/loginEmployeeController/{id}/{password}")
	public String loginEmployeeController(@PathVariable("id") long id, @PathVariable("password") String password) {
		Object obj = null;
			obj = service.loginEmployee(id, password);
			if (obj != null)
			return "Login successfull";
		else
			return "Id or password is incorrect";
	}
	
	//add Employee
		@PostMapping("/admin")
		public Admin addAdminController(@RequestBody Admin admin) throws ResourceNotFoundException  {
			return service.addAdmin(admin);
		}

}

////Login
//@PostMapping("/user/auth")
//public Admin loginAdminController(@RequestBody Admin admin,@PathVariable("id") long id, @PathVariable("password") String password ) {
//	admin=service.loginAdmin(id, password);
//	return admin;
//
//}
//
//@PostMapping("/user/auth")
//public Employee loginEmployeeController(@RequestBody Employee employee,@PathVariable("id") long id, @PathVariable("password") String password ) {
//	employee=service.loginEmployee(id, password);
//	return employee;
//
//}
//
////@PutMapping("/user/{id}/auth")
//@PutMapping("/changePasswordController/{id},{paswd}")
//public int changePasswordController(@PathVariable(value ="id") long id, @PathVariable(value="paswd") String paswd)
//{
//	int res=0;
//	Employee t=empDao.findById(id).orElse(null);
//	if(t.isIsdeleted()==false && t!=null) {
//		res= service.changePassword(id, paswd);
//	}
//	return res;
//	
//}
