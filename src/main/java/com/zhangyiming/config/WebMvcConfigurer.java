package com.zhangyiming.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\17 001721:02
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
//        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
//                .addPathPatterns("/one/**");
//        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");

        super.addInterceptors(registry);
    }

}