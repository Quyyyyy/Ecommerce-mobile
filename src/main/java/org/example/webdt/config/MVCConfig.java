package org.example.webdt.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        //ERROR: http://localhost:8080/css/styles.css 404
        //bất cứ request nào có dạng: /css/... sẽ vào folder src/main/resources/css
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + "upload/");

    }
}
