//package com.oschepich.spring_boot.new_spring_boot.config;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    // Метод, указывающий на класс конфигурации
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[]{
//                HibernateConfig.class, SecurityConfig.class
//        };
//    }
//
//    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения html.
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[]{
//                WebConfig.class
//        };
//    }
//
//
//    /* Данный метод указывает url, на котором будет базироваться приложение */
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//}