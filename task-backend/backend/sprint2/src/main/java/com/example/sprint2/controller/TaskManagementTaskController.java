package com.example.sprint2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprint2.dao.TaskManagementDAOEmployeeInterface;
import com.example.sprint2.dao.TaskManagementDAOEmployeeTaskInterface;
import com.example.sprint2.dao.TaskManagementDAOTaskInterface;
import com.example.sprint2.entity.EmployeeTasks;
import com.example.sprint2.entity.Tasks;
import com.example.sprint2.exception.ResourceNotFoundException;
import com.example.sprint2.service.TaskManagementServiceInterface;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class TaskManagementTaskController {

	@Autowired
	TaskManagementServiceInterface service;
	
	@Autowired
	TaskManagementDAOTaskInterface taskDao;
	
	@Autowired 
	TaskManagementDAOEmployeeInterface empDao;
	
	@Autowired
	TaskManagementDAOEmployeeTaskInterface emptaskdao;

	
	//add task
	@PostMapping("/tasks")
	public  Tasks addTaskController(@RequestBody Tasks task) throws ResourceNotFoundException {
		 return service.addTask(task);		 
	}
		
	//Assign task
	//@PutMapping("/tasks/{status}")
	@PutMapping("/assignTaskController/{taskId}")
	public Tasks assignTaskController(@RequestBody EmployeeTasks emptask,@PathVariable("taskId") long id) throws ResourceNotFoundException
	{
		Tasks t=new Tasks();
		System.out.println("hello"+emptask.getTaskId());
		if(service.assignTask(emptask, id)!=null) {
			System.out.println("hello");
			return service.assignTask(emptask, id);
		}
		else
		{
			t.setTasksTitle("task not found");
			return t;
			//throw new ResourceNotFoundException("Task not Assigned");
		}
	}
			
	//delete task
	@DeleteMapping("/tasks/{taskId}")
	//@PutMapping("/deleteTaskController/{taskId}")
	public Tasks deleteTaskController(@PathVariable("taskId") long id) throws ResourceNotFoundException {
		
		if(service.deleteTaskById(id)!=null)
		{
			return service.deleteTaskById(id);
		}
		else {
			throw new ResourceNotFoundException("Task not found");
		}
	}
			
		//view task
		//@GetMapping("/tasks/t/{id}")
	@GetMapping("/viewTaskController/{id}")
		public Tasks viewTaskController(@PathVariable("id") long id) throws ResourceNotFoundException {
			System.out.println("hello");
			if(service.viewTask(id)!=null) {
				return service.viewTask(id);
			}
			else {
				throw new ResourceNotFoundException("No records found");
			}
		}
			
	//	@PutMapping("/tasks")
		@PutMapping("/editTaskController/{id}")
		public ResponseEntity<Tasks> editTaskController(@PathVariable("id") long id,@RequestBody Tasks task) throws ResourceNotFoundException {
			System.out.println("edit");
		
			if(service.editTask(task,id)!=null) {
				System.out.println("hiiii");
				 return ResponseEntity.ok(service.editTask(task,id));
			}
			else {
				throw new ResourceNotFoundException("Employee id not found");
			}
		}
			
		//view pending task
		//@GetMapping("/tasks/{id}")
		@GetMapping("/viewAssignedTasksController/{id}")
		public List<Tasks> viewAssignedTasksController(@PathVariable("id") long id) throws ResourceNotFoundException {
			System.out.println("hello");
			if(service.viewAssignedTasks(id)!=null) {
				System.out.println("hiii");
				return service.viewAssignedTasks(id);
			}
			else {
				throw new ResourceNotFoundException("No records found");
			}
		}
		
		@GetMapping("/tasks")
		//@GetMapping("/viewPendingTasksController/{id},{status}")
		public List<Tasks> viewAllTasks() throws ResourceNotFoundException {
			
			List<Tasks> l1=new ArrayList<Tasks>();
			List<Tasks> l=service.viewAllTasks();
			if(l!=null) {
				System.out.println("l");
				for(Tasks t:l) {
					int r=l.indexOf(t);
					//System.out.println(t.getIsdeleted());
					if(t.getIsdeleted().equals("false")) {
						System.out.println("nnjen");
						l1.add(t);
						
					}
					
				}
				
				for(Tasks t:l1) {
					System.out.println(t.getTaskId());
				}
				return l1;
			}
			else {
				throw new ResourceNotFoundException("No records found");
			}
		}
	
}
