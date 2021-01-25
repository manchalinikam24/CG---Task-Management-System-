package com.example.sprint2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sprint2.entity.EmployeeTasks;

@Repository
public interface TaskManagementDAOEmployeeTaskInterface extends JpaRepository<EmployeeTasks, Long> {
	
	@Modifying
	@Transactional
	@Query("from com.example.sprint2.entity.EmployeeTasks task where task.empId=:id")
	public List<EmployeeTasks> view(long id);

}
