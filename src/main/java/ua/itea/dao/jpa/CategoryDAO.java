package ua.itea.dao.jpa;

import ua.itea.entity.CategoryEntity;

import java.util.List;

/**
 * This class implements basic methods for connect database
 *
 * @author Maksym Stetsenko
 */


public class CategoryDAO extends AbstractDAO<CategoryEntity> {

    public CategoryEntity getCategoryById(Long id) {
        return super.getEntityById(CategoryEntity.class, id);
    }

    public List<CategoryEntity> getAll() {
        return getAll(CategoryEntity.class);
    }

}
