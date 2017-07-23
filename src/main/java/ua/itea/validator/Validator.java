package ua.itea.validator;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import ua.itea.checker.Checker;
import ua.itea.dao.UserDAO;
import ua.itea.entity.Gender;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private UserDAO userDAO = new UserDAO();

    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String yearOfBirth;
    private String monthOfBirth;
    private String dayOfBirth;
    private String gender;
    private String address;
    private String city;
    private String phoneNumber;
    private String additionalInformation;


    private List<String> emailErrorMessages;
    private List<String> passwordErrorMessages;
    private List<String> confirmPasswordErrorMessages;
    private List<String> firstNameErrorMessages;
    private List<String> lastNameErrorMessages;
    private List<String> yearOfBirthErrorMessages;
    private List<String> monthOfBirthErrorMessages;
    private List<String> dayOfBirthErrorMessages;
    private List<String> dateOfBirthErrorMessages;
    private List<String> genderErrorMessages;
    private List<String> addressErrorMessages;
    private List<String> cityErrorMessages;
    private List<String> phoneNumberErrorMessages;
    private List<String> additionalInformationErrorMessages;

    public Validator() {
    }

    public Validator(String email, String password, String confirmPassword, String firstName, String lastName, String yearOfBirth, String monthOfBirth, String dayOfBirth, String gender, String address, String city, String additionalInformation, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.additionalInformation = additionalInformation;
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }


    public List<String> getEmailErrorMessages() {
        emailErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(email)) {
            emailErrorMessages.add("Email Address can't be empty");
        }

        if (!Checker.isEmail(email)) {
            emailErrorMessages.add("Email Address is not valid");
        }

        if (userDAO.getEntityByEmail(email) != null) {
            emailErrorMessages.add("Email Address is busy");
        }

        return emailErrorMessages;
    }

    public List<String> getPasswordErrorMessages() {
        passwordErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(password)) {
            passwordErrorMessages.add("Password can't be empty");
        }

        if (password.length() < 4) {
            passwordErrorMessages.add("Password must be at least 4 characters long");
        }

        if (password.length() > 20) {
            passwordErrorMessages.add("Password must contain no more than 20 characters");
        }

        if (!Checker.hasDigit(password)) {
            passwordErrorMessages.add("Password must contain digits");
        }

        if (!Checker.hasUpperCase(password)) {
            passwordErrorMessages.add("Password must contain uppercase characters");
        }

        if (!Checker.hasLowerCase(password)) {
            passwordErrorMessages.add("Password must contain lowercase characters");
        }

        return passwordErrorMessages;
    }

    public List<String> getConfirmPasswordErrorMessages() {
        confirmPasswordErrorMessages = new ArrayList<>();

        if (!password.equals(confirmPassword)) {
            confirmPasswordErrorMessages.add("Password confirmation must match the password");
        }

        return confirmPasswordErrorMessages;
    }

    public List<String> getFirstNameErrorMessages() {
        firstNameErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(firstName)) {
            firstNameErrorMessages.add("First Name can't be empty");
        }

        if (firstName.length() < 3) {
            firstNameErrorMessages.add("First Name must be at least 3 characters long");
        }

        return firstNameErrorMessages;
    }

    public List<String> getLastNameErrorMessages() {
        lastNameErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(lastName)) {
            lastNameErrorMessages.add("Second Name can't be empty");
        }

        if (lastName.length() < 3) {
            lastNameErrorMessages.add("Second Name must be at least 3 characters long");
        }

        return lastNameErrorMessages;
    }

    public List<String> getYearOfBirthErrorMessages() {
        yearOfBirthErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(yearOfBirth)) {
            yearOfBirthErrorMessages.add("Year can't be empty");
        } else if (!Checker.isDigit(yearOfBirth)) {
            yearOfBirthErrorMessages.add("Year must be a number");
        } else {
            Integer year = Integer.parseInt(this.yearOfBirth);
            Integer currentYear = new DateTime().getYear();
            if (year < (currentYear - 100)) {
                yearOfBirthErrorMessages.add("Year can not be less than " + (currentYear - 100));
            }

            if (year >= (currentYear - 3)) {
                yearOfBirthErrorMessages.add("Year can not be more than " + +(currentYear - 3));
            }
        }

        return yearOfBirthErrorMessages;
    }

    public List<String> getMonthOfBirthErrorMessages() {
        monthOfBirthErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(monthOfBirth)) {
            monthOfBirthErrorMessages.add("Month can't be empty");
        } else if (!Checker.isDigit(monthOfBirth)) {
            monthOfBirthErrorMessages.add("Month must be a number");
        } else {
            Integer month = Integer.parseInt(this.monthOfBirth);
            if (month < 1) {
                monthOfBirthErrorMessages.add("Month can not be less than 1");
            }

            if (month > 12) {
                monthOfBirthErrorMessages.add("Month can not be more than 12");
            }
        }
        return monthOfBirthErrorMessages;
    }

    public List<String> getDayOfBirthErrorMessages() {
        dayOfBirthErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(dayOfBirth)) {
            dateOfBirthErrorMessages.add("Day can't be empty");
        } else if (!Checker.isDigit(dayOfBirth)) {
            dateOfBirthErrorMessages.add("Day must be a number");
        } else if ((yearOfBirthErrorMessages != null && yearOfBirthErrorMessages.isEmpty())
                && (monthOfBirthErrorMessages != null && monthOfBirthErrorMessages.isEmpty())) {
            Integer day = Integer.parseInt(this.dayOfBirth);
            if (day < 1) {
                dateOfBirthErrorMessages.add("Day can not be less than 1");
            }
            Integer year = Integer.parseInt(this.yearOfBirth);
            Integer month = Integer.parseInt(this.monthOfBirth);
            DateTime dateTime = new DateTime(year, month, 1, 1, 1);
            if (day > dateTime.dayOfMonth().getMaximumValue()) {
                dateOfBirthErrorMessages.add("Day can not be more than " + dateTime.dayOfMonth().getMaximumValue());
            }
        }

        return monthOfBirthErrorMessages;
    }

    public List<String> getDateOfBirthErrorMessages() {
        dateOfBirthErrorMessages = new ArrayList<>();
        dateOfBirthErrorMessages.addAll(getYearOfBirthErrorMessages());
        dateOfBirthErrorMessages.addAll(getMonthOfBirthErrorMessages());
        dateOfBirthErrorMessages.addAll(getDayOfBirthErrorMessages());
        return dateOfBirthErrorMessages;
    }

    public List<String> getGenderErrorMessages() {
        genderErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(gender)) {
            genderErrorMessages.add("Gender can't be empty");
        }

        if (!gender.equals(Gender.Male.name()) && !gender.equals(Gender.Female.name())) {
            genderErrorMessages.add("Gender must be Male or Female");
        }
        return genderErrorMessages;
    }

    public List<String> getAddressErrorMessages() {
        addressErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(address)) {
            addressErrorMessages.add("Address can't be empty");
        }

        return addressErrorMessages;
    }

    public List<String> getCityErrorMessages() {
        cityErrorMessages = new ArrayList<>();

        if (StringUtils.isBlank(city)) {
            cityErrorMessages.add("City can't be empty");
        }

        return cityErrorMessages;
    }

    public List<String> getPhoneNumberErrorMessages() {
        phoneNumberErrorMessages = new ArrayList<>();

        if (!Checker.isPhoneNumber(phoneNumber)) {
            phoneNumberErrorMessages.add("Phone Number is not valid");
        }

        return phoneNumberErrorMessages;
    }

    public List<String> getAdditionalInformationErrorMessages() {
        additionalInformationErrorMessages = new ArrayList<>();

        if (additionalInformation == null) {
            additionalInformationErrorMessages.add("Additional Information can't be null");
        }

        return additionalInformationErrorMessages;
    }

    // =================================================================================================================

    public boolean isValidEmail() {
        return getEmailErrorMessages().isEmpty();
    }

    public boolean isValid() {
        return getEmailErrorMessages().isEmpty()
                && getPasswordErrorMessages().isEmpty()
                && getConfirmPasswordErrorMessages().isEmpty()
                && getFirstNameErrorMessages().isEmpty()
                && getLastNameErrorMessages().isEmpty()
                && getDateOfBirthErrorMessages().isEmpty()
                && getGenderErrorMessages().isEmpty()
                && getAddressErrorMessages().isEmpty()
                && getCityErrorMessages().isEmpty()
                && getPhoneNumberErrorMessages().isEmpty()
                && getAdditionalInformationErrorMessages().isEmpty();
    }
}
