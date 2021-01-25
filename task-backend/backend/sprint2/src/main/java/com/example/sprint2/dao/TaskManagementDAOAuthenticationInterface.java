package com.example.sprint2.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sprint2.entity.Admin;
import com.example.sprint2.entity.Employee;
@Repository
public interface TaskManagementDAOAuthenticationInterface extends JpaRepository<Admin, Long> {

	@Transactional
	@Modifying
	@Query("update com.example.sprint2.entity.Admin a set a.password=:passwd where a.empId=:id")
	int changePasswd(long id, String passwd);
	
	@Query("from com.example.sprint2.entity.Admin admin where admin.empId=:id and admin.password=:password")
	Admin loginAdmin(long id, String password);

	@Query("from com.example.sprint2.entity.Employee emp where emp.empId=:id and emp.password=:password")
	Employee loginEmployee(long id, String password);

}
