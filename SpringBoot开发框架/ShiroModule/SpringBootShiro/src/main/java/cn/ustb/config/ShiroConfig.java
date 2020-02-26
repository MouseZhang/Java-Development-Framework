package cn.ustb.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 1、创建Realm对象，需要自定义
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    // 2、创建DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 3、创建ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        // 添加Shiro的内置过滤器
        /**
         * anno：无需认证就能访问
         * authc：必须认证才能访问
         * user：必须拥有"记住我"功能才能用
         * perms：必须拥有对某个资源的权限才能访问：
         * role：必须拥有某个角色权限才能访问
         * filterMap.put("/user/insert", "authc");
         * filterMap.put("/user/update", "authc");
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 权限操作
        // 401为未授权，正常情况下应该跳转到授权页
        filterMap.put("/user/insert", "perms[user:insert]");
        filterMap.put("/user/update", "perms[user:update]");
        // 支持拦截通配符
        filterMap.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);
        // 如果无权限，设置登录请求
        bean.setLoginUrl("/toLogin");
        // 设置未授权的请求
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    // 整合ShiroDialect（用来整合Thymeleaf）
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
