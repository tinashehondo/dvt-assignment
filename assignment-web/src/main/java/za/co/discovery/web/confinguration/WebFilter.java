package za.co.discovery.web.confinguration;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by tinashehondo on 4/15/17.
 */

public class WebFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		response.setHeader("X-XSS-Protection", "1; mode=block");
		response.setHeader("Access-Control-Allow-Headers", "X-requested-with, Content-Type");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);

		chain.doFilter(req, res);

	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}