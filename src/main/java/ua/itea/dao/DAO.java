package ua.itea.dao;

import ua.itea.entity.FloraEntity;

import java.util.List;

/**
 * <code>DAO</code> interface to database access object.
 */
public interface DAO<E extends FloraEntity> {

    Long create(E entity);

    E getEntityById(Class<E> entityClass, Long id);

    E update(E entity);

    void delete(E entity);

    List<E> getAll(Class<E> entityClass);

    void close();
}
