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

    public List<ProductEntity> getProductsByCategory(CategoryEntity category) {
        List<ProductEntity> result = getEntityManager()
                .createNamedQuery("ProductEntity.getProductsByCategory", ProductEntity.class)
                .setParameter("category", category)
                .getResultList();
        return result;
    }

    public List<ProductEntity> getProductsBySubCategory(SubCategoryEntity subCategory) {
        List<ProductEntity> result = getEntityManager()
                .createNamedQuery("ProductEntity.getProductsBySubCategory", ProductEntity.class)
                .setParameter("subCategory", subCategory)
                .getResultList();
        return result;
    }

    public List<ProductEntity> getProductsByName(String productName) {
        List<ProductEntity> result = getEntityManager()
                .createNamedQuery("ProductEntity.getProductsByName", ProductEntity.class)
                .setParameter("productName", productName)
                .getResultList();
        return result;
    }

    public List<ProductEntity> getProductsByNameAndCategory(String productName, CategoryEntity category) {
        List<ProductEntity> result = getEntityManager()
                .createNamedQuery("ProductEntity.getProductsByNameAndCategory", ProductEntity.class)
                .setParameter("productName", "%" + productName + "%")
                .setParameter("category", category)
                .getResultList();
        return result;
    }
}
