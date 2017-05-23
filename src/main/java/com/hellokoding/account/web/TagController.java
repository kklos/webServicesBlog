/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.web;

import com.hellokoding.account.model.Post;
import com.hellokoding.account.model.Tag;
import com.hellokoding.account.repository.CommentRepository;
import com.hellokoding.account.repository.TagRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kklos
 */
@Controller
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @RequestMapping(value = "/getAllTags", method = RequestMethod.GET)
    public @ResponseBody
    List<Tag> getAllPosts() {

        List<Tag> tagsFromDatabase = tagRepository.findAll();

        return tagsFromDatabase;
    }

    @RequestMapping(value = "/getTagById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Tag getTagById(@PathVariable("id") long id) {
        return tagRepository.getOne(id);
    }
}
