package com.smbms.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class QJExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView=new ModelAndView("jsp/500");
        if(e instanceof RuntimeException){
            modelAndView.addObject("error","服务器繁忙,请稍后重试");
        }else if(e instanceof SQLException){
            modelAndView.addObject("error","该功能正在升级,请稍后重试");
        }else {
            modelAndView.addObject("error","服务器异常,请联系客服");
        }
        return modelAndView;
    }
}
