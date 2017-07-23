package ua.itea.filter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"*.jsp"},
        filterName = "JspFilter",
        description = "Filter for query logging (all URLs)"
)
public class JspFilter implements Filter {

    private Log log = LogFactory.getLog(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        log.info("ip : " + httpServletRequest.getRemoteAddr());
        log.info("url : " + httpServletRequest.getRequestURI());
        log.info("method : " + httpServletRequest.getMethod());

        String forwardURL = httpServletRequest.getRequestURI().replaceAll(".jsp", "");
        log.info("forward : " + forwardURL);
        request.getRequestDispatcher(forwardURL).forward(request, response);
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}


