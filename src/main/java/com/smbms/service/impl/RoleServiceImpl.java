package com.smbms.service.impl;

import com.smbms.mapper.RoleMapper;
import com.smbms.pojo.Role;
import com.smbms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> getUserRole() {
        return roleMapper.getUserRole();
    }
}
