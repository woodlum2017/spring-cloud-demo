package icu.woodlum.cn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author woodlum
 * @create 2020-11-26 16:35
 */
@SpringBootApplication
//启用Eureka服务器
@EnableEurekaServer
public class ConfigEurekaService7003 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaService7003.class,args);
    }
}
