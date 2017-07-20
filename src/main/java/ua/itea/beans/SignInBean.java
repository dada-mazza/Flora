package ua.itea.beans;

import ua.itea.dao.UserDAO;
import ua.itea.entity.User;
import ua.itea.md5.MD5Util;

public class SignInBean {

    private String email;
    private String password;
    private String md5Password;
    private User user;

    public SignInBean() {
    }

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

    public String getMd5Password() {
        md5Password = MD5Util.md5Apache(password);
        return md5Password;
    }

    public void setMd5Password(String md5Password) {
        this.md5Password = md5Password;
    }

    public User getUser() {
        user = new UserDAO().getEntityByEmail(email);
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
