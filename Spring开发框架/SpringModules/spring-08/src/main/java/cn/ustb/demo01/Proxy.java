package cn.ustb.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        seeHouse();
        host.rent();
        contract();
        fare();
    }

    // 看房
    public void seeHouse() {
        System.out.println("***** 中介带着看房子！");
    }

    // 签租赁合同
    public void contract() {
        System.out.println("***** 签租赁合同！");
    }

    // 收中介费
    public void fare() {
        System.out.println("***** 收取中介费！");
    }
}
