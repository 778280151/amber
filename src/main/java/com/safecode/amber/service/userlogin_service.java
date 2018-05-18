package com.safecode.amber.service;

import com.safecode.amber.bean.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userlogin_service {
    @Autowired
    private com.safecode.amber.dao.usersMapper usersMapper;
    public int userregistered(users u) {
        return usersMapper.insert(u);
    }

}
