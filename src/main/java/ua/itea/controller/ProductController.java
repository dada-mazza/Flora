package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.itea.dao.jpa.ProductDAO;
import ua.itea.entity.ProductEntity;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String service(ModelMap model) {

        List<ProductEntity> products = new ProductDAO().getAll();
        model.addAttribute("products", products);

        String url = "products";
        log.info("url -> " + url);
        return url;
    }
}

