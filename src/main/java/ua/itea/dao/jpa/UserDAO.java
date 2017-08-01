package ua.itea.dao.jpa;

import ua.itea.entity.UserEntity;

import java.util.List;

/**
 * This class implements basic methods for connect database
 *
 * @author Maksym Stetsenko
 */


public class UserDAO extends AbstractDAO<UserEntity> {

    public UserEntity getUserById(Long id) {
        return super.getEntityById(UserEntity.class, id);
    }

    public UserEntity getUserByEmail(String email) {
        UserEntity user = getEntityManager()
                .createNamedQuery("UserEntity.getUserByEmail", UserEntity.class)
                .setParameter("email", email)
                .getSingleResult();
        return user;
    }

    public List<UserEntity> getAll() {
        return getAll(UserEntity.class);
    }


}
