/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.service;

import com.hellokoding.account.model.Blog;
import com.hellokoding.account.model.Post;
import com.hellokoding.account.repository.BlogRepository;
import com.hellokoding.account.repository.PostRepository;
import com.hellokoding.account.viewModel.BlogGetView;
import com.hellokoding.account.viewModel.BlogView;
import com.hellokoding.account.viewModel.PostView;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kklos
 */
@Service
public class BlogService {
    
    @Autowired
    BlogRepository blogRepository;
    
    @Autowired
    PostRepository postRepository;
    
      public void saveBlogToDatabase(BlogView blogView) {
        Date date = new Date();
        Blog blog = new Blog();
        blog.setTitle(blogView.getTitle());
        blog.setDescription(blogView.getDescription());
        blog.setAddedAt(date);
        blog.setIsPrivate(false);
        blogRepository.save(blog);
    }
      
    public BlogGetView getOneBlog(Long id)
    {
        BlogGetView blogToDisplay = new BlogGetView();
        Blog blog = new Blog();
        blog = blogRepository.getOne(id);
       
        blogToDisplay.setPosts(postRepository.findByBlogId(id));
        blogToDisplay.setTitle(blog.getTitle());
        blogToDisplay.setDescription(blog.getDescription());
        blogToDisplay.setIsPrivate(blog.getIsPrivate());
        blogToDisplay.setOwner(blog.getOwner());
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");

        String dateToDisplay = formatter.format(blog.getAddedAt());
        
        blogToDisplay.setAddedAt(dateToDisplay);
        
        return blogToDisplay;
    }
}
