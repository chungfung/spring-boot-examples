package com.chungfung.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/7 10:58
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView errorHandler(Exception ex,HttpServletRequest req) {
        ModelAndView modelAndView = null;
        if(req.getHeader("X-Requested-With")!=null
                && "XMLHttpRequest".equals(req.getHeader("X-Requested-With").toString())) {
            modelAndView = new ModelAndView(new MappingJackson2JsonView());
            modelAndView.addObject("code", 500);
            modelAndView.addObject("msg", ex.getMessage());
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("error/index");
            modelAndView.addObject("msg", ex.getMessage());
            return modelAndView;
        }
    }
}
