package com.safecode.amber.config;

import com.safecode.amber.webService.hello;
import com.safecode.amber.webService.helloipl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class hello_config {
    @Autowired
    private Bus bus;

    @Bean
    public   hello   userService() {
        return new helloipl();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletd() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }

    @Bean
    public EndpointImpl webservice() {
        EndpointImpl endpoint = new EndpointImpl(bus, userService());
        endpoint.publish("/hello");
        return endpoint;
    }

}
