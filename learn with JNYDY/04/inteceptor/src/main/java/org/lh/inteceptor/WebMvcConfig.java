package org.lh.inteceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: WebMvcConfig
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/17 14:54
 * @Version: 1.0
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInteceptor()).addPathPatterns("/**");
    }

    @Bean
    MyInteceptor myInteceptor(){
        return new MyInteceptor();
    }
}
