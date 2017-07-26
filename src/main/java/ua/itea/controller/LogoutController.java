package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.itea.entity.UserEntity;


@Controller
@RequestMapping("/logout")
@SessionAttributes("userEntity")
public class LogoutController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String service(ModelMap model) {

        UserEntity userEntity = (UserEntity) model.get("userEntity");

        if (userEntity != null) {
            model.clear();
        }

        String url = "/login";
        log.info("redirect : " + url);
        return url;
    }
}
