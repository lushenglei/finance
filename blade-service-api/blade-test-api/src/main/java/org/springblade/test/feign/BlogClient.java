package org.springblade.test.feign;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springblade.common.constant.CommonConstant;
import org.springblade.core.tool.api.R;
import org.springblade.test.entity.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
	//定义Feign指向的service-id
	value = CommonConstant.APPLICATION_TEST_NAME,
	fallback = BlogClientFallback.class
)
public interface BlogClient {
	/**
	 * 接口前缀
	 */
	String API_PREFIX = "/api/blog";

	@GetMapping(API_PREFIX + "/detail")
	R<Blog> detail(@RequestParam int id);

	@GetMapping(API_PREFIX + "/page")
	R<Page<Blog>> page(@RequestParam int pageNum, @RequestParam int pageSize);
}
