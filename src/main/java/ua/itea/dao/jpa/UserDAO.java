package ua.itea.dao.jpa;

import ua.itea.entity.UserEntity;

import javax.persistence.TypedQuery;
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
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery("UserEntity.getUserByEmail", UserEntity.class);
        return query.getSingleResult();
    }

    public List<UserEntity> getAll() {
        return getAll(UserEntity.class);
    }


}
