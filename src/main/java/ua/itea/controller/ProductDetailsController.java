package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.itea.dao.jpa.ProductDAO;
import ua.itea.entity.ProductEntity;

import java.util.List;

@Controller
@RequestMapping("/productDetails")
public class ProductDetailsController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String service(@RequestParam("productId") Long productId,
                          ModelMap model) {

        String url;

        ProductEntity product = new ProductDAO().getProductById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            List<ProductEntity> relatedProducts = new ProductDAO().getAll();
            model.addAttribute("products", relatedProducts);
            url = "productDetails";
        } else {
            url = "redirect:/products";
        }

        log.info("url -> " + url);
        return url;
    }
}
