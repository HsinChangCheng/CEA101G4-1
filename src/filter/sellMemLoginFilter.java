package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.*;
import javax.servlet.http.*;

import com.sell.model.SellService;
import com.sell.model.SellVO;

public class sellMemLoginFilter implements Filter {
	private FilterConfig config;
	
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		SellVO sellVO = (SellVO) session.getAttribute("sellVO");
		
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1. 讓登出後就算按上一頁也無法看到內容
		res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		res.setDateHeader("Expires", 0); // Proxies.
		
//		SellService sellSvc = new SellService();
//	
//		Cookie[] cookies = req.getCookies();
//		if (cookies != null) {
//			for (Cookie c : cookies) {
//				if ("username".equals(c.getName())) {	
//					
//						if(session.getAttribute("sellVO") == null) { //解決如果使用者為登入 但關閉瀏覽器後再次開啟仍可登入(session消失)
//							sellVO = sellSvc.getOneSell(c.getValue());
//							session.setAttribute("sellVO", sellVO);
//						}
//						
//					chain.doFilter(request, response);
//					return;
//				}
//			}
//		}
		

		if (sellVO == null){ //使用者從網址直接進去需登入畫面時。
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/front-sell-end/sellMemLogin.jsp");
		} else {
			req.setAttribute("sellVO", sellVO);
			chain.doFilter(req, res);
		}

	}

}
