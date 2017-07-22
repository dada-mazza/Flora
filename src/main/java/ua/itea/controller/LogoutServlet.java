package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ua.itea.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        log.info("url : " + request.getRequestURI());
        log.info("method : " + request.getMethod());

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            String redirectURL = "/login";
            log.info("redirect : " + redirectURL);
            response.sendRedirect(redirectURL);
            return;
        }

        String signOutAction = request.getParameter("SignOutAction");
        if (signOutAction != null) {
            log.info("SignOutAction : " + signOutAction);
            String redirectURL;
            switch (signOutAction) {
                case ("yes"):
                    session.invalidate();
                    request.getSession();
                    redirectURL = "/login";
                    log.info("redirect : " + redirectURL);
                    response.sendRedirect(redirectURL);
                    return;
                case ("no"):
                    redirectURL = "/";
                    log.info("redirect : " + redirectURL);
                    response.sendRedirect(redirectURL);
                    return;
            }
        }

        String forwardURL = "/logout.jsp";
        log.info("forward : " + forwardURL);
        request.getRequestDispatcher(forwardURL).forward(request, response);
    }
}
