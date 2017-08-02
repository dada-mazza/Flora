package ua.itea.controller;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.itea.dao.jpa.UserDAO;
import ua.itea.entity.UserEntity;
import ua.itea.entity.enumeratiom.Gender;
import ua.itea.entity.enumeratiom.Role;
import ua.itea.validator.Validator;

import javax.servlet.http.HttpSession;
import java.sql.Date;


@Controller
@RequestMapping("/personalData")
public class PersonalDataController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String service(HttpSession session) {

        UserEntity user = (UserEntity) session.getAttribute("user");
        String url;
        if (user == null) {
            url = "login";
        } else {
            url = "personalData";
        }

        log.info("url -> " + url);
        return url;
    }

    @RequestMapping(method = RequestMethod.POST)
    private String editPersonalData(@RequestParam("submit") String submit,
                                    @RequestParam("inputFirstName") String firstName,
                                    @RequestParam("inputLastName") String lastName,
                                    @RequestParam("selectYear") String yearOfBirth,
                                    @RequestParam("selectMonth") String monthOfBirth,
                                    @RequestParam("selectDay") String dayOfBirth,
                                    @RequestParam("selectGender") String gender,
                                    @RequestParam("inputAddress") String address,
                                    @RequestParam("inputCity") String city,
                                    @RequestParam("inputPhoneNumber") String phoneNumber,
                                    @RequestParam("textareaAdditionalInformation") String additionalInformation,
                                    ModelMap model,
                                    HttpSession session
    ) {
        log.info("submit : " + submit);
        if (StringUtils.equals(submit, "Edit")) {
            Validator validator = new Validator();
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

            UserEntity user = (UserEntity) session.getAttribute("user");

            if (validator.isValidPersonalData()) {
                user.setFirstName(firstName);
                user.setLastName(lastName);
                DateTime dateTime = new DateTime(Integer.parseInt(yearOfBirth), Integer.parseInt(monthOfBirth), Integer.parseInt(dayOfBirth), 0, 0);
                user.setDateOfBirth(new Date(dateTime.getMillis()));
                user.setGender(Gender.valueOf(gender));
                user.setAddress(address);
                user.setCity(city);
                user.setPhoneNumber(phoneNumber);
                user.setAdditionalInformation(additionalInformation);
                user.setRole(Role.USER);

                user = new UserDAO().update(user);

                if (user != null) {
                    log.info("Personal data has bean changed: " + user);
                    session.setAttribute("user", user);
                    String url = "profile";
                    log.info("url -> " + url);
                    return url;
                } else {
                    log.info("editing error for " + user);
                    model.addAttribute("errorMessage", "Editing error. Try later!");
                }

            } else {
                log.info("Personal data has not bean changed : " + user);
                model.addAttribute("validator", validator);
                String url = "personalData";
                log.info("url -> " + url);
                return url;
            }
        }

        String url = "profile";
        log.info("url -> " + url);
        return url;
    }

}