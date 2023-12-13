/*
 * Copyright (c) 2023. vnlemanhthanh.com
 */

package com.vnlemanhthanh.spring.jpahibernate.repository;

import com.vnlemanhthanh.spring.jpahibernate.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 *
 */
@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    /**
     * @param id
     * @return
     */
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    /**
     * @param id
     */
    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);
        Course course2 = new Course("AngularJS  in 100 Steps");
        em.persist(course2);

        em.flush();

        //em.detach(course1);
        //em.detach(course2);

        course1.setName("Web Services in 200 Steps - Updated");
        course2.setName("AngularJS  in 500 Steps - Updated");
        //em.flush();

        em.refresh(course1);
    }

}
