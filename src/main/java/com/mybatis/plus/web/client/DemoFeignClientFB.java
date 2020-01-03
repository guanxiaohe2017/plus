package com.mybatis.plus.web.client;

import feign.hystrix.FallbackFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoFeignClientFB implements FallbackFactory<DemoFeignClient> {
	private static Log logger = LogFactory.getLog(DemoFeignClientFB.class);

	@Override
	public DemoFeignClient create(Throwable throwable) {
		return new DemoFeignClient() {
			@Override
			public String testFeign() {
				return "demo系统接口调用失败";
			}
		};
	}
}