package com.example.sprint2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sprint2.entity.Employee;
import com.example.sprint2.entity.Tasks;

@Repository
public interface TaskManagementDAOEmployeeInterface extends JpaRepository<Employee, Long> {
	
	@Modifying
	@Transactional
	@Query("update com.example.sprint2.entity.Employee emp set emp.isdeleted=:status where emp.empId=:empid")
	public int deleteEmployee(String status, long empid);

	@Modifying
	@Transactional
	@Query("from com.example.sprint2.entity.Employee emp where emp.empId=:id")
	public List<Employee> viewEmployeeById(long id);


}

