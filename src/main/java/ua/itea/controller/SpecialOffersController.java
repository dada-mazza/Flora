package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.itea.dao.jpa.ProductDAO;
import ua.itea.entity.ProductEntity;

import java.util.List;

@Controller
@RequestMapping("/specialOffers")
public class SpecialOffersController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllOffers(ModelMap model) {

        List<ProductEntity> offers = new ProductDAO().getAll();
        model.addAttribute("products", offers);

        String url = "specialOffers";
        log.info("url -> " + url);
        return url;
    }


}

