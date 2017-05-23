/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.web;

import com.hellokoding.account.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author klaudia
 */
@Controller
public class ViewController {

    @Autowired
    SecurityService secService;
    
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String singlePage() {
        return "singlePost.html";
    }
    
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public String singleBlog() {
        return "index.html";
    }

    @RequestMapping(value = "/addNewPost", method = RequestMethod.GET)
    public String addNewPost() {
        return "addNewPost.html";
    }
    
    @RequestMapping(value = "/addNewBlog", method = RequestMethod.GET)
    public String addNewBlog() {
        return "addNewBlog.html";
    }
    
    @RequestMapping(value = "/panelAdmin", method = RequestMethod.GET)
    public String getPanelAdmin() {
        return "panelAdmin.html";
    }
}
