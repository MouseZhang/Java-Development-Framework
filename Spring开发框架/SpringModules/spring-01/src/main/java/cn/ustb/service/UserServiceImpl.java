package cn.ustb.service;

import cn.ustb.dao.UserDao;
import cn.ustb.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 利用Setter进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
