package icu.woodlum.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author woodlum
 * @create 2020-11-11 11:58
 */
@SpringBootApplication
@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
public class Provider8001 {
    public static void main(String[] args) {
        SpringApplication.run(Provider8001.class,args);
    }
}
