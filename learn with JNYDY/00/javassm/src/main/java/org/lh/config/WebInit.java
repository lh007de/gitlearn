package org.lh.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @ClassName: WebInit
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/13 13:05
 * @Version: 1.0
 **/
public class WebInit implements WebApplicationInitializer {
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.register(SpringMVCConfig.class);
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(context));
        springmvc.addMapping("/");
        springmvc.setLoadOnStartup(1);


    }
}
