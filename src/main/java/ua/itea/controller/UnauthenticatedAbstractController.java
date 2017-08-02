package ua.itea.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.itea.entity.UserEntity;

import javax.servlet.http.HttpSession;

public abstract class UnauthenticatedAbstractController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String service(HttpSession session) {

        UserEntity user = (UserEntity) session.getAttribute("user");
        String url;
        if (user != null) {
            url = "main";
        } else {
            url = "login";
        }
        log.info("url -> " + url);
        return url;
    }

}
