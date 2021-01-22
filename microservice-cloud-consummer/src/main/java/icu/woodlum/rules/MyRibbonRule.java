package icu.woodlum.rules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author woodlum
 * @create 2020-12-03 16:07
 */
// 自定义Ribbon规则配置
// 注意，此类不能放在主启动类所在的包及其子包下，不能被@componentScan所扫描
// 否则，此规则会适配所有的Ribbon客户端，达不到特殊化要求
@Configuration
public class MyRibbonRule {
    @Bean
    // 修改负载算法策略为随机
    public IRule getIRule(){
        return new FiveRoundRibbonRule();
    }
}
