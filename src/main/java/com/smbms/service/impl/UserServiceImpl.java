package com.smbms.service.impl;

import com.smbms.mapper.UserMapper;
import com.smbms.pojo.Role;
import com.smbms.pojo.User;
import com.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String userCode, String pwd) {
        return userMapper.login(userCode,pwd);
    }

    @Override
    public int updatePassWord(Integer id, String newPwd) {
        return userMapper.updatePassWord(id,newPwd);
    }

    @Override
    public boolean checkPwd(Integer id,String pwd) {
        return userMapper.checkPwd(id,pwd)!=null?true:false;
    }

    @Override
    public List<User> getUserByUserNameAndroleName(String userName, Integer userRole) {
        return userMapper.getUserByUserNameAndroleName(userName,userRole);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user)>0?true:false;
    }

    @Override
    public boolean checkUserCode(String userCode) {
        return userMapper.checkUserCode(userCode)!=null?true:false;
    }

    @Override
    public List<Role> getUserRole() {
        return userMapper.getUserRole();
    }
    @Override
    public boolean delUserById(Integer id) {
        return userMapper.delUserById(id)>0?true:false;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUser_2ById(Integer id) {
        return userMapper.getUser_2ById(id);
    }
}
