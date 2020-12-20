/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.mongodb.dao;


import com.packt.springsecurity.mongodb.documententity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author anjana.m
 */
public class UsersDAOImpl implements UsersDAO{
@Autowired
        private MongoTemplate mongotemplate;
        private MongoOperations mongoOperation = (MongoOperations)mongotemplate;

      @Override

        public Users findByUserName(String userName) {
         Query searchUserQuery = new Query(Criteria.where("username").is("userName"));	
         Users savedUser = mongoOperation.findOne(searchUserQuery, Users.class);
	System.out.println("2. find - savedUser : " + savedUser);
        return savedUser;
	}
}
