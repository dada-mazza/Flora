package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.itea.dao.jpa.CategoryDAO;
import ua.itea.entity.CategoryEntity;

import java.util.List;


@Controller
@RequestMapping("/categories")
@SessionAttributes("categories")
public class CategoryController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String doGet(ModelMap model) {

        List<CategoryEntity> categories = (List<CategoryEntity>) model.get("categories");

        if (categories == null) {
            categories = new CategoryDAO().getAll();
            model.addAttribute("categories", categories);
        }

        String url = "categories";
        log.info("url -> " + url);
        return url;
    }
}
