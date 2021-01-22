package icu.woodlum.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author woodlum
 * @create 2020-12-23 9:45
 */
@SpringBootApplication
// 启用服务监控
@EnableHystrixDashboard
public class ConsummerDashBoard {
    public static void main(String[] args) {
        SpringApplication.run(ConsummerDashBoard.class,args);
    }
}
