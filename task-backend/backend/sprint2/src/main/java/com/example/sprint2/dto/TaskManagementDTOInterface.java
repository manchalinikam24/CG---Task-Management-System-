package com.example.sprint2.dto;

import java.util.List;

import com.example.sprint2.entity.Admin;
import com.example.sprint2.entity.Comments;
import com.example.sprint2.entity.Employee;
import com.example.sprint2.entity.EmployeeTasks;
import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Leave;
import com.example.sprint2.entity.Tasks;

public interface TaskManagementDTOInterface {
	
		//Authenticate
		Admin loginAdminDTO(long id, String password);
		
		Admin addAdminDTO(Admin admin);

		Employee loginEmployeeDTO(long id, String password);
		
		int changePasswordDTO(long id, String passwd);
		
		//Employee
		Employee addEmployeeDTO(Employee employee);

		Employee deleteEmployeeByIdDTO(long empid);
		
		Employee editEmployee(Employee employee, long id);
		
		Employee viewEmployeeByIdDTO(long id);
		
		List<Employee> viewAllEmployeesDTO();
		
		//Tasks
		Tasks addTaskDTO(Tasks task);
		
		Tasks assignTaskDTO(EmployeeTasks empt, long id);
		
		Tasks editTaskDTO(Tasks task,long taskId);
		
		Tasks deleteTaskDTO(long id);
		
		Tasks viewTaskDTO(long id);
		
		List<Tasks> viewAssignedTasksDTO(long id);
	
		public List<Tasks> viewAllTasks();
	
		//Extension
		Extension requestTaskExtensionDTO(Extension extension);
		
		List<Extension> requestedTaskExtensionDTO();
		
		List<Extension> viewExtensionByIdDTO(long id);
		
		Extension approveTaskExtensionDTO(long id, String status); 
		
		//Leave
		Leave applyleaveDTO(Leave leaveId) ;
		
		List<Leave> applicationsForLeavesDTO();
		
		List<Leave> viewLeaveByIdDTO(long id);
		
		Leave approveLeaveDTO(long id, String status);
		
		//Comment
		Comments addCommentDTO(Comments comment);
		
		int deleteCommentByIdDTO(long commentId);

		List<Comments> viewAllCommentsDTO();
	
}
