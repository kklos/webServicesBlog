/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author klaudia
 */
@Entity
@Table(name = "Posts")
@Proxy(lazy = false)

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addedby_id")
    private User addedBy;
    private Date addedAt;
    private Boolean isPrivate;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @JsonIgnore
    @OneToMany(targetEntity = Comment.class, mappedBy = "post", fetch = FetchType.EAGER)
    private List<Comment> comments;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAddedBy() {
        return User.getUserWithoutLoop(this.addedBy);
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> items) {
        this.comments = items;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Blog getBlog() {
        return Blog.getBlogWithoutLoop(this.blog);
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    
    public static Post getPostWithoutLoop(Post post) {
        Post postWithoutLoop = new Post();
        if (post != null) {
            postWithoutLoop.setId(post.getId());
            postWithoutLoop.setAddedAt(post.getAddedAt());
            postWithoutLoop.setAddedBy(post.getAddedBy());
            postWithoutLoop.setIsPrivate(post.getIsPrivate());
            //postWithoutLoop.setBlog(post.getBlog());
            //postWithoutLoop.setTags(post.getTags());
            postWithoutLoop.setTitle(post.getTitle());
            //postWithoutLoop.setComments(post.getComments());
        }
        return postWithoutLoop;
    }
    
    public static Post getPostWithoutLoopComment(Post post) {
        Post postWithoutLoop = new Post();
        if (post != null) {
            postWithoutLoop.setId(post.getId());
            postWithoutLoop.setAddedAt(post.getAddedAt());
            postWithoutLoop.setAddedBy(post.getAddedBy());
            postWithoutLoop.setIsPrivate(post.getIsPrivate());
            //postWithoutLoop.setBlog(post.getBlog());
            //postWithoutLoop.setTags(post.getTags());
            postWithoutLoop.setTitle(post.getTitle());
            //postWithoutLoop.setComments(post.getComments());
        }
        return postWithoutLoop;
    }
}
