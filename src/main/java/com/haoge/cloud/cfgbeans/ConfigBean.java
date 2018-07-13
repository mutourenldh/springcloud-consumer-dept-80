package com.haoge.cloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** 
* @author 李东浩
* @Date：2018年4月29日下午3:19:15
*
*/
@Configuration //@Configuration配置   ConfigBean = applicationContext.xml
public class ConfigBean {
	@Bean
//	@LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
	//@LoadBalanced内置7种不同的负载均衡的算法，如果我们不显示的申明我们想要的算法，就使用默认的轮训算法。
	//如果我们显示的声明我们需要的算法，则会替代默认的轮训算法
	public RestTemplate getRestTemplete() {
		return new RestTemplate();
	}
//如果我们要显式的指定自己想要的算法，则改变返回算法的名字即可。例子如下
//	@Bean
//	public IRule myRule(){
//		//return new  RetryRule();//如果服务提供者全部可用，则和轮训算法一样。当某一个服务不可用的时候
//								//查询该服务不可用几次之后，自动的不会再次查找该服务。在剩下的服务中进行轮训	
//		
//			return new RandomRule();//随机算法。达到的目的，用我们重新选择的随机算法替代默认的轮询。
//	}
}
