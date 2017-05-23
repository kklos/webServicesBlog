/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.repository;

import com.hellokoding.account.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kklos
 */
public interface BlogRepository extends JpaRepository<Blog, Long>  {
    
}
