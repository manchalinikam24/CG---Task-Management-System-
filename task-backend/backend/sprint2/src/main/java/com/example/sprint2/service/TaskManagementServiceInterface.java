package com.example.sprint2.service;

import java.util.List;

import com.example.sprint2.entity.Admin;
import com.example.sprint2.entity.Comments;
import com.example.sprint2.entity.Employee;
import com.example.sprint2.entity.EmployeeTasks;
import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Leave;
import com.example.sprint2.entity.Tasks;

public interface TaskManagementServiceInterface {
	
	Admin loginAdmin(long id, String password);
	
	Admin addAdmin(Admin admin);
	
	Employee loginEmployee(long id, String password);
	
	int changePassword(long id, String passwd);
	
	Employee addEmployee(Employee employee);
	
	Employee deleteEmployeeById(long empid);
	
	public Employee editEmployee(Employee employee, long id);
	
	public Employee viewEmployeeById(long id);
	
	public List<Employee> viewAllEmployees();
	
	Tasks addTask(Tasks task);
	
	Tasks assignTask(EmployeeTasks empt, long id);
	
	Tasks editTask(Tasks task,long taskId);
	
	public Tasks deleteTaskById(long taskId);
	
	public Tasks viewTask(long id);
	
	public List<Tasks> viewAssignedTasks(long id);
	
	public List<Tasks> viewAllTasks(); 

	Extension requestTaskExtension(Extension extension);
	
	List<Extension> viewExtensionById(long id);
	
	public List<Extension> requestedTaskExtension();
	
	Extension approveTaskExtension(long id, String status); 
	
	Leave applyleave(Leave leaveId) ;
	
	public List<Leave> applicationsForLeaves();
	
	List<Leave> viewLeaveById(long id);
	
	Leave approveLeave(long id, String status); 
	
	Comments addComment(Comments comment);

	public int deleteCommentById(long commentId);
	
	List<Comments> viewAllComments();
	
}
