package cn.ustb.demo01;

public class Client {
    public static void main(String[] args) {
        /*
            代码步骤：
            1、接口或者抽象类
            2、真实角色
            3、代理角色
            4、客户端访问代理角色
         */

        // 房东要租房子
        Host host = new Host();
        // 代理，中介帮房东租房子
        // 代理一般会有附属操作
        Proxy proxy = new Proxy(host);
        // 不用面对房东，直接找中介租房
        proxy.rent();
    }
}
