//package cn.ustb.filter;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//public class EncodingFilter implements Filter {
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        filterChain.doFilter(request, response);
//    }
//
//    public void destroy() {
//
//    }
//}
