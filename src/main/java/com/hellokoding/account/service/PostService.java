/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.service;

import com.hellokoding.account.model.Post;
import com.hellokoding.account.repository.CommentRepository;
import com.hellokoding.account.repository.PostRepository;
import com.hellokoding.account.viewModel.PostGetView;
import com.hellokoding.account.viewModel.PostView;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kklos
 */
@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    
    @Autowired
    CommentRepository commentRepository;

    public void savePostToDatabase(PostView postView) {
        Date date = new Date();
        Post post = new Post();
        post.setTitle(postView.getTitle());
        post.setContent(postView.getContent());
        post.setAddedAt(date);
        post.setIsPrivate(false);
        postRepository.save(post);
    }
    
    public PostGetView getOnePostWithComments(Long id)
    {
        Post post = new Post();
        PostGetView postToDisplay = new PostGetView();
        post = postRepository.getOne(id);
        postToDisplay.setComments(commentRepository.findByPostId(id));
        postToDisplay.setAddedAt(post.getAddedAt());
        postToDisplay.setContent(post.getContent());
        postToDisplay.setTitle(post.getTitle());
        
        
        return postToDisplay;
    }
}
