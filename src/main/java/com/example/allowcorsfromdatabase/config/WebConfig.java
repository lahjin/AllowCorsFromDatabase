package com.example.allowcorsfromdatabase.config;

import com.example.allowcorsfromdatabase.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@RequiredArgsConstructor

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final CorsFilter corsFilter;

    private final AuthInterceptor authInterceptor;

    @Bean
    public FilterRegistrationBean customCorsFilter() {
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
        filter.setFilter(corsFilter);
        filter.setOrder(1);
        filter.addUrlPatterns("/data");
        return filter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/data");
    }
}
