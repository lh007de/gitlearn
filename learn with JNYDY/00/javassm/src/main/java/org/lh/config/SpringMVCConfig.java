package org.lh.config;

import org.lh.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName: SpringMVCConfig
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/13 12:54
 * @Version: 1.0
 **/
@Configuration
@ComponentScan(basePackages = "org.lh",useDefaultFilters = false,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)})
public class SpringMVCConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

    }

    @Bean
    MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}
