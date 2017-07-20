package ua.itea.beans;

import ua.itea.dao.ProductDAO;
import ua.itea.entity.Product;

import java.util.List;

/**
 * Created by dada.mazza on 10.07.2017.
 */
public class ProductsBean {

    private List<Product> products;
    private Long categoryId;

    public ProductsBean() {
    }

    public List<Product> getProducts() {
        if (categoryId == null) {
            products = new ProductDAO().getAll();
        } else {
            products = new ProductDAO().getAllByCategoryId(categoryId);
        }
        return products;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
