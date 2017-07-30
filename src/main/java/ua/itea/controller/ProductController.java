package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.itea.dao.jpa.CategoryDAO;
import ua.itea.dao.jpa.ProductDAO;
import ua.itea.dao.jpa.SubCategoryDAO;
import ua.itea.entity.CategoryEntity;
import ua.itea.entity.ProductEntity;
import ua.itea.entity.SubCategoryEntity;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String getAllProducts(ModelMap model) {

        List<ProductEntity> products = new ProductDAO().getAll();
        model.addAttribute("products", products);

        String url = "products";
        log.info("url -> " + url);
        return url;
    }

    @RequestMapping(value = "/category",
            method = RequestMethod.GET)
    public String getProductsByCategory(ModelMap model,
                                        @RequestParam("category") Long category_id) {

        CategoryEntity category = new CategoryDAO().getCategoryById(category_id);
        List<ProductEntity> products = new ProductDAO().getProductsByCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);

        String url = "products";
        log.info("url -> " + url);
        return url;
    }

    @RequestMapping(value = "/subCategory",
            method = RequestMethod.GET)
    public String getProductsBySubCategory(ModelMap model,
                                           @RequestParam("category") Long category_id,
                                           @RequestParam("subCategory") Long subCategory_id) {
        CategoryEntity category = new CategoryDAO().getCategoryById(category_id);
        SubCategoryEntity subCategory = new SubCategoryDAO().getSubCategoryById(subCategory_id);
        List<ProductEntity> products = new ProductDAO().getProductsBySubCategory(subCategory);
        model.addAttribute("category", category);
        model.addAttribute("subCategory", subCategory);
        model.addAttribute("products", products);

        String url = "products";
        log.info("url -> " + url);
        return url;
    }
}

