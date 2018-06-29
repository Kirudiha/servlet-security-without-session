package com.kgfsl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.time.LocalDateTime;

@WebServlet(name = "securedServlet", urlPatterns = {"/app"})
public class MySecuredServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        Principal principal = req.getUserPrincipal();
        if (principal == null || !req.isUserInRole("employee")) {
            LoginHandlerServlet.forwardToLogin(req, resp, null);
            return;
        }
      else  if (principal == null || !req.isUserInRole("admin")) {
            LoginHandlerServlet.forwardToLogin(req, resp, null);
            return;
        }
//         if(principal != null&& req.isUserInRole("admin")){
// resp.sendRedirect("admin.jsp");
//         }
        
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("Welcome to the secured app!");
        writer.printf("<br/>User: " + req.getRemoteUser());
        writer.printf("<br/>time: " + LocalDateTime.now());
        writer.println("<br/><a href='/logout'>Logout</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}