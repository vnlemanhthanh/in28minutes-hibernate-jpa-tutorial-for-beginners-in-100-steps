/*
 * Copyright (c) 2023. vnlemanhthanh.com
 */

package com.vnleamnhthanh.database.databasedemo.jdbc;

import com.vnleamnhthanh.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<Person>(Person.class));
    }
}