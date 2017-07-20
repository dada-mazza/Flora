package ua.itea.validator;

import org.apache.commons.lang3.StringUtils;
import ua.itea.Checker.Checker;
import ua.itea.dao.UserDAO;
import ua.itea.entity.Gender;

/**
 * Created by dada.mazza on 01.07.2017.
 */
public class Validator {

    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String secondName;
    private String region;
    private String gender;
    private boolean subscription;

    private String emailErrorMessage;
    private String passwordErrorMessage;
    private String firstNameErrorMessage;
    private String secondNameErrorMessage;
    private String regionErrorMessage;
    private String genderErrorMessage;

    private boolean valid;
    private boolean validWitoutEmail;

    Checker checker = new Checker();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }

    public String getEmailErrorMessage() {
        emailErrorMessage = "";

        if (StringUtils.isBlank(email)) {
            emailErrorMessage += "<li>Email Address can't be empty</li>";
        }

        if (!checker.isEmail(email)) {
            emailErrorMessage += "<li>Email Address is not valid</li>";
        }

        if (new UserDAO().getEntityByEmail(email) != null) {
            emailErrorMessage += "<li>Email Address is busy</li>";
        }

        if (!StringUtils.isBlank(emailErrorMessage)) {
            emailErrorMessage = "<ul class='error'>" + emailErrorMessage + "</ul>";
        }

        return emailErrorMessage;
    }

    public void setEmailErrorMessage(String emailErrorMessage) {
        this.emailErrorMessage = emailErrorMessage;
    }

    public String getPasswordErrorMessage() {
        passwordErrorMessage = "";

        if (StringUtils.isBlank(password)) {
            passwordErrorMessage += "<li>Password can't be empty</li>";
        }

        if (password.length() < 4) {
            passwordErrorMessage += "<li>Password must be at least 4 characters long</li>";
        }

        if (password.length() > 20) {
            passwordErrorMessage += "<li>Password must contain no more than 20 characters</li>";
        }

        if (!checker.hasDigit(password)) {
            passwordErrorMessage += "<li>Password must contain digits</li>";
        }

        if (!checker.hasUpperCase(password)) {
            passwordErrorMessage += "<li>Password must contain uppercase characters</li>";
        }

        if (!checker.hasLowerCase(password)) {
            passwordErrorMessage += "<li>Password must contain lowercase characters</li>";
        }

        if (!password.equals(confirmPassword)) {
            passwordErrorMessage += "<li>Password confirmation must match the password</li>";
        }

        if (!StringUtils.isBlank(passwordErrorMessage)) {
            passwordErrorMessage = "<ul class='error'>" + passwordErrorMessage + "</ul>";
        }
        return passwordErrorMessage;
    }

    public void setPasswordErrorMessage(String passwordErrorMessage) {
        this.passwordErrorMessage = passwordErrorMessage;
    }

    public String getFirstNameErrorMessage() {
        firstNameErrorMessage = "";

        if (StringUtils.isBlank(firstName)) {
            firstNameErrorMessage += "<li>First Name can't be empty</li>";
        }

        if (firstName.length() < 3) {
            firstNameErrorMessage += "<li>First Name must be at least 3 characters long</li>";
        }

        if (!StringUtils.isBlank(firstNameErrorMessage)) {
            firstNameErrorMessage = "<ul class='error'>" + firstNameErrorMessage + "</ul>";
        }
        return firstNameErrorMessage;
    }

    public void setFirstNameErrorMessage(String firstNameErrorMessage) {
        this.firstNameErrorMessage = firstNameErrorMessage;
    }

    public String getSecondNameErrorMessage() {
        secondNameErrorMessage = "";

        if (StringUtils.isBlank(secondName)) {
            secondNameErrorMessage += "<li>Second Name can't be empty</li>";
        }

        if (secondName.length() < 3) {
            secondNameErrorMessage += "<li>Second Name must be at least 3 characters long</li>";
        }

        if (!StringUtils.isBlank(secondNameErrorMessage)) {
            secondNameErrorMessage = "<ul class='error'>" + secondNameErrorMessage + "</ul>";
        }
        return secondNameErrorMessage;
    }

    public void setSecondNameErrorMessage(String secondNameErrorMessage) {
        this.secondNameErrorMessage = secondNameErrorMessage;
    }

    public String getRegionErrorMessage() {
        regionErrorMessage = "";

        if (StringUtils.isBlank(region)) {
            regionErrorMessage += "<li>Region can't be empty</li>";
        }

        if (!StringUtils.isBlank(regionErrorMessage)) {
            regionErrorMessage = "<ul class='error'>" + regionErrorMessage + "</ul>";
        }
        return regionErrorMessage;
    }

    public void setRegionErrorMessage(String regionErrorMessage) {
        this.regionErrorMessage = regionErrorMessage;
    }

    public String getGenderErrorMessage() {
        regionErrorMessage = "";

        if (StringUtils.isBlank(gender)) {
            regionErrorMessage += "<li>Gender can't be empty</li>";
        }

        if (!gender.equals(Gender.Male.name()) || !gender.equals(Gender.Male.name())) {
            regionErrorMessage += "<li>Invalid gender value</li>";
        }

        if (!StringUtils.isBlank(regionErrorMessage)) {
            regionErrorMessage = "<ul class='error'>" + regionErrorMessage + "</ul>";
        }
        return genderErrorMessage;
    }

    public void setGenderErrorMessage(String genderErrorMessage) {
        this.genderErrorMessage = genderErrorMessage;
    }

    public boolean getValid() {
        valid = StringUtils.isBlank(getEmailErrorMessage())
                && StringUtils.isBlank(getPasswordErrorMessage())
                && StringUtils.isBlank(getFirstNameErrorMessage())
                && StringUtils.isBlank(getSecondNameErrorMessage())
                && StringUtils.isBlank(getRegionErrorMessage())
                && StringUtils.isBlank(getGenderErrorMessage());
        return valid;
    }

    public boolean getValidWitoutEmail() {
        validWitoutEmail = StringUtils.isBlank(getPasswordErrorMessage())
                && StringUtils.isBlank(getFirstNameErrorMessage())
                && StringUtils.isBlank(getSecondNameErrorMessage())
                && StringUtils.isBlank(getRegionErrorMessage())
                && StringUtils.isBlank(getGenderErrorMessage());
        return validWitoutEmail;
    }
}
