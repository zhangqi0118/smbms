package com.smbms.controller;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smbms.pojo.Role;
import com.smbms.pojo.User;
import com.smbms.service.RoleService;
import com.smbms.service.UserService;
import com.smbms.util.Constants;
import com.smbms.util.DateUtil;
import com.smbms.util.GetAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 登录
     * @param userCode
     * @param userPassword
     * @param session
     * @param map
     * @return
     */

    public @RequestMapping(value = "/login.do") String login( String userCode, String userPassword, HttpSession session, Map map){
        User user=   userService.login(userCode, userPassword);
        if(user!=null){
            session.setAttribute(Constants.USER_SESSION,user);
            return "redirect:frame";
        }else {
            map.put("error","用户名或密码错误");
            map.put("userCode",userCode);
            return "../login";
        }
    }
    public @RequestMapping(value = "/frame") String frame(  ){
       return "jsp/frame";
    }
    /**
     * 注销
     * @param session
     * @return
     */
    public @RequestMapping(value = "loginOut.do") String loginOut(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        return "redirect:login.jsp";
    }
    /**
     * 查询用户信息 分页查询 模糊查询
     * @param pn
     * @param pageSize
     * @param queryname
     * @param queryUserRole
     * @param model
     * @return
     */
    public @RequestMapping("/getUserByUserNameAndroleName") String getUserByUserNameAndroleName(@RequestParam(value="pn",defaultValue="1")Integer pn, @RequestParam(value="pageSize",defaultValue="5")Integer pageSize,  String queryname, Integer queryUserRole, Model model) throws Exception {
        PageHelper.startPage(pn, pageSize);
        List<User> user = userService.getUserByUserNameAndroleName(queryname, queryUserRole);
        PageInfo<User> pageInfo = new PageInfo<>(user);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("queryname",queryname);
        model.addAttribute("list",pageInfo.getList());
        return "jsp/userlist";
    }

    /**
     * 跳转添加用户页面
     * @return
     */
    public @RequestMapping("/toAddUser") String toAddUser(){
        return "jsp/useradd";
    }
/**
 * 添加用户
 */
public  @RequestMapping("/addUser") @ResponseBody String addUser(User user){
    return JSON.toJSONString(userService.addUser(user));
}
    /**
     * 验证userCode
     * @param userCode
     * @return
     */
    public @RequestMapping("/checkUserCode")@ResponseBody  String checkUserCode(String userCode){
        return JSON.toJSONString(userService.checkUserCode(userCode));
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public @RequestMapping("/delUserById")@ResponseBody  String delUserById(Integer id,HttpSession session){
        User user = (User)session.getAttribute(Constants.USER_SESSION);
        if(user.getId().equals(id)) {
            boolean b = userService.delUserById(user.getId());
            session.removeAttribute(Constants.USER_SESSION);
            return JSON.toJSONString(b);
        }
            return JSON.toJSONString(userService.delUserById(id));

    }

    /**
     * 跳转到修改界面
     * @return
     */
    public @RequestMapping("/toUserModify") String toUserModify(Integer id,Model model) throws ParseException {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "jsp/usermodify";
    }
public @RequestMapping("/updateUser") String updateUser(User user,@RequestParam(value ="a_idPicPath", required = false) MultipartFile pic,HttpServletRequest request) throws IOException {
    String realPath = request.getServletContext().getRealPath("/images/");
    pic.transferTo(new File(realPath+File.separator+pic.getOriginalFilename()));
    user.setIdPicPath("images/"+pic.getOriginalFilename());
    user.setModifyDate(new Date());
    userService.updateUser(user);
    return  "redirect:/getUserByUserNameAndroleName";
}
    /**
     * 添加用户 上传头像
     * @param user
     * @param pic
     * @param request
     * @return
     * @throws IOException
     */
    public  @RequestMapping("/addUsers")  String addUsers(User user,@RequestParam(value ="a_idPicPath", required = false) MultipartFile pic, HttpServletRequest request ) throws IOException {
       String realPath = request.getServletContext().getRealPath("/images/");
        pic.transferTo(new File(realPath+File.separator+pic.getOriginalFilename()));
         user.setIdPicPath("images/"+pic.getOriginalFilename());
         user.setCreationDate(new Date());
         userService.addUser(user);
        System.out.println("path"+realPath);
        return  "redirect:/getUserByUserNameAndroleName";
    }
    public @RequestMapping("/viewUser") String viewUser (Integer id,Model model){
             model.addAttribute("user",  userService.getUser_2ById(id));
      return  "jsp/userview";
    }
}

