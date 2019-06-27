package com.chungfung.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/6/18 17:38
 * @Version 1.0
 */
@WebFilter(filterName="FirstFilter",urlPatterns="/first")
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行filter前操作！");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("执行filter后操作！");
    }

    @Override
    public void destroy() {

    }
}
