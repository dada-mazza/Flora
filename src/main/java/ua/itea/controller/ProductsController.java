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

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String getAllProducts(ModelMap model) {

        List<ProductEntity> products = new ProductDAO().getAll();
        model.addAttribute("products", products);

        String url = "products";
        log.info("url -> " + url);
        return url;
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.POST)
    public String searchProducts(ModelMap model,
                                 @RequestParam("inputNameProduct") String nameProduct,
                                 @RequestParam("selectCategoryId") Long categoryId,
                                 HttpServletRequest request) {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<ProductEntity> products;
        if (categoryId < 1) {
            products = new ProductDAO().getProductsByName(nameProduct);
        } else {
            CategoryEntity category = new CategoryDAO().getCategoryById(categoryId);
            products = new ProductDAO().getProductsByNameAndCategory(nameProduct, category);
            model.addAttribute("category", category);
        }
        model.addAttribute("products", products);

        String url = "products";
        log.info("url -> " + url);
        return url;
    }


    @RequestMapping(value = "/category",
            method = RequestMethod.GET)
    public String getProductsByCategory(ModelMap model,
                                        @RequestParam("category") Long categoryId) {

        CategoryEntity category = new CategoryDAO().getCategoryById(categoryId);
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
                                           @RequestParam("category") Long categoryId,
                                           @RequestParam("subCategory") Long subCategoryId) {
        CategoryEntity category = new CategoryDAO().getCategoryById(categoryId);
        SubCategoryEntity subCategory = new SubCategoryDAO().getSubCategoryById(subCategoryId);
        List<ProductEntity> products = new ProductDAO().getProductsBySubCategory(subCategory);
        model.addAttribute("category", category);
        model.addAttribute("subCategory", subCategory);
        model.addAttribute("products", products);

        String url = "products";
        log.info("url -> " + url);
        return url;
    }


    @RequestMapping(value = "/sort",
            method = RequestMethod.GET)
    public String getProductsBySubCategory(@RequestParam(required = false, name = "category") Long categoryId,
                                           @RequestParam(required = false, name = "subCategory") Long subCategoryId,
                                           @RequestParam(required = false, name = "sort") Integer sort,
                                           ModelMap model) {

        log.info("categoryId : " + categoryId);
        log.info("subCategoryId : " + subCategoryId);
        log.info("sort : " + sort);


        CategoryEntity category = new CategoryDAO().getCategoryById(categoryId);
        SubCategoryEntity subCategory = new SubCategoryDAO().getSubCategoryById(subCategoryId);
        List<ProductEntity> products = new ProductDAO().getProductsBySubCategory(subCategory);

        model.addAttribute("category", category);
        model.addAttribute("subCategory", subCategory);
        model.addAttribute("products", products);

        String url = "products";
        log.info("url -> " + url);
        return url;
    }
}

