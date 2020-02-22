package cn.ustb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

// 扩展Spring MVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // public interface ViewResolver 实现了视图解析器的类，就可以看作为视图解析器
    @Bean
    public ViewResolver getMyViewResolver() {
        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

    // 重写视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ustb").setViewName("index"); // 添加视图控制
    }
}
