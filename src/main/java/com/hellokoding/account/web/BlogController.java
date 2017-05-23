/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.web;

import com.hellokoding.account.model.Blog;
import com.hellokoding.account.model.Post;
import com.hellokoding.account.repository.BlogRepository;
import com.hellokoding.account.service.BlogService;
import com.hellokoding.account.viewModel.BlogGetView;
import com.hellokoding.account.viewModel.BlogView;
import com.hellokoding.account.viewModel.PostView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kklos
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    
    @Autowired 
    BlogRepository blogRepository;
    
    @Autowired 
    BlogService blogService;
    
    @RequestMapping(value = "/getAllBlogs", method = RequestMethod.GET)
    public @ResponseBody
    List<Blog> getAllPosts() {

        List<Blog> blogsFromDatabase = blogRepository.findAll();

        return blogsFromDatabase;
    }
    
     @RequestMapping(value = "/addBlog", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<BlogView> addPost(@RequestBody BlogView blog) {

        if (blog == null) {
            return new ResponseEntity<BlogView>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        blogService.saveBlogToDatabase(blog);

        return new ResponseEntity<BlogView>(blog, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getBlogById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    BlogGetView getPostById(@PathVariable("id") long id) {
        return blogService.getOneBlog(id);
    }

}
