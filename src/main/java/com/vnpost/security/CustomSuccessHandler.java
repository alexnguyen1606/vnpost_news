package com.vnpost.security;

import com.vnpost.utils.SecurityUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@Component
public class CustomSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determindTargetUrl(authentication);
        if (response.isCommitted()){
            return;
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }
    private String determindTargetUrl(Authentication authentication){
        String url = "";
        List<String>roles = SecurityUtils.getAutherities();
        if (isAdmin(roles)){
            url ="/admin";
        }else if (isUser(roles)){
            url = "/admin";
        }
        return url;
    }

    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ADMIN"))
            return true;
        else
            return false;
    }
    private boolean isUser(List<String> roles){
        if (roles.contains("USER"))
            return true;
        else
            return false;
    }
}
