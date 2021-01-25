package com.example.sprint2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sprint2.entity.Comments;

@Repository
public interface TaskManagementDAOCommentInterface extends JpaRepository<Comments, Long> {

}
