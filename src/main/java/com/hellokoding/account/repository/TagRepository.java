/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.repository;

import com.hellokoding.account.model.Tag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kklos
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAll();

    Tag findOne(Long id);
}
