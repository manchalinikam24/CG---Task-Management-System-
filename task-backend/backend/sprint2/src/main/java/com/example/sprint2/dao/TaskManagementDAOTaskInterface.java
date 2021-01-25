package com.example.sprint2.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sprint2.entity.Tasks;

@Repository
public interface TaskManagementDAOTaskInterface extends JpaRepository<Tasks, Long> {
	
	@Modifying
	@Transactional
	@Query("update com.example.sprint2.entity.Tasks task set task.isdeleted=:status where task.taskId=:id")
	public int deleteTask(String status, long id);
	
	@Modifying
	@Transactional
	@Query("from com.example.sprint2.entity.Tasks task where task.taskStatus=:status and task.taskId=:id")
	public List<Tasks> AssignedTasks(String status, long id);
	
	@Modifying
	@Transactional
	@Query("update com.example.sprint2.entity.Tasks task set task.taskStatus =:taskStatus where task.taskId=:taskId")
	public Tasks assignTask(String taskStatus, long taskId);
	
	@Modifying
	@Transactional
	@Query("update com.example.sprint2.entity.Tasks task set task.taskStatus =:taskStatus where task.taskId=:taskId")
	public int updateStatus(String taskStatus, long taskId);

	@Modifying
	@Transactional
	@Query("from com.example.sprint2.entity.Tasks task where task.taskId=:id")
	public List<Tasks> viewTaskById(long id);

	
	
	
}
