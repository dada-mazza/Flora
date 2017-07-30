package ua.itea.dao.jpa;

import ua.itea.entity.CategoryEntity;
import ua.itea.entity.SubCategoryEntity;

import java.util.List;

/**
 * This class implements basic methods for connect database
 *
 * @author Maksym Stetsenko
 */


public class SubCategoryDAO extends AbstractDAO<SubCategoryEntity> {

    public SubCategoryEntity getSubCategoryById(Long id) {
        return super.getEntityById(SubCategoryEntity.class, id);
    }

    public List<SubCategoryEntity> getAll() {
        return getAll(SubCategoryEntity.class);
    }

    public List<SubCategoryEntity> getAllByCategory(CategoryEntity category) {
        List<SubCategoryEntity> result = getEntityManager()
                .createNamedQuery("SubCategoryEntity.getAllByCategory", SubCategoryEntity.class)
                .setParameter("category", category)
                .getResultList();
        return result;

    }

}
