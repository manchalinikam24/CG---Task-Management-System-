package com.example.sprint2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprint2.dao.TaskManagementDAOEmployeeInterface;
import com.example.sprint2.dao.TaskManagementDAOLeaveInterface;
import com.example.sprint2.entity.Employee;
import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Leave;
import com.example.sprint2.exception.ResourceNotFoundException;
import com.example.sprint2.service.TaskManagementServiceInterface;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskManagementLeaveController {


	@Autowired
	TaskManagementServiceInterface service;
	
	@Autowired 
	TaskManagementDAOEmployeeInterface empDao;
	
	@Autowired
	TaskManagementDAOLeaveInterface leaveDao;
	
	//apply leave //id/
	//@PostMapping("/employees/{id}/leaves/{id}")
	@PostMapping("/applyLeaveController")
	public Leave applyLeaveController(@RequestBody Leave leave) throws ResourceNotFoundException {
		if(service.applyleave(leave)!=null) {
			 return service.applyleave(leave);
		}
		else
		{
			throw new ResourceNotFoundException("Task id not found");
		}
	}
		
	//view leave requests method
	@GetMapping("/viewAllLeaveRequestsController")
	public List<Leave> viewAllLeaveRequestsController() throws ResourceNotFoundException {
		return service.applicationsForLeaves();
	}
	
	@GetMapping("/viewLeaveController/{id}")
	public List<Leave> viewLeaveController(@PathVariable("id") long id) throws ResourceNotFoundException {
		if(service.viewLeaveById(id)!=null) {
			System.out.println("Hello");
			System.out.println("Hello");
				return service.viewLeaveById(id);
			}
			else {
				throw new ResourceNotFoundException("No records found");
			}
		}
	
	//approval for leave
	//@PutMapping("/emps/{id}/leaves/{id},{status}")
	
	@PutMapping("/approveLeaveController/{id}/{status}")
	//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.PUT)
	public Leave approveLeaveController(@PathVariable("id") long id, @PathVariable("status") String status) throws ResourceNotFoundException {
		System.out.println("Hello");
			if(service.approveLeave(id, status)!=null)
			{
				return service.approveLeave(id, status);
			}
			return service.approveLeave(id, status);
	}
		
}
