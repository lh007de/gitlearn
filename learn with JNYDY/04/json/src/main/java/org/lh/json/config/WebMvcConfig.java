package org.lh.json.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: WebMvcConfig
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 12:35
 * @Version: 1.0
 **/
@Configuration
public class WebMvcConfig {

    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy:MM:dd");
        converter.setFastJsonConfig(fastJsonConfig);
        return converter;
    }
}
