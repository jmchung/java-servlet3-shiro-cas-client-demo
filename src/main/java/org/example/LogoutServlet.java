package org.example;

import org.apache.shiro.SecurityUtils;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/logout", name = "logoutServlet")
public class LogoutServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        SecurityUtils.getSubject().logout();
        ((HttpServletResponse) res).sendRedirect("https://jasig.example.com:8443/cas/logout?service=http://localhost:8080/java-servlet3-shiro-cas-client-demo");
    }
}
