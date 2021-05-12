package com.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.smbms.pojo.Role;
import com.smbms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
RoleService roleService;
    public @RequestMapping("/getRole") String getRole(Model model ,Integer queryUserRole){
        List<Role> roleList = roleService.getUserRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("queryUserRole",queryUserRole);
        return "jsp/userlist";
    }
    /**
     * 动态加载 roleName
     * @return
     */
    public  @RequestMapping("/getRoleName")  @ResponseBody   String getRoleName(){
        return JSON.toJSONString(roleService.getUserRole());
    }
}
