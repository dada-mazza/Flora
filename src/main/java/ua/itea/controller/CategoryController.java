package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.itea.dao.jpa.CategoryDAO;
import ua.itea.entity.CategoryEntity;

import javax.servlet.http.HttpServlet;
import java.util.List;


@Controller
@RequestMapping("/categories")
public class CategoryController extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {

        List<CategoryEntity> categories = new CategoryDAO().getAll();

        model.addAttribute("categories", categories);
        String url = "categories";
        log.info("url -> " + url);
        return url;
    }
}
