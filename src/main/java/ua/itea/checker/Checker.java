package ua.itea.checker;

/**
 * Created by dada.mazza on 10.07.2017.
 */
public class Checker {

    // це email
    public static boolean isEmail(String text) {
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return text.matches(EMAIL_REGEX);
    }

    // це телефонний номер
    public static boolean isPhoneNumber(String phoneNumber) {
        String str = phoneNumber.replaceAll("[-+)(]", "");
        if (str.matches("^(\\d+)$")) {
            if (str.length() < 10) {
                return false;
            }
            if (str.length() > 12) {
                return false;
            }
            if (str.length() == 11) {
                return false;
            }
        }
        if (str.matches("^(\\d+)$") && str.charAt(0) != '3' && str.length() == 12) {
            return false;
        }
        if (phoneNumber.matches(("^(\\+)?\\d+?\\-?\\d+\\-?\\d+$"))
                || phoneNumber.matches("^(\\+\\d+)?(\\(\\d{3}\\))\\d{7}$")
                || phoneNumber.matches("^(\\+\\d+)?(\\(\\d{3}\\))(\\(\\d{3}\\))?\\-?\\d$")
                || phoneNumber.matches("^(\\+\\-?(\\d){12})$|^(\\d){10}$")) {
            return true;
        }
        return false;
    }

    // це число
    public static boolean isDigit(String text) {
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // має число
    public static boolean hasDigit(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // має символ верхнього регістру
    public static boolean hasUpperCase(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    // має символ нижнього регістру
    public static boolean hasLowerCase(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

}
