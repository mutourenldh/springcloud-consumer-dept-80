package com.haoge.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


/** 
* @author 李东浩
* @Date：2018年4月29日下午3:33:06
*
*/
@SpringBootApplication
//@EnableEurekaClient//ribbon做负载均衡时添加的

/**
 * 自定义ribbon负载均衡的规则，主启动类加@RibbonClient注解，然后创建自定义规则类即可
 * @RibbonClient这个注解的意思是对firstmaincloud-dept服务使用我们自定义的MySelfRule类进行负载均衡算法
 * MySelfRule这个类不可以放在@ComponentScan注解标记的类同包或者子包下
 * spring boot中@SpringBootApplication源码中自带ComponentScan这个注解，所以自定义的规则类不可以放在主启动
 * 类所以的包或者其子包下面
 */
//@RibbonClient(name="firstmaincloud-dept",configuration=MySelfRule.class)SSSSSSSSSSSS
public class DeptConsumer80_App {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
