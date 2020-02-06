package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberInsert {
    public static void main(String[] args) {
        Member vo = new Member();
        vo.setMid("member");
        vo.setName("TOM");
        vo.setAge(22);
        System.out.println(HibernateSessionFactory.getSession().save(vo));
        HibernateSessionFactory.getSession().beginTransaction().commit();
        HibernateSessionFactory.closeSession();
    }
}
