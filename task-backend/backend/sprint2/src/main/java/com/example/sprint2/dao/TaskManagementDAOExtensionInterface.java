package com.example.sprint2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Tasks;

@Repository
public interface TaskManagementDAOExtensionInterface extends JpaRepository<Extension, Long>{

	@Modifying
	@Transactional
	@Query("update com.example.sprint2.entity.Extension ext set ext.extensionStatus=:status where ext.taskId=:id")
	public int approveTaskExtension(long id, String status);
	
	@Modifying
	@Transactional
	@Query("from com.example.sprint2.entity.Extension task where task.taskId=:id")
	public List<Extension> viewExtensionById(long id);
	
}
