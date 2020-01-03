package com.mybatis.plus.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="demo",url="${conf.address.demo}",fallbackFactory=DemoFeignClientFB.class)
public interface DemoFeignClient {
	
	@RequestMapping("cmpOclOrder/demoFeign")
	public String testFeign();

}