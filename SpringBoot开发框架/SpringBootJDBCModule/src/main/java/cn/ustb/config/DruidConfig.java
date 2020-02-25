package cn.ustb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 后台监控功能
    // ServletRegistrationBean相当于web.xml，因为本身SpringBoot内置了Servlet容器，没有web.xml，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 后台账号密码的配置
        Map<String, String> initParameters = new HashMap<>();
        // 增加登录账号
        initParameters.put("loginUsername", "admin"); // 登录的key是固定的
        initParameters.put("loginPassword", "hello"); // 登录的key是固定的
        // 允许谁可以访问
        initParameters.put("allow", "localhost");
        // 禁止谁能访问 initParameters.put("mousezhang", "192.168.0.106");
        bean.setInitParameters(initParameters); // 设置初始化参数
        return bean;
    }

    // 配置过滤器
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        // 可以过滤的请求
        Map<String, String> initParameters = new HashMap<>();
        // 排除过滤
        initParameters.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }

}
