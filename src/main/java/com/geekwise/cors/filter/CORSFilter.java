package com.geekwise.cors.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CORSFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		/*Following implementation is very generic to allow all origin with all request methods. It can be made more secured by handling it on 
		 * each resource level and allow only method which are allowed for that particular function*/

		/* Refer https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers for more info*/
		if(request.getMethod().equalsIgnoreCase("OPTIONS")) {
			//Trusted Origin URL like https://www.myapplication.com. Multiple can be defined with comma seperated
			response.addHeader("Access-Control-Allow-Origin", "*");
			//Request Method you want to allow after this
			response.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE");
			//Maximum number of seconds to send request
			response.addHeader("Access-Control-Max-Age", "3600");
			//Headers allowed in incoming request including custom header like Authorization
			response.addHeader("Access-Control-Allow-Headers",
					"Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Access-Control-Allow-Origin ,Authorization");
			//Whether to expose credentials to Javascript or not
			response.addHeader("Access-Control-Allow-Credentials", "true");
			response.setStatus(200);

			RequestDispatcher dispatcher = request.getRequestDispatcher(request.getRequestURI());			
			dispatcher.forward(request, new HttpServletResponseWrapper(response));
		}else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		
	}

}
