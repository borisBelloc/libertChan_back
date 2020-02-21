package kaboni.libertchan.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;


@Configuration

public class CORSFilter extends GenericFilterBean {
	
	@Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        addCORSHeadersToResponse((HttpServletResponse) res);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpStatus.OK.value());
        } else {
            chain.doFilter(req, response);
        }
	}
    @Override
    public void destroy() {
    }

    public static void addCORSHeadersToResponse(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, AuthToken, Content-Type, Origin, Authorization, Accept, Accept-Version, Client-Security-Token, X-CSRF-Token");
        response.setHeader("Access-Control-Expose-Headers", "X-Auth-TryCount, Authorization");
    }

}
