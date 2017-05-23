/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author klaudia
 */
@Entity
@Table(name = "Blogs")
@Proxy(lazy = false)


public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addedby_id")
    private User owner;
    private Date addedAt;
    private Boolean isPrivate;

    @JsonIgnore
    @OneToMany(targetEntity = Post.class, mappedBy = "blog", fetch = FetchType.EAGER)
    private List<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return User.getUserWithoutLoop(this.owner);
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        
        this.posts = posts;
    }
    
    public static Blog getBlogWithoutLoop(Blog blog)
    {
        Blog blogWithoutLoop = new Blog();
    
        if(blog != null)
        {
        blogWithoutLoop.setId(blog.getId());
        blogWithoutLoop.setIsPrivate(blog.getIsPrivate());
        blogWithoutLoop.setAddedAt(blog.getAddedAt());
        blogWithoutLoop.setDescription(blog.getDescription());
        blogWithoutLoop.setOwner(blog.getOwner());
        blogWithoutLoop.setTitle(blog.getTitle());
        }
        return blogWithoutLoop;
    }
}
