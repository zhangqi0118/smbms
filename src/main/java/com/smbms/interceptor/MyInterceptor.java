package com.smbms.interceptor;

import com.smbms.pojo.User;
import com.smbms.util.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    //允许访问的路径
    private static final String []IGNORE_URI={"/login",".css",".png","/js/","/calendar/"};
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag=false;
        String servletPath = httpServletRequest.getServletPath();
        for (String s : IGNORE_URI) {
            if(servletPath.contains(s)){
                flag=true;
                break;
            }
        }
        if(!flag){
            User user =(User) httpServletRequest.getSession(true).getAttribute(Constants.USER_SESSION);
            //判断用户是否登录
            if(user==null){
                httpServletRequest.setAttribute("message","请先登录再访问");
                httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest,httpServletResponse);
            }else {
                //如果用户已经登录则通过验证
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
