package icu.woodlum.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author woodlum
 * @create 2020-11-26 15:13
 */
@SpringBootApplication
@EnableEurekaClient
//启用feign,basePackages指定@FeignClient注解所在的当前包，此处踩坑一天
@EnableFeignClients(basePackages = {"icu.woodlum.cn.service"})
public class ConfigConsummerFeign82 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigConsummerFeign82.class, args);
    }
}
