package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import ua.itea.dao.UserDAO;
import ua.itea.entity.Gender;
import ua.itea.entity.User;
import ua.itea.md5.MD5Util;
import ua.itea.validator.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String redirectURL = "/profile";
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
        if (submit != null && submit.equals("Sign Up Email")) {
            String email = request.getParameter("inputEmailRegistration");
            Validator validator = new Validator();
            validator.setEmail(email);
            if (validator.isValidEmail()) {
                log.info("Email is valid : " + email);
                request.setAttribute("email", email);
                String forwardURL = "/registration.jsp";
                log.info("forward : " + forwardURL);
                request.getRequestDispatcher(forwardURL).forward(request, response);
                return;
            } else {
                log.info("Email is not valid : " + email);
                request.setAttribute("validator", validator);
                String forwardURL = "/login.jsp";
                log.info("forward : " + forwardURL);
                request.getRequestDispatcher(forwardURL).forward(request, response);
                return;
            }
        } else if (submit != null && submit.equals("Register")) {
            String email = request.getParameter("inputEmail");
            String password = request.getParameter("inputPassword");
            String confirmPassword = request.getParameter("inputConfirmPassword");
            String firstName = request.getParameter("inputFirstName");
            String lastName = request.getParameter("inputLastName");
            String yearOfBirth = request.getParameter("selectYear");
            String monthOfBirth = request.getParameter("selectMonth");
            String dayOfBirth = request.getParameter("selectDay");
            String gender = request.getParameter("selectGender");
            String address = request.getParameter("inputAddress");
            String city = request.getParameter("inputCity");
            String phoneNumber = request.getParameter("inputPhone");
            String additionalInformation = request.getParameter("textareaAdditionalInformation");

            Validator validator = new Validator();
            validator.setEmail(email);
            validator.setPassword(password);
            validator.setConfirmPassword(confirmPassword);
            validator.setFirstName(firstName);
            validator.setLastName(lastName);
            validator.setYearOfBirth(yearOfBirth);
            validator.setMonthOfBirth(monthOfBirth);
            validator.setDayOfBirth(dayOfBirth);
            validator.setGender(gender);
            validator.setAddress(address);
            validator.setCity(city);
            validator.setPhoneNumber(phoneNumber);
            validator.setAdditionalInformation(additionalInformation);

            if (validator.isValid()) {
                User user = new User();
                user.setEmail(email);
                user.setPassword(MD5Util.md5Apache(password));
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setDateOfBirth(new DateTime(
                        Integer.parseInt(yearOfBirth),
                        Integer.parseInt(monthOfBirth),
                        Integer.parseInt(dayOfBirth),
                        0, 0));
                user.setGender(Gender.valueOf(gender));
                user.setAddress(address);
                user.setCity(city);
                user.setPhoneNumber(phoneNumber);
                user.setAdditionalInformation(additionalInformation);

                user.setId(new UserDAO().create(user));

                if (user.getId() != null) {
                    log.info("User has bean registered : " + email);
                    session.setAttribute("user", user);
                    String redirectURL = "/";
                    log.info("redirect : " + redirectURL);
                    response.sendRedirect(redirectURL);
                    return;
                } else {
                    log.info("registration error for " + email);
                    request.setAttribute("errorMessage", "Registration error. Try later!");
                }

            } else {
                log.info("User has not bean registered : " + email);
                request.setAttribute("validator", validator);
                String forwardURL = "/registration.jsp";
                log.info("forward : " + forwardURL);
                request.getRequestDispatcher(forwardURL).forward(request, response);
                return;
            }
        }

        String forwardURL = "/login.jsp";
        log.info("forward : " + forwardURL);
        request.getRequestDispatcher(forwardURL).forward(request, response);
        return;
    }
}
