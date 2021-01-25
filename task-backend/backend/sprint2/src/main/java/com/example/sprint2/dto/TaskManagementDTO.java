package com.example.sprint2.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprint2.dao.TaskManagementDAOAuthenticationInterface;
import com.example.sprint2.dao.TaskManagementDAOCommentInterface;
import com.example.sprint2.dao.TaskManagementDAOEmployeeInterface;
import com.example.sprint2.dao.TaskManagementDAOEmployeeTaskInterface;
import com.example.sprint2.dao.TaskManagementDAOExtensionInterface;
import com.example.sprint2.dao.TaskManagementDAOLeaveInterface;
import com.example.sprint2.dao.TaskManagementDAOTaskInterface;
import com.example.sprint2.entity.Admin;
import com.example.sprint2.entity.Comments;
import com.example.sprint2.entity.Employee;
import com.example.sprint2.entity.EmployeeTasks;
import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Leave;
import com.example.sprint2.entity.Tasks;

@Service
public class TaskManagementDTO implements TaskManagementDTOInterface {
	
	@Autowired
	private TaskManagementDAOAuthenticationInterface authDAO;
	
	@Autowired 
	TaskManagementDAOEmployeeInterface empDao;
	
	@Autowired
	TaskManagementDAOTaskInterface taskDao;
	
	@Autowired
	TaskManagementDAOEmployeeTaskInterface emptaskDao;
	
	@Autowired
	TaskManagementDAOCommentInterface commentDao;

	@Autowired
	TaskManagementDAOExtensionInterface extensionDao;
	
	@Autowired
	TaskManagementDAOLeaveInterface leaveDao;
	
	@Autowired
	TaskManagementDAOAuthenticationInterface auth;
	
	//Login 
	public Admin addAdminDTO(Admin admin) {
		return authDAO.save(admin);
	}
	
	@Override
	public Admin loginAdminDTO(long id, String password) {
		return authDAO.loginAdmin(id, password);
	}
	@Override
	public Employee loginEmployeeDTO(long id, String password) {
		return authDAO.loginEmployee(id, password);
	}
				
	//change password
		@Override
		public int changePasswordDTO(long id, String passwd) {
			return authDAO.changePasswd(id, passwd);
		}
	//add employee
		@Override
		public Employee addEmployeeDTO(Employee employee) {
			 employee.setUpdateddate(LocalDate.now());
			employee.setIsdeleted("false");
			return empDao.save(employee);	
		}
		

		//delete employee
		public Employee deleteEmployeeByIdDTO(long empid) {
			Employee employee1=empDao.findById(empid).orElse(null);
			int result =0;	
			if(employee1!=null && employee1.getIsdeleted().equals("false")) {
				String status="true";
				result = empDao.deleteEmployee(status, empid);
			}
			if(result>0) {
				return empDao.findById(empid).orElse(null);
			}
			return null;
			
		}
		
		//edit employee
		public Employee editEmployee(Employee employee, long id) {
			
			Employee employee1=empDao.findById(id).orElse(null);
			employee1.setAddress(employee.getAddress());
			employee1.setEmpName(employee.getEmpName());
			employee1.setContactno(employee.getContactno());
			employee1.setEmailId(employee.getEmailId());
			//employee1.setIsdeleted(false);
			if(employee1!=null && employee1.getIsdeleted().equals("false")) {
				employee = empDao.save(employee1);
			}
			return employee;
		}
		
		@Override
		public Employee viewEmployeeByIdDTO(long id) {
			
			Employee employee1=empDao.findById(id).orElse(null);
			if(employee1!=null && employee1.getIsdeleted().equals("false")) {
				return empDao.findById(id).orElse(null);
			}
			return null;
		}

		@Override
		public List<Employee> viewAllEmployeesDTO() {
				return empDao.findAll();
		}
		
		@Override
		public Tasks addTaskDTO(Tasks task) {
			task.setIsdeleted("false");;
			task.setTaskStatus("Pending");
			return taskDao.save(task);
		}

		//Assign Task
		public Tasks assignTaskDTO(EmployeeTasks emptask, long id) {
			String status="Assigned"; 
			int res=0;
			emptask.setTaskId(id);
			Tasks t=new Tasks();
			Employee e=empDao.findById(emptask.getEmpId()).orElse(null);
			if(e.getIsdeleted().equals("false") && e!=null) {
				emptaskDao.save(emptask);
				res=taskDao.updateStatus(status, id);
			}
			if(res>0) {
				return taskDao.findById(id).orElse(null);
			}
			else {
				t.setTasksTitle("Not assigned");
				return t;
			}
			//return taskDao.findById(id).orElse(null);
			
		}

		//Edit Task
		public Tasks editTaskDTO(Tasks task,long taskId) {
			
			Tasks task1=taskDao.findById(taskId).orElse(null);
			Tasks result=null;
			task1.setTasksTitle(task.getTasksTitle());
			task1.setDescription(task.getDescription());
		//	task.setDeleted(false);
			if(task1!=null && task1.getIsdeleted().equals("false")) {
				result=taskDao.save(task1);
			}
			return result;
		}

		//Delete Task
		public Tasks deleteTaskDTO(long id) {
			Tasks task=taskDao.findById(id).orElse(null);
			int result =0;	
			if(task!=null && task.getIsdeleted().equals("false")) {
				String status="true";
				result = taskDao.deleteTask(status, id);
			}
			if(result>0) {
				return taskDao.findById(id).orElse(null);
			}
			return null;
		}
		
		//View Task By Id
		@Override
		public Tasks viewTaskDTO(long id) {
			Tasks task=taskDao.findById(id).orElse(null);
			if(task!=null && task.getIsdeleted().equals("false")) {
				return taskDao.findById(id).orElse(null);
			}
			return null;
		}
		public List<Tasks> viewAssignedTasksDTO(long id) {
			List<EmployeeTasks> l=emptaskDao.view(id);
			List<Tasks> t2=new ArrayList<Tasks>();
			Tasks t1=new Tasks();
			for(EmployeeTasks t:l) {
				System.out.println("kkkk");
				 t1=taskDao.findById(t.getTaskId()).orElse(null);
				if(t1.getTaskStatus().equals("Assigned")) {
					System.out.println("lll");
					t2.add(t1);
				}
				for(Tasks res:t2) {
					System.out.println(res.getTaskId());
				}
			}
			System.out.println(t2.size());
			for(Tasks res:t2) {
				System.out.println(res.getTaskId());
			}
			return t2;
		}

		public List<Tasks> viewAllTasks() {
			return taskDao.findAll();
		}

		//Request Task Extension
		@Override
		public Extension requestTaskExtensionDTO(Extension extension) {

			Tasks task=taskDao.findById(extension.getTaskId()).orElse(null);
			if(task.getIsdeleted().equals("false") && task!=null) {
				extension.setExtensionStatus("Pending");
				return extensionDao.save(extension);
			}
			return null;
		}
		
		//List all extension requests
		@Override
		public List<Extension> requestedTaskExtensionDTO() {
			return extensionDao.findAll();
		}

		//Approval for task extension
		@Override
		public Extension approveTaskExtensionDTO(long id, String status){
			Tasks task=taskDao.findById(id).orElse(null);

			int result=0;
			if(task!=null) {
				result = extensionDao.approveTaskExtension(id, status);
			}
			if(result>0)
			{
				return extensionDao.findById(id).orElse(null);
			}
			return null;
			
		}
		
		
		@Override
		public List<Extension> viewExtensionByIdDTO(long id) {
			Tasks task=taskDao.findById(id).orElse(null);
			if(task!=null && task.getIsdeleted().equals("false")) {
				return extensionDao.viewExtensionById(id);
			}
			return null;
		}
	
		//Apply for leave
		@Override
		public Leave applyleaveDTO(Leave leave) {
			Employee employee=empDao.findById(leave.getEmpId()).orElse(null);
			if(employee.getIsdeleted().equals("false") && employee!=null) {
				leave.setLeaveStatus("Pending");
				return leaveDao.save(leave);
			}
			return null;
			
		}
		

		@Override
		public List<Leave> viewLeaveByIdDTO(long id) {
			Employee emp=empDao.findById(id).orElse(null);
			if(emp!=null && emp.getIsdeleted().equals("false")) {
				return leaveDao.viewLeaveById(id);
			}
			return null;
		}
		
		//List all leave application
		@Override
		public List<Leave> applicationsForLeavesDTO() {
			return leaveDao.findAll();
		}
		
		//Approval for leave
		@Override
		public Leave approveLeaveDTO(long id, String status) {
			Employee employee = empDao.findById(id).orElse(null);
			int result = 0;
			if(employee!=null) {
				result = leaveDao.approveLeave(id, status);
			}
			if(result >0)
			{
				return leaveDao.findById(id).orElse(null);
			}
			return null;
		}
		
		//Add comment
		@Override
		public Comments addCommentDTO(Comments com) {
			long id=com.getTaskId();
			Tasks task=taskDao.findById(id).orElse(null);
			 com.setCommentDate(LocalDate.now());
			if(task!=null && task.getIsdeleted().equals("false")) {
				return commentDao.save(com);
			}
			return com;
		}
	
		//delete comment 
		@Override
		public int deleteCommentByIdDTO(long id) {
			int i=0;
			commentDao.deleteById(id);
			i=1;
			return i;
		}

		@Override
		public List<Comments> viewAllCommentsDTO() {
			return commentDao.findAll();
		}
		
}
