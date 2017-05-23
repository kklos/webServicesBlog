/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.web;

import com.hellokoding.account.model.Comment;
import com.hellokoding.account.model.Post;
import com.hellokoding.account.model.Tag;
import com.hellokoding.account.repository.CommentRepository;
import com.hellokoding.account.repository.PostRepository;
import com.hellokoding.account.repository.TagRepository;
import com.hellokoding.account.service.PostService;
import com.hellokoding.account.viewModel.PostGetView;
import com.hellokoding.account.viewModel.PostView;
import java.util.Arrays;
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
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PostService postService;

    @RequestMapping(value = "/getAllPosts", method = RequestMethod.GET)
    public @ResponseBody
    List<Post> getAllPosts() {


        List<Post> postsFromDatabase = postRepository.findByBlogId(1L);

        return postsFromDatabase;
    }

    @RequestMapping(value = "/getComments", method = RequestMethod.GET)
    public @ResponseBody
    List<Comment> getAllComments() {

        List<Comment> postsFromDatabase = commentRepository.findByPostId(1L);

        return postsFromDatabase;
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<PostView> addPost(@RequestBody PostView post) {

        if (post == null) {
            return new ResponseEntity<PostView>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        postService.savePostToDatabase(post);

        return new ResponseEntity<PostView>(post, HttpStatus.OK);
    }

    @RequestMapping(value = "/getPostById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    PostGetView getPostById(@PathVariable("id") long id) {
        return postService.getOnePostWithComments(id);
    }

    @RequestMapping(value = "/getTagById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Tag getTagById(@PathVariable("id") long id) {
        return tagRepository.getOne(id);
    }

    @RequestMapping(value = "/itemsForOneCategory/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<Tag> listOfItemsForOneCategory(@PathVariable("id") long id) {

        List<Tag> itemsFromDatabase = Arrays.asList(null);

        return itemsFromDatabase;
    }
}
