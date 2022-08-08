package org.springblade.test.config;

import org.springblade.test.feign.BlogClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign失败配置
 */
@Configuration
public class BlogFeignConfiguration {

	@Bean
	public BlogClientFallback blogClientFallback() {
		return new BlogClientFallback();
	}
}
