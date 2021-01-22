package icu.woodlum.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author woodlum
 * @create 2020-12-29 16:03
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulProxy9000 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulProxy9000.class, args);
    }
}
