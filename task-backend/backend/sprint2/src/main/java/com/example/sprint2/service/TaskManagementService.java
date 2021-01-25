package com.example.sprint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprint2.dto.TaskManagementDTOInterface;
import com.example.sprint2.entity.Admin;
import com.example.sprint2.entity.Comments;
import com.example.sprint2.entity.Employee;
import com.example.sprint2.entity.EmployeeTasks;
import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Leave;
import com.example.sprint2.entity.Tasks;

@Service
public class TaskManagementService implements TaskManagementServiceInterface {

	@Autowired
	TaskManagementDTOInterface dto;

	@Override
	public Admin addAdmin(Admin admin) {
		return dto.addAdminDTO(admin);
	}

	@Override
	public Admin loginAdmin(long id, String password) {
		return dto.loginAdminDTO(id, password);
	}

	@Override
	public Employee loginEmployee(long id, String password) {
		return dto.loginEmployeeDTO(id, password);
	}	
	
	@Override
	public Employee addEmployee(Employee employee) {
		return dto.addEmployeeDTO(employee);
	}
	
	@Override
	public int changePassword(long id, String passwd) {
		return dto.changePasswordDTO(id, passwd);
	}
	
	@Override
	public Employee deleteEmployeeById(long empid) {
		return dto.deleteEmployeeByIdDTO(empid);
	}
	
	@Override
	public Employee editEmployee(Employee employee, long id) {
		return dto.editEmployee(employee, id);
	}

	@Override
	public Employee viewEmployeeById(long id) {
		return dto.viewEmployeeByIdDTO(id);
	}

	@Override
	public List<Employee> viewAllEmployees() {
		return dto.viewAllEmployeesDTO();
	}

	@Override
	public Tasks addTask(Tasks task) {
		return dto.addTaskDTO(task);
	}

	@Override
	public Tasks assignTask(EmployeeTasks emptask, long id) {
		return dto.assignTaskDTO(emptask, id);
	}

	@Override
	public Tasks editTask(Tasks task,long taskId) {
		return dto.editTaskDTO(task,taskId);
	}

	@Override
	public Tasks deleteTaskById(long taskId) {
		return dto.deleteTaskDTO(taskId);
	}

	@Override
	public Tasks viewTask(long id) {
		return dto.viewTaskDTO(id);
	}

	@Override
	public List<Tasks> viewAssignedTasks(long id) {
		return dto.viewAssignedTasksDTO(id);
	}

	@Override
	public List<Tasks> viewAllTasks() {
		return dto.viewAllTasks();
	}
		
	@Override
	public Extension requestTaskExtension(Extension extension) {
		return dto.requestTaskExtensionDTO(extension);
	}

	@Override
	public Extension approveTaskExtension(long id, String status)  {
		return dto.approveTaskExtensionDTO(id, status);
	}

	@Override
	public List<Extension> viewExtensionById(long id) {
		return dto.viewExtensionByIdDTO(id);
	}
	
	@Override
	public Leave applyleave(Leave leaveId) {
		return dto.applyleaveDTO(leaveId);
	}


	@Override
	public List<Leave> viewLeaveById(long id) {
		return dto.viewLeaveByIdDTO(id);
	}
	
	@Override
	public Leave approveLeave(long id, String status)  {
		return dto.approveLeaveDTO(id, status);
	}

	
	@Override
	public Comments addComment(Comments comment) {
		return dto.addCommentDTO(comment);
	}

	@Override
	public List<Extension> requestedTaskExtension() {
		return dto.requestedTaskExtensionDTO();
	}

	@Override
	public List<Leave> applicationsForLeaves() {
		return dto.applicationsForLeavesDTO();
	}

	
	@Override
	public int deleteCommentById(long commentId) {
		
		return dto.deleteCommentByIdDTO(commentId);
	}

	@Override
	public List<Comments> viewAllComments() {
		return dto.viewAllCommentsDTO();
	}

	
}
