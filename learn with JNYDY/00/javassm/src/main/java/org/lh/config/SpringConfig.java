package org.lh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ClassName: SpringConfig
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/13 12:53
 * @Version: 1.0
 **/

@Configuration
@ComponentScan(basePackages = "org.lh",useDefaultFilters = true,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})
public class SpringConfig {
}
