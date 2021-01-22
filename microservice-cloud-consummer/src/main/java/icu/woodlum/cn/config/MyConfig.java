package icu.woodlum.cn.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author woodlum
 * @create 2020-11-26 15:08
 */
@Configuration
public class MyConfig {
    @Bean
    // 开启LB (负载均衡)
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    // 修改负载算法策略为随机
    public IRule getIRule(){
        return new RandomRule();
    }
}
