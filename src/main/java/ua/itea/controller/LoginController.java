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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController extends UnauthenticatedAbstractController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.POST)
    private String authentication(@RequestParam("submit") String submit,
                                  @RequestParam("inputEmailLogin") String email,
                                  @RequestParam("inputPasswordLogin") String password,
                                  ModelMap model,
                                  HttpSession session) {

        log.info("submit : " + submit);
        if (StringUtils.equals(submit, "Sign In")) {
            String md5Password = MD5Util.md5Apache(password);
            UserEntity user = new UserDAO().getUserByEmail(email);

            if (user != null
                    && email.equals(user.getEmail())
                    && md5Password.equals(user.getPassword())) {
                log.info("access granted for " + email);
                session.setAttribute("user", user);
                String url = "/main";
                log.info("url -> " + url);
                return url;
            } else {
                log.info("access denied for " + email);
                model.addAttribute("errorMessage", "Enter the correct data or Sing Up, please");
            }
        }

        String url = "login";
        log.info("url -> " + url);
        return url;
    }
}
