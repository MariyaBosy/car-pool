package com.practo.jedi.carpool.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class SessionFilter implements Filter {
  private static List<String> secureUrls = new ArrayList<>();

  static {
    secureUrls.add("/car-pool/users");
    secureUrls.add("/car-pool/listings");
    secureUrls.add("/car-pool/addresses");
    secureUrls.add("/car-pool/sources");
  }

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if (request instanceof HttpServletRequest) {
      HttpSession session = ((HttpServletRequest) request).getSession();
      String uri = ((HttpServletRequest) request).getRequestURI();
      System.out.println(uri);
      for (String secureUrl : secureUrls) {
        if (uri.startsWith(secureUrl)) {
          if (session.getAttribute("user") == null) {
            ((HttpServletResponse) response).setStatus(401);
            return;
          } else {
            chain.doFilter(request, response);
          }
        } else {
          chain.doFilter(request, response);
        }
      }
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {}

}
