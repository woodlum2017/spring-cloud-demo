package icu.woodlum.rules;



import com.netflix.client.config.IClientConfig;

import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author woodlum
 * @create 2020-12-03 16:57
 *
 */
public class FiveRoundRibbonRule extends AbstractLoadBalancerRule {
    private AtomicInteger nextServerCyclicCounter;
    private static final boolean AVAILABLE_ONLY_SERVERS = true;
    private static final boolean ALL_SERVERS = false;
    private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);
    private static int count = 0;  //被调用次数
    private static int index = 0;  //当前微服务索引
    public FiveRoundRibbonRule() {
        this.nextServerCyclicCounter = new AtomicInteger(0);
    }

    public FiveRoundRibbonRule(ILoadBalancer lb) {
        this();
        this.setLoadBalancer(lb);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        }
        Server server = null;
        while (server == null){
            if(Thread.interrupted()) {
                return null;
            }
            //获取可用服务列表
            List<Server> upList = lb.getReachableServers();
            //获取所有服务列表
            List<Server> allList = lb.getAllServers();
            //所有微服务数量
            int serverCount = allList.size();
            if ( serverCount == 0) {
                return null;
            }
            if (count < 5) {
                server = upList.get(index);
                count++;
            } else {
                count = 0;
                index ++ ;
                if (index >= upList.size() ) {
                    index = 0;
                }
            }

            if(server == null) {
                Thread.yield();
                continue;
            }

        }
        return server;
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}

