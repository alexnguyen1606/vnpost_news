package com.vnpost.config;

import com.vnpost.interceptor.UrlLocaleInterceptor;
import com.vnpost.interceptor.UrlLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;

@Configuration

public class WebMvcConfig implements WebMvcConfigurer {
    @Bean(name ="messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasenames("/WEB-INF/i18n/messsages");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor =new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        registry.addInterceptor(interceptor).addPathPatterns("/");

    }
    @Bean("localeResolver")
    public CookieLocaleResolver getLocaleResolver() {
        CookieLocaleResolver r= new CookieLocaleResolver();
        r.setCookiePath("/");
        r.setCookieMaxAge(2*24*3600);
        r.setDefaultLocale(new Locale("vi"));
        return r;
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("web/home");
//    }
//
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/views/");
//        bean.setSuffix(".jsp");
//
//        return bean;
//    }
}
