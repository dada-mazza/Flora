package ua.itea.controller;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.itea.dao.UserDAO;
import ua.itea.entity.UserEntity;
import ua.itea.md5.MD5Util;

@Controller
@RequestMapping("/login")
@SessionAttributes("userEntity")
public class LoginController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {

        UserEntity userEntity = (UserEntity) model.get("userEntity");

        if (userEntity != null) {
            String url = "logout";
            log.info("url -> " + url);
            return url;
        }

        String url = "login";
        log.info("url -> " + url);
        return "login";
    }


    @RequestMapping(method = RequestMethod.POST)
    private String doPost(ModelMap model,
                          @RequestParam("submit") String submit,
                          @RequestParam("inputEmailLogin") String email,
                          @RequestParam("inputPasswordLogin") String password) {
        log.info("submit : " + submit);
        if (StringUtils.equals(submit, "Sign In")) {
            String md5Password = MD5Util.md5Apache(password);
            UserEntity userEntity = new UserDAO().getEntityByEmail(email);

            if (userEntity != null
                    && email.equals(userEntity.getEmail())
                    && md5Password.equals(userEntity.getPassword())) {
                log.info("access granted for " + email);
                model.addAttribute("userEntity", userEntity);
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
