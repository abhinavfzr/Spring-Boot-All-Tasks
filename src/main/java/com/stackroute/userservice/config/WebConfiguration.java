package com.stackroute.userservice.config;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration
{
    @Bean
    ServletRegistrationBean h2ServletRegistration()
    {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebdavServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }

}
