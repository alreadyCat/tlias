package com.tlias.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("Filter初始化");
    javax.servlet.Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    System.out.println("请求被Filter拦截");
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    System.out.println("Filter即将被销毁");

    javax.servlet.Filter.super.destroy();
  }
}
