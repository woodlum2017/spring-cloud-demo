package icu.woodlum.cn;

import icu.woodlum.rules.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author woodlum
 * @create 2020-11-26 15:13
 */
@SpringBootApplication
@EnableEurekaClient
// 自定义Ribbon规则，针对某一个微服务使用自定义规则
@RibbonClient(name = "MIRCROSERVICE-CLOUD-PROVIDER",configuration = MyRibbonRule.class)
public class Consummer {
    public static void main(String[] args) {
        SpringApplication.run(Consummer.class, args);
    }
}
