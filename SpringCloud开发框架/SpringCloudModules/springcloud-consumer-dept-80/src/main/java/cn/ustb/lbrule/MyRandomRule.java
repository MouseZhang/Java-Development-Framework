package cn.ustb.lbrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyRandomRule extends AbstractLoadBalancerRule {

    /**
     * 每个服务访问5次，换下一个服务（目前总共有3个服务）
     * 1、total=0，默认为0，如果total=5，指向下一个服务节点
     * 2、index=0，默认为0，如果total=5，index++，如果index>3，则重置为0重新开始
     */

    private int total = 0; // 被调用的次数
    private int currentIndex = 0; // 当前提供服务的次数

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers(); // 获得活着的服务
            List<Server> allList = lb.getAllServers(); // 获得全部的服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            /*
                int index = chooseRandomInt(serverCount); // 生成区间随机数
                server = upList.get(index); // 从活着的服务随机获取一个
             */

            // 修改新的算法
            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex > upList.size()) {
                    currentIndex = 0;
                }
                server = upList.get(currentIndex); // 从活着的服务中获取指定的服务进行操作
            }


            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
	}

}
