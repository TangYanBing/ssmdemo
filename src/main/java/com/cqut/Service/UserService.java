package com.cqut.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.dao.EntityDao;
import com.cqut.pojo.User;


  
@Service("userService")  
public class UserService implements IUserService {  
    @Resource(name = "entityDao")
    private EntityDao dao;
    
    @Override  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
    	return dao.getByID("1", User.class);
//        return this.userMapping.selectByPrimaryKey(userId);  
    }  
}