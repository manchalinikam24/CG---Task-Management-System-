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
import org.springframework.web.bind.annotation.RestController;

import com.example.sprint2.dao.TaskManagementDAOExtensionInterface;
import com.example.sprint2.dao.TaskManagementDAOTaskInterface;
import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Tasks;
import com.example.sprint2.exception.ResourceNotFoundException;
import com.example.sprint2.service.TaskManagementServiceInterface;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskManagementExtensionController {


	@Autowired
	TaskManagementServiceInterface service;
	
	@Autowired
	TaskManagementDAOTaskInterface taskDao;
	
	@Autowired
	TaskManagementDAOExtensionInterface extDao;
	
	//request task extension
	//@PostMapping("/employees")
	@PostMapping("/requestTaskExtensionController")
	public Extension requestTaskExtensionController(@RequestBody Extension extension) throws ResourceNotFoundException {
	
		if(service.requestTaskExtension(extension)!=null) {
			 return service.requestTaskExtension(extension);
		}
		else
		{
			throw new ResourceNotFoundException("Task id not found");
		}
	}
		
	//view extension requests method
	//@GetMapping("/employees/tasks/{id}")
	@GetMapping("/viewAllTasksExtensionRequests")
	public List<Extension> viewAllTasksExtensionRequestsController() throws ResourceNotFoundException {		
		return service.requestedTaskExtension();
	}
		
	//view task
	@GetMapping("/viewExtensionController/{id}")
	//@GetMapping("/viewTaskController/{id}")
	public List<Extension> viewExtensionController(@PathVariable("id") long id) throws ResourceNotFoundException {
		if(service.viewExtensionById(id)!=null) {
			System.out.println("Hello");
				return service.viewExtensionById(id);
			}
			else {
				throw new ResourceNotFoundException("No records found");
			}
		}
			
	//approval for task extension
	//@PutMapping("/employees/{id}/{status}")
	@PutMapping("/approveTaskExtensionController/{id}/{status}")
	public Extension approveTaskExtensionController(@PathVariable("id") long id, @PathVariable("status") String status) throws ResourceNotFoundException {
		Extension result = service.approveTaskExtension(id, status);
		if(result!=null)
		{
			return service.approveTaskExtension(id, status);
		}	
		return service.approveTaskExtension(id, status);
	}
}
