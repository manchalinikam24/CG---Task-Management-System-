package com.example.sprint2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprint2.dao.TaskManagementDAOTaskInterface;
import com.example.sprint2.entity.Comments;
import com.example.sprint2.entity.Extension;
import com.example.sprint2.entity.Tasks;
import com.example.sprint2.exception.ResourceNotFoundException;
import com.example.sprint2.service.TaskManagementServiceInterface;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskManagementCommentController {
	
	@Autowired
	TaskManagementServiceInterface service;
	
	@Autowired
	TaskManagementDAOTaskInterface taskDao;
	
	//add comment
	//@PostMapping("/employees/{id}/tasks/{id}/comments")
	@PostMapping("/comments")
	public Comments addCommentController(@RequestBody Comments comment) throws ResourceNotFoundException
	{
		if(service.addComment(comment)!=null) {
			return service.addComment(comment);
		}
		else 
		{
			throw new ResourceNotFoundException("Employee id not found");
		}
	}
	
	//view extension requests method
	//@GetMapping("/employees/tasks/{id}")
	@GetMapping("/viewAllCommentsController")
	public List<Comments> viewAllCommentsController() throws ResourceNotFoundException {		
		return service.viewAllComments();
	}
	
		
	//delete comment
	//@DeleteMapping("/employees/{id}/tasks/{id}/comments/{commentId}")
	@DeleteMapping("/deleteCommentController/{commentId}")
	public String deleteCommentController(@PathVariable("commentId") long commentId) throws ResourceNotFoundException {
		
		if(service.deleteCommentById(commentId)==1)
		{
			return "Comment deleted";
		}
		else 
		{
			throw new ResourceNotFoundException("Employee id not found");
		}
	}
}
