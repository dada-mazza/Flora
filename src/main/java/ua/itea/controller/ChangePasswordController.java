package ua.itea.controller;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.itea.dao.jpa.UserDAO;
import ua.itea.entity.UserEntity;
import ua.itea.md5.MD5Util;
import ua.itea.validator.Validator;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/changePassword")
public class ChangePasswordController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String service(HttpSession session) {

        UserEntity user = (UserEntity) session.getAttribute("user");
        String url;
        if (user == null) {
            url = "login";
        } else {
            url = "changePassword";
        }
        log.info("url -> " + url);
        return url;
    }

    @RequestMapping(method = RequestMethod.POST)
    private String changePassword(@RequestParam("submit") String submit,
                                  @RequestParam("inputPassword") String password,
                                  @RequestParam("inputConfirmPassword") String confirmPassword,
                                  ModelMap model,
                                  HttpSession session
    ) {
        log.info("submit : " + submit);
        if (StringUtils.equals(submit, "Change Password")) {
            Validator validator = new Validator();
            validator.setPassword(password);
            validator.setConfirmPassword(confirmPassword);

            UserEntity user = (UserEntity) session.getAttribute("user");

            if (validator.isValidPassword()) {
                user.setPassword(MD5Util.md5Apache(password));
                user = new UserDAO().update(user);

                if (user != null) {
                    log.info("Password has bean changed: " + user);
                    session.setAttribute("user", user);
                    String url = "/profile";
                    log.info("url -> " + url);
                    return url;
                } else {
                    log.info("editing error for " + user);
                    model.addAttribute("errorMessage", "Error changing password. Try later!");
                }

            } else {
                log.info("Password has not bean changed : " + user);
                model.addAttribute("validator", validator);
                String url = "changePassword";
                log.info("url -> " + url);
                return url;
            }
        }

        String url = "profile";
        log.info("url -> " + url);
        return url;
    }
}
