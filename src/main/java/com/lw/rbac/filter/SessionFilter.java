package com.lw.rbac.filter;

import com.lw.rbac.domain.Menu;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName SessionFilter
 * @Descriptio TODO 拦截所有页面，检查页面所需要的资源是否存在
 * @Author liwei
 * @Date 2019/5/22 14:45
 * @Version 1.0
 */
@WebFilter(urlPatterns = {"/index"},filterName = "sessionFilter")
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        List<Menu> menuList = (List<Menu>) request.getSession().getAttribute("menuList");
        if(menuList == null){
//            menuList =
        }


    }

}
