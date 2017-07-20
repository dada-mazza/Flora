package ua.itea.beans;

import ua.itea.dao.CategoryDAO;
import ua.itea.entity.Category;

import java.util.List;

/**
 * Created by dada.mazza on 10.07.2017.
 */
public class CategoriesBean {
    private List<Category> categories;

    public CategoriesBean() {
    }

    public List<Category> getCategories() {
        categories = new CategoryDAO().getAll();
        return categories;
    }
}
