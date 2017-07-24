package ua.itea.filter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ua.itea.dao.CategoryDAO;
import ua.itea.entity.Category;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(
        servletNames = "*",
        filterName = "CategoriesFilter",
        description = "Filter for categories (all servlets)"
)
public class CategoriesFilter implements Filter {

    private Log log = LogFactory.getLog(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter");
        String nameAttribute = "categories";

        HttpSession session = ((HttpServletRequest) request).getSession();
        List<Category> categories = (List<Category>) session.getAttribute(nameAttribute);
        if (categories == null) {
            categories = new CategoryDAO().getAll();
            session.setAttribute(nameAttribute, categories);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}


