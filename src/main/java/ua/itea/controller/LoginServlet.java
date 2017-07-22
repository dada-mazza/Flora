package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ua.itea.dao.UserDAO;
import ua.itea.entity.User;
import ua.itea.md5.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        log.info("url : " + request.getRequestURI());
        log.info("method : " + request.getMethod());

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String redirectURL = "/logout";
            log.info("redirect : " + redirectURL);
            response.sendRedirect(redirectURL);
            return;
        }

        String email = request.getParameter("email");
        if (email != null) {
            String password = request.getParameter("password");
            String md5Password = MD5Util.md5Apache(password);
            user = new UserDAO().getEntityByEmail(email);

            if (email.equals(user.getEmail())
                    && md5Password.equals(user.getPassword())) {
                log.info("access granted for " + user.getEmail());
                session.setAttribute("user", user);
                String redirectURL = "/products";
                log.info("redirect : " + redirectURL);
                response.sendRedirect(redirectURL);
                return;
            } else {
                log.info("access denied for " + user.getEmail());
                request.setAttribute("errorMessage", "I don't now you !!! Sing Up, please");
            }
        }

        String forwardURL = "/login.jsp";
        log.info("forward : " + forwardURL);
        request.getRequestDispatcher(forwardURL).forward(request, response);
    }
}
