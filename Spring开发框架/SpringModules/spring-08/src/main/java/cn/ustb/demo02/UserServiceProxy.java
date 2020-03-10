package cn.ustb.demo02;

public class UserServiceProxy implements UserService {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void insert() {
        log("insert");
        userService.insert();
    }

    public void update() {
        log("update");
        userService.update();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void list() {
        log("list");
        userService.list();
    }

    // 打印日志
    public void log(String msg) {
        System.out.println("[DEBUG]使用了" + msg + "方法！");
    }

}
