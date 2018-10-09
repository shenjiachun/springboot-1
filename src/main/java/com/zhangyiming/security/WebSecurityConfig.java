package com.zhangyiming.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.session.SimpleRedirectSessionInformationExpiredStrategy;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AjaxAuthenticationEntryPoint authenticationEntryPoint;  //  未登陆时返回 JSON 格式的数据给前端（否则为 html）

    @Autowired
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;  // 登录成功返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    AjaxAuthenticationFailureHandler authenticationFailureHandler;  //  登录失败返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    AjaxAccessDeniedHandler accessDeniedHandler;    // 无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）

    @Autowired
    AjaxLogoutSuccessHandler logoutSuccessHandler;    // 无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）

    private SessionRegistry sessionRegistry;

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/hello").access("hasRole('USER')") // 需要权限ROLE_COMMON 才可以访问的路径
                .anyRequest().authenticated()
                .and().formLogin()
//                .defaultSuccessUrl("http://localhost:8080/th/index")
                .successHandler(authenticationSuccessHandler) // 登录成功
                .failureHandler(authenticationFailureHandler) // 登录失败
                .permitAll()/*.loginPage("/login").defaultSuccessUrl("/index").failureUrl("/login?error")*/
                .and().logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll()
                //默认注销行为为logout，可以通过下面的方式来修改
                //.logoutUrl("/custom-logout")
                //设置注销成功后跳转页面，默认是跳转到登录页面
                //.logoutSuccessUrl("")
                .and()
                //开启cookie保存用户数据
                .rememberMe()
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7);
                //设置cookie的私钥
                //.key("");
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // 无权访问 JSON 格式的数据
        //只允许一个用户登录,如果同一个账户两次登录,那么第一个账户将被踢下线,跳转到登录页面
        http.sessionManagement()
                .maximumSessions(1)
                .expiredSessionStrategy(sessionInformationExpiredStrategy())
                .sessionRegistry(sessionRegistry);//.expiredUrl("/login.html");
    }

    //session失效跳转      
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
//        throw new RuntimeException("session失效！！！");
        return new SimpleRedirectSessionInformationExpiredStrategy("/login.html");
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    //SpringSecurity内置的session监听器      
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

}