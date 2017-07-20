package ua.itea.dao;

import java.util.List;

/**
 * <code>DAO</code> interface to database access object.
 */
public interface DAO<E> {

    List<E> getAll();

    E getEntityById(Long id);

    boolean update(E entity);

    Long create(E entity);

    boolean delete(E entity);
}
