package by.it_academy.jd2.hw.example.messenger.controller;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Doesn't allow user to get to message and chats pages without logging or signing in
 * @author Maksim Perekladov
 * @version 2.0
 */
@Component
public class SecurityFilterSpring implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if((session!=null) && (session.getAttribute("user") != null)) {
            chain.doFilter(request, response);
        } else {
            //redirect to sign in page
            res.sendRedirect(contextPath + "/signIn");
        }
    }

    @Override
    public void destroy() {

    }
}