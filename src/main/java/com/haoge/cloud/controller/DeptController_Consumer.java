package com.haoge.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.haoge.cloud.entities.Dept;

/**
 * @author 李东浩
 * @Date：2018年4月29日下午3:22:47
 *
 */
@RestController
public class DeptController_Consumer {
	private static final String REST_URL_PREFIX = "http://localhost:8001";
//	private static final String REST_URL_PREFIX = "http://firstmaincloud-dept";

	@Autowired
	private RestTemplate template;
	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return template.postForObject(REST_URL_PREFIX + "/dept/add", dept, boolean.class);
	}
	/**
	 * 根据ID查询部门的方法
	 * 
	 * @param dept
	 * @return
	 */
	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return template.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}
	/**
	 * 查询列表的方法
	 * 
	 * @param dept
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		
		return template.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}
	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return template.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
}
