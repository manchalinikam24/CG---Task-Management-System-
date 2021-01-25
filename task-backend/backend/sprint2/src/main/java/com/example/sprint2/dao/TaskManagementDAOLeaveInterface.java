package com.example.sprint2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Leave;

@Repository
public interface TaskManagementDAOLeaveInterface extends JpaRepository<Leave, Long> {
	
	@Modifying
	@Transactional
	@Query("update com.example.sprint2.entity.Leave leave set leave.leaveStatus=:status where leave.empId=:id")
	public int approveLeave(long id, String status);

	
	@Modifying
	@Transactional
	@Query("from com.example.sprint2.entity.Leave leave where leave.empId=:id")
	public List<Leave> viewLeaveById(long id);

}
