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
import com.example.sprint2.entity.Employee;
import com.example.sprint2.entity.Tasks;
import com.example.sprint2.exception.ResourceNotFoundException;
import com.example.sprint2.service.TaskManagementServiceInterface;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class TaskManagementEmployeeController {
	
	@Autowired
	TaskManagementServiceInterface service;

	@Autowired 
	TaskManagementDAOEmployeeInterface empDao;
	
	
	//add Employee
	@PostMapping("/employees")
	public Employee addEmployeeController(@RequestBody Employee employee) throws ResourceNotFoundException  {
		return service.addEmployee(employee);
	}

	
	//edit employee
	@PutMapping("/editEmployeeController/{id}")
	public ResponseEntity<Employee> editEmployeeController(@PathVariable("id") long id,@RequestBody Employee employee) throws ResourceNotFoundException {
		System.out.println("edit");
	
		if(service.editEmployee(employee,id)!=null) {
			System.out.println("hiiii");
			 return ResponseEntity.ok(service.editEmployee(employee,id));
		}
		else {
			throw new ResourceNotFoundException("Employee id not found");
		}
	}
		
	//delete Employee
	@DeleteMapping("/emps/{id}")
	public Employee deleteEmployeeController(@PathVariable("id") long id) throws ResourceNotFoundException {
		System.out.println(id);
		if((service.deleteEmployeeById(id))!=null)
		{	System.out.println(id);
			return service.deleteEmployeeById(id);
		}
		else {
			throw new ResourceNotFoundException("Employee id not found");
		}
	}
	
	//view task
	@GetMapping("/viewEmployeeController/{id}")
	//@GetMapping("/viewTaskController/{id}")
		public Employee viewEmployeeController(@PathVariable("id") long id) throws ResourceNotFoundException {
			
			if(service.viewEmployeeById(id)!=null) {
				return service.viewEmployeeById(id);
			}
			else {
				throw new ResourceNotFoundException("No records found");
			}
			
		}
		
	
	@GetMapping("/viewAllEmployeesController")
	//@GetMapping("/viewPendingTasksController/{id},{status}")
	public List<Employee> viewAllEmployeesController() throws ResourceNotFoundException {
		
		List<Employee> l1=new ArrayList<Employee>();
		List<Employee> l=service.viewAllEmployees();
		if(l!=null) {
			for(Employee t:l) {
				int r=l.indexOf(t);
				if(t.getIsdeleted().equals("false")) {
					System.out.println("nnjen");
					l1.add(t);
				}
			}
			for(Employee t:l1) {
				System.out.println(t.getEmpId());
			}
			return l1;
		}
		else {
			throw new ResourceNotFoundException("No records found");
		}
	}
}

