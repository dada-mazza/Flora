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
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.itea.dao.UserDAO;
import ua.itea.entity.UserEntity;
import ua.itea.entity.enumeratiom.Gender;
import ua.itea.entity.enumeratiom.Role;
import ua.itea.md5.MD5Util;
import ua.itea.validator.Validator;

@Controller
@RequestMapping("/registration")
@SessionAttributes("userEntity")
public class RegistrationController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {

        UserEntity userEntity = (UserEntity) model.get("userEntity");
        String url;

        if (userEntity != null) {
            url = "profile";
        } else {
            url = "login";
        }

        log.info("url -> " + url);
        return url;
    }


    @RequestMapping(value = "/email",
            method = RequestMethod.POST)
    private String registrationEmail(ModelMap model,
                                     @RequestParam("submit") String submit,
                                     @RequestParam("inputEmailRegistration") String email
    ) {
        log.info("submit : " + submit);
        if (StringUtils.equals(submit, "Sign Up Email")) {
            Validator validator = new Validator();
            validator.setEmail(email);
            if (validator.isValidEmail()) {
                log.info("Email is valid : " + email);
                model.addAttribute("email", email);
                String url = "/registration";
                log.info("url -> " + url);
                return url;
            } else {
                log.info("Email is not valid : " + email);
                model.addAttribute("validator", validator);
            }
        }
        String url = "/login";
        log.info("url -> " + url);
        return url;
    }


    @RequestMapping(method = RequestMethod.POST)
    private String registrationUser(ModelMap model,
                                    @RequestParam("submit") String submit,
                                    @RequestParam("inputEmail") String email,
                                    @RequestParam("inputPassword") String password,
                                    @RequestParam("inputConfirmPassword") String confirmPassword,
                                    @RequestParam("inputFirstName") String firstName,
                                    @RequestParam("inputLastName") String lastName,
                                    @RequestParam("selectYear") String yearOfBirth,
                                    @RequestParam("selectMonth") String monthOfBirth,
                                    @RequestParam("selectDay") String dayOfBirth,
                                    @RequestParam("selectGender") String gender,
                                    @RequestParam("inputAddress") String address,
                                    @RequestParam("inputCity") String city,
                                    @RequestParam("inputPhoneNumber") String phoneNumber,
                                    @RequestParam("textareaAdditionalInformation") String additionalInformation
    ) {

        if (StringUtils.equals(submit, "Register")) {
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
                UserEntity userEntity = new UserEntity();
                userEntity.setEmail(email);
                userEntity.setPassword(MD5Util.md5Apache(password));
                userEntity.setFirstName(firstName);
                userEntity.setLastName(lastName);
                userEntity.setDateOfBirth(new DateTime(
                        Integer.parseInt(yearOfBirth),
                        Integer.parseInt(monthOfBirth),
                        Integer.parseInt(dayOfBirth),
                        0, 0));
                userEntity.setGender(Gender.valueOf(gender));
                userEntity.setAddress(address);
                userEntity.setCity(city);
                userEntity.setPhoneNumber(phoneNumber);
                userEntity.setAdditionalInformation(additionalInformation);
                userEntity.setRole(Role.USER);

                userEntity.setId(new UserDAO().create(userEntity));

                if (userEntity.getId() != null) {
                    log.info("UserEntity has bean registered : " + email);
                    model.addAttribute("user", userEntity);
                    String url = "/";
                    log.info("url -> " + url);
                    return url;
                } else {
                    log.info("registration error for " + email);
                    model.addAttribute("errorMessage", "Registration error. Try later!");
                }

            } else {
                log.info("UserEntity has not bean registered : " + email);
                model.addAttribute("validator", validator);
                String url = "/registration";
                log.info("url -> " + url);
                return url;
            }
        }

        String url = "/login.jsp";
        log.info("url -> " + url);
        return url;
    }
}
