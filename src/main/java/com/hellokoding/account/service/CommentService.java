/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.service;

import com.hellokoding.account.model.Comment;
import com.hellokoding.account.model.Post;
import com.hellokoding.account.repository.CommentRepository;
import com.hellokoding.account.repository.PostRepository;
import com.hellokoding.account.viewModel.CommentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kklos
 */
@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public void saveCommentToDatabase(CommentView commentView) {
        Comment comment = new Comment();
        Post postFromDb = new Post();

        if (commentView.getPostId() != 0) {
            postFromDb = postRepository.getOne(commentView.getPostId());
        }

        comment.setPost(postFromDb);
        comment.setAddedBy(null);
        comment.setContent(commentView.getContent());
        comment.setIsAnnonimous(false);
        comment.setOwner(null);

        commentRepository.save(comment);

    }
}
