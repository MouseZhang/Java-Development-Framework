package cn.ustb.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 授权（链式编程）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问，功能页只有对应权限的人访问
        // 请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        // 无权限默认跳回登录页面
        // loginPage并设置自己的登录页
        // loginProcessingUrl用于设置登录认证的页面
        // usernameParameter指定与前台表单name属性对应的值，不指定默认username
        // passwordParameter指定与前台表单name属性对应的值，不指定默认password
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");
        // 防止网站攻击，GET请求登出时会失效
        http.csrf().disable();
        // 注销，回到首页
        http.logout().logoutSuccessUrl("/");
        // 开启记住我功能
        // 默认保存2周
        // 自定义提交参数（与前台保持一致）
        http.rememberMe().rememberMeParameter("remember");
    }

    // 认证
    // 密码编码PasswordEncoding
    // 在SpringSecurity5.x中新增了许多加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 正常应从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("mousezhang").password(new BCryptPasswordEncoder().encode("12345")).roles("vip2", "vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("root123")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("11111")).roles("vip1");
    }

}
