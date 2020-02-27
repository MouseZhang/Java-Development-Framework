package cn.ustb.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    // 需要设置cron表达式，6个占位符分别表示
    // 秒 分 时 日 月 周几（cron = "0 * * * * 0-7"）
    /*
        举例：
            30 15 10 * * ?     每天的10点15分30秒执行
            30 0/5 10,18 * * ?     每天的10点和18点，每隔5分钟执行
            0 15 10 ? * 1-6     每个月的周一至周六，10点15分执行
     */
    @Scheduled(cron = "0 * * * * ?")
    public void hello() { // 在一个特定的时间执行方法
        System.out.println("****** 执行定时任务 ******");
    }

}
