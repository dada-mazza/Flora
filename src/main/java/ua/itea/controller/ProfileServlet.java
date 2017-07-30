package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ua.itea.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        log.info("url : " + request.getRequestURI());
        log.info("method : " + request.getMethod());

        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");

        if (userEntity == null) {
            String redirectURL = "/registration";
            log.info("redirect : " + redirectURL);
            response.sendRedirect(redirectURL);
            return;
        }

        String action = request.getParameter("profileAction");
/*
        if (StringUtils.equals(action, "edit")) {
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            String firstName = request.getParameter("firstName");
            String secondName = request.getParameter("secondName");
            String region = request.getParameter("region");
            String gender = request.getParameter("gender");
            Boolean subscription = Boolean.getBoolean(request.getParameter("subscription"));

            Validator validator = new Validator();
            validator.setPassword(password);
            validator.setConfirmPassword(confirmPassword);
            validator.setFirstName(firstName);
            validator.setLastName(secondName);
            validator.setRegion(region);
            validator.setGender(gender);
            validator.setSubscription(subscription);

            if (validator.getValidWitoutEmail()) {
                userEntity.setPassword(MD5Util.md5Apache(password));
                userEntity.setFirstName(firstName);
                userEntity.setLastName(secondName);
                userEntity.setRegion(region);
                userEntity.setGender(Gender.valueOf(gender));
                userEntity.setSubscription(subscription);

                if (new UserDAO().update(userEntity)) {
                    log.info("Updated for " + userEntity.getEmail());
                    String redirectURL = "/products";
                    log.info("redirect : " + redirectURL);
                    response.sendRedirect(redirectURL);
                    return;
                } else {
                    log.info("update error for " + userEntity.getEmail());
                    request.setAttribute("errorMessage", "Update error. Try later!");
                }
            } else {
                request.setAttribute("validator", validator);
            }
        }

        */
        String forwardURL = "/profile.jsp";
        log.info("forward : " + forwardURL);
        request.getRequestDispatcher(forwardURL).forward(request, response);
    }
}
