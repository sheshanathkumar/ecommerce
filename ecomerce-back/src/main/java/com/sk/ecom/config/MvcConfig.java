package com.sk.ecom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
//@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{

	@Value("${spring.allowed.origin}")
	public String allowedOrigin;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedHeaders("*")
			.allowedOrigins(allowedOrigin)
			.allowedMethods("GET", "POST", "PUT")
			.maxAge(3600);
	}


	@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
	
}


//@Configuration
//@EnableWebMvc
//@ComponentScan("com.sk.ecom.controller")
//class ServletContextConfig extends WebMvcConfigurerAdapter {
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/*.*").addResourceLocations("../resources/static/");
//	}
//	
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//	    registry.addViewController("/").setViewName("../resources/static/index.html");
//	}
//}