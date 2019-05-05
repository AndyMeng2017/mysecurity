package com.imooc.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("my filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("my filter start");
        long start = System.currentTimeMillis();
        chain.doFilter(request,response);
        System.out.println("time filter:" + (System.currentTimeMillis() - start));
        System.out.println("my filter end");
    }

    @Override
    public void destroy() {
        System.out.println("my filter destroy");
    }
}
