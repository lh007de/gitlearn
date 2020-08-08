package org.lh.springboot02;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Springboot02Application {

    public static void main(String[] args) {
//        SpringApplication.run(Springboot02Application.class, args);
        // 关闭banner
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Springboot02Application.class);
        springApplicationBuilder.build()
                .setBannerMode(Banner.Mode.OFF);
        springApplicationBuilder.run(args);
    }

}
