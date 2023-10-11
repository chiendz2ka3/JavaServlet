package Fillter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//@WebFilter(urlPatterns = {"/UploadFile-servlet/*"})
public class Auth implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
//            HttpServletRequest request = (HttpServletRequest)servletRequest;
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            HttpSession Session = request.getSession();
//            String UserName = (String)Session.getAttribute("username");
//            System.out.println("------da log duoc vao ham"+ UserName);
//            if (UserName==null){
//                response.sendRedirect("Login-servlet");
//            }else {
//                System.out.println("da log duoc UploadFile-servlet");
//                response.sendRedirect("UploadFile-servlet");
//            }
//            filterChain.doFilter(request,response);
        }catch (Exception c){

        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
