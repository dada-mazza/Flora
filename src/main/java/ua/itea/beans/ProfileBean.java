package ua.itea.beans;

import ua.itea.dao.UserDAO;
import ua.itea.entity.User;
import ua.itea.md5.MD5Util;

/**
 * Created by dada.mazza on 10.07.2017.
 */
public class ProfileBean {

    private Boolean update;
    private String password;
    private String md5Password;
    private User user;

    public ProfileBean() {
    }

    public Boolean getUpdate() {
        update = new UserDAO().update(user);
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
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
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
