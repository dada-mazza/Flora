package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ua.itea.dao.UserDAO;
import ua.itea.entity.UserEntity;
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
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");

        if (userEntity != null) {
            String redirectURL = "/logout";
            log.info("redirect : " + redirectURL);
            response.sendRedirect(redirectURL);
            return;
        }

        if (request.getMethod().equals("GET")) {
            get(request, response);
        } else if (request.getMethod().equals("POST")) {
            post(request, response);
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forwardURL = "/login.jsp";
        log.info("forward : " + forwardURL);
        request.getRequestDispatcher(forwardURL).forward(request, response);
        return;
    }

    private void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String submit = request.getParameter("submit");
        log.info("submit : " + submit);
        if (submit != null && submit.equals("Sign In")) {
            String email = request.getParameter("inputEmailLogin");
            String password = request.getParameter("inputPasswordLogin");
            String md5Password = MD5Util.md5Apache(password);
            UserEntity userEntity = new UserDAO().getEntityByEmail(email);

            if (userEntity != null
                    && email.equals(userEntity.getEmail())
                    && md5Password.equals(userEntity.getPassword())) {
                log.info("access granted for " + email);
                session.setAttribute("user", userEntity);
                String redirectURL = "/";
                log.info("redirect : " + redirectURL);
                response.sendRedirect(redirectURL);
                return;
            } else {
                log.info("access denied for " + email);
                request.setAttribute("errorMessage", "Enter the correct data or Sing Up, please");
            }
        }

        String forwardURL = "/login.jsp";
        log.info("forward : " + forwardURL);
        request.getRequestDispatcher(forwardURL).forward(request, response);
        return;
    }
}
