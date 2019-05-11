package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List getUserDetails() {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(UserDetails.class);
        return criteria.list();
    }

    @Transactional
    public long insert(UserDetails user) {
        entityManager.persist(user);
        return user.getId();
    }

    public UserDetails find(int id) {
        return entityManager.find(UserDetails.class, id);
    }

}

