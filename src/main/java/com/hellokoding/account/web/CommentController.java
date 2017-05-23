/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.web;

import com.hellokoding.account.model.Comment;
import com.hellokoding.account.model.Post;
import com.hellokoding.account.repository.CommentRepository;
import com.hellokoding.account.service.CommentService;
import com.hellokoding.account.viewModel.CommentView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kklos
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    
    @Autowired
    CommentRepository commentRepository; 
    
    @Autowired
    CommentService commentService;
    
    @RequestMapping(value = "/addComment", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<CommentView> addComment(@RequestBody CommentView comment) {

		if(comment == null)
		{
			return new ResponseEntity<CommentView>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		commentService.saveCommentToDatabase(comment);
        return new ResponseEntity<CommentView>(comment, HttpStatus.OK);
	}
        
    @RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
    public @ResponseBody
    List<Comment> getAllComments() {


        List<Comment> commentsFromDatabase = commentRepository.findAll();

        return commentsFromDatabase;
    }
        
        
}
