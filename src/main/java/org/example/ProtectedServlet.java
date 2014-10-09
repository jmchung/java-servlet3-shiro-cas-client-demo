package org.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/protected", name = "protectedServlet")
public class ProtectedServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Subject subject = SecurityUtils.getSubject();

        res.getWriter().println("principal: " + subject.getPrincipal());
        res.getWriter().println("isAuthenticated: " + subject.isAuthenticated());
        res.getWriter().println("ROLE_USER: " + subject.hasRole("ROLE_USER"));
    }
}
