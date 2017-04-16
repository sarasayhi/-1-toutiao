package com.marissaman.service;

import com.marissaman.dao.UserDAO;
import com.marissaman.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by saras on 2017/4/16.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public User getUser(int id){
        return userDAO.selectById(id);
    }
}
