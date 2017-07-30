package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ua.itea.dao.jdbc.CategoryDAO;
import ua.itea.entity.CategoryEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//WebServlet("/categories")
public class CategoriesServlet extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameAttribute = "categories";
        List<CategoryEntity> categories = new CategoryDAO().getAll(CategoryEntity.class);
        request.setAttribute(nameAttribute, categories);
        String includeURL = "categories.jsp";
        log.info("include : " + includeURL);
        request.getRequestDispatcher(includeURL).include(request, response);
    }
}
