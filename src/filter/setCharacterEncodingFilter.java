package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/setCharacterEncodingFilter")
public class setCharacterEncodingFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig config = null;
	
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		this.encoding = config.getInitParameter("encoding");
	}
	
	public void destroy() {
		this.encoding = null;
		this.config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html; charset=UTF-8");
		chain.doFilter(request, response);
	}




}
