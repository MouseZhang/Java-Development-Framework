package cn.ustb.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启Swagger2
public class SwaggerConfig {

    // 配置Swagger的Docket的Bean实例
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的Swagger环境（设置为开发或测试环境）
        Profiles profiles = Profiles.of("dev","test");

        // 判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        // 定义了一些接口过滤的方法
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("USTB")
                .enable(flag)
                // .enable(false) // 是否启用swagger，默认true
                .select()
                // RequestHandlerSelectors配置要扫描接口的方式
                // RequestHandlerSelectors.basePackage指定要扫描的包
                // RequestHandlerSelectors.any扫描全部
                // RequestHandlerSelectors.none都不扫描
                // withClassAnnotation扫描类上的注解，参数是一个注解的反射对象
                // withMethodAnnotation扫描方法上的注解，参数是一个注解的反射对象
                // .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.basePackage("cn.ustb.controller")) // 设置要扫描的包
                // .paths(PathSelectors.ant("/mouse/**")) // 过滤路径，此时没有任何代码被扫描到
                .build();
    }

    // 配置Swagger信息（ApiInfo)
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("MouseZhang", "https://github.com/mousezhang", "mousezhang@188.com");
        return new ApiInfo(
                "MouseZhang's API Document",
                "这个作者有点酷",
                "1.0",
                "https://github.com/mousezhang",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

}
