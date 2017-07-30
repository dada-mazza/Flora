package ua.itea.dao.jpa;

import ua.itea.entity.CategoryEntity;
import ua.itea.entity.ProductEntity;
import ua.itea.entity.SubCategoryEntity;

import java.util.List;

/**
 * This class implements basic methods for connect database
 *
 * @author Maksym Stetsenko
 */


public class ProductDAO extends AbstractDAO<ProductEntity> {

    public ProductEntity getProductById(Long id) {
        return super.getEntityById(ProductEntity.class, id);
    }

    public List<ProductEntity> getAll() {
        return getAll(ProductEntity.class);
    }

    public List<ProductEntity> getProductsByCategories(CategoryEntity categoryEntity) {
        List<ProductEntity> result = getEntityManager().createNamedQuery("ProductEntity.getProductsByCategories", ProductEntity.class).getResultList();
        return result;
    }

    public List<ProductEntity> getProductsBySubCategories(SubCategoryEntity subCategoryEntity) {
        List<ProductEntity> result = getEntityManager().createNamedQuery("ProductEntity.getProductsBySubCategories", ProductEntity.class).getResultList();
        return result;
    }
}
