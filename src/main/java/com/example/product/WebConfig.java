package com.example.product;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//    }
//}

//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")  // Allow requests to any endpoint
//                .allowedOrigins("https://d13u061zy1z3hj.cloudfront.net") // Replace with your CloudFront URL or S3 URL
//                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Adjust methods based on your needs
//                .allowedHeaders("*")  // Allow all headers
//                .allowCredentials(true);  // Allow cookies/credentials if needed
//    }
//}
