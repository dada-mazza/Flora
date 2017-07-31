package ua.itea.dao.jpa;

import ua.itea.dao.DAO;
import ua.itea.entity.FloraEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * This class implements basic methods for connect database
 *
 * @author Maksym Stetsenko
 */
abstract class AbstractDAO<E extends FloraEntity> implements DAO<E> {

    private final String PERSISTENCE_UNIT_NAME = "entityManagerHeroku";
    private EntityManager entityManager;

    public AbstractDAO() {
        entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public EntityTransaction getEntityTransaction() {
        return entityManager.getTransaction();
    }

    @Override
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }

    @Override
    public Long create(E entity) {
        getEntityTransaction().begin();
        getEntityManager().persist(entity);
        getEntityTransaction().commit();
        return entity.getId();
    }

    @Override
    public E getEntityById(Class<E> entityClass, Long id) {
        E entity = getEntityManager().find(entityClass, id);
        return entity;
    }

    @Override
    public E update(E entity) {
        getEntityTransaction().begin();
        getEntityManager().merge(entity);
        getEntityTransaction().commit();
        return entity;
    }

    @Override
    public void delete(E entity) {
        getEntityTransaction().begin();
        getEntityManager().remove(entity);
        getEntityTransaction().commit();
    }

    @Override
    public List<E> getAll(Class<E> entityClass) {
        List<E> result = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".getAll", entityClass).getResultList();
        return result;
    }

}
