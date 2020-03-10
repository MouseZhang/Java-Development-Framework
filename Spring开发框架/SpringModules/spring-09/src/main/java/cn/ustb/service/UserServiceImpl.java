package cn.ustb.service;

public class UserServiceImpl implements UserService{
    public void insert() {
        System.out.println("***** 增加了一个用户！");
    }

    public void update() {
        System.out.println("***** 修改了一个用户！");
    }

    public void delete() {
        System.out.println("***** 删除了一个用户！");
    }

    public void list() {
        System.out.println("***** 查询了一个用户！");
    }
}
