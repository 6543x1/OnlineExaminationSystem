package com.jessie.onlineexaminationsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.
//                addResourceHandler("/swagger-ui/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
        addResourceHandler("/static/**", "/oes/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        /** 公共部分内容 */
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");


        ;
//                .resourceChain(false);
//注意一下路径问题，如果controller路径是/wx/xxx，那么请求图片路径会变成/wx/static....如果你只做了/static的映射，没做/wx/static的映射
//那么会导致controller路径为/xxx的 图片能加载出来 /wx/xxx这类的路径, 图片报404错误
//我也不知道怎么完美处理这个问题，考虑到这个项目未来估计也就一个controller会定位到这个页面，所以对/wx/static做了映射
//       未来者如果想完美解决这个bug,欢迎处理，未来应该不会变成前后不分离的项目吧？
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/swagger-ui/")
                .setViewName("forward:/swagger-ui/index.html");
    }
}
