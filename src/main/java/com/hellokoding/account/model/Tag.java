/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author klaudia
 */
@Entity
@Table(name = "Tag")
@Proxy(lazy = false)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private List<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        List<Post> postWithoutLoop = new ArrayList<Post>();
        for (int i = 0; i < this.posts.size(); i++) {
            postWithoutLoop.add(Post.getPostWithoutLoop(posts.get(i)));
        }
        this.posts = posts;
    }

    public static Tag getTagWithoutLoop(Tag tag) {
        Tag tagWithoutLoop = new Tag();
        tagWithoutLoop.setId(tag.getId());
        tagWithoutLoop.setName(tag.getName());
        return tagWithoutLoop;
    }
}
