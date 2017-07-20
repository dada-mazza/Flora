package ua.itea.beans;

import ua.itea.dao.UserDAO;
import ua.itea.entity.User;

/**
 * Created by dada.mazza on 10.07.2017.
 */
public class IndexBean {
    private Long userId;
    private User user;

    public IndexBean() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        user = new UserDAO().getEntityById(userId);
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
