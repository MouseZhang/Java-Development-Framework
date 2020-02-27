package cn.ustb.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async // 告诉Spring这是一个异步方法，同时还需要在主程序开启异步功能
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("******** 数据处理中，请耐心等待 ********");
    }

}
