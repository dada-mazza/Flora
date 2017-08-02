package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String service() {

        String url = "forgotPassword";
        log.info("url -> " + url);
        return url;
    }
}
