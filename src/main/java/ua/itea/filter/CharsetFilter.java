package ua.itea.filter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(
        urlPatterns = "/*",
        filterName = "CharsetFilter",
        description = "set Charset for All Request (all URLs)"
)
public class CharsetFilter implements Filter {

    private Log log = LogFactory.getLog(getClass());
    private final String CHARSET = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletRequest.setCharacterEncoding(CHARSET);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}


