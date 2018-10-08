package com.zhangyiming.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.RequestVariablesExtractor;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

    public final DefaultMatcher defaultMatcher = new DefaultMatcher();

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("退出登录成功。。。");
    }

    private class DefaultMatcher implements RequestMatcher, RequestVariablesExtractor {

        private final UrlPathHelper pathHelper = new UrlPathHelper();

        private final PathMatcher pathMatcher = new AntPathMatcher();

        @Override
        public boolean matches(HttpServletRequest request) {
            String lookupPath = this.pathHelper.getLookupPathForRequest(request);
            return matches(lookupPath);
        }

        private boolean matches(String lookupPath) {
            return this.pathMatcher.match("/", lookupPath);
        }

        @Override
        public Map<String, String> extractUriTemplateVariables(
                HttpServletRequest request) {
            String lookupPath = this.pathHelper.getLookupPathForRequest(request);
            if (matches(lookupPath)) {
                return this.pathMatcher.extractUriTemplateVariables(
                        "/", lookupPath);
            }
            return Collections.emptyMap();
        }
    }

}