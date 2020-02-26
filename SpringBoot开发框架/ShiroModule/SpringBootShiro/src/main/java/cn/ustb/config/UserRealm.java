package cn.ustb.config;

import cn.ustb.pojo.User;
import cn.ustb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

// 自定义Realm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    // 授权（登录后进入页面就会授权）
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("********** 执行了【授权】doGetAuthorizationInfo **********");
        // 为用户授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 取得当前用户对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();// 取得认证阶段保存的User对象
        // 为用户添加权限（从数据库中查）
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    // 认证（登录就会认证）
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("********** 执行了【认证】doGetAuthenticationInfo **********");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        // 连接数据库
        User user = userService.getUserByName(userToken.getUsername());
        if (user == null) {
            return null; // 会抛出UnknownAccountException的异常
        }
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("loginUser", user);
        // 密码认证
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }

}
