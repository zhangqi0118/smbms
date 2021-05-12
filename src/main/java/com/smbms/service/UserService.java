package com.smbms.service;

import com.smbms.pojo.Role;
import com.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User login(@Param("userCode") String userCode, @Param("upwd") String pwd);
    int updatePassWord(@Param("id") Integer id, @Param("newPwd") String newPwd);
    boolean checkPwd(@Param("id") Integer id, @Param("pwd") String pwd);
    List<User> getUserByUserNameAndroleName(@Param("userName") String userName, @Param("userRole") Integer userRole);
    boolean addUser(User user);
    boolean checkUserCode(@Param("userCode") String userCode);
    List<Role> getUserRole();
    boolean delUserById(@Param("id") Integer id);
    User getUserById(@Param("id") Integer id);
    int updateUser(User user);
    User getUser_2ById(@Param("id") Integer id);
}
