/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author klaudia
 */
@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private Boolean isAnnonimous;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addedby_id")
    private User addedBy;
    private String owner;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsAnnonimous() {
        return isAnnonimous;
    }

    public void setIsAnnonimous(Boolean isAnnonimous) {
        this.isAnnonimous = isAnnonimous;
    }

    public User getAddedBy() {
        return User.getUserWithoutLoop(this.addedBy);
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Post getPost() {
        return Post.getPostWithoutLoop(this.post);
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public static Comment getCommentWithoutLoop(Comment comment) {
        Comment commentWithoutLoop = new Comment();
        if (comment != null) {
            commentWithoutLoop.setId(comment.getId());
            commentWithoutLoop.setIsAnnonimous(comment.getIsAnnonimous());
            commentWithoutLoop.setAddedBy(comment.getAddedBy());
            commentWithoutLoop.setContent(comment.getContent());
            commentWithoutLoop.setOwner(comment.getOwner());
            //commentWithoutLoop.setPost(comment.getPost());
        }

        return commentWithoutLoop;
    }
    

}
