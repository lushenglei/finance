package org.springblade.test.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springblade.core.tool.api.R;
import org.springblade.test.entity.Blog;

import java.time.LocalDateTime;

public class BlogClientFallback implements BlogClient{
	@Override
	public R<Blog> detail(int id) {
		Blog blog = new Blog();
		blog.setBlogContent("FallBack Success");
		blog.setBlogDate(LocalDateTime.now());
		blog.setIsDeleted(0);
		blog.setBlogTitle("Hystrix");
		return R.data(blog);
	}

	@Override
	public R<Page<Blog>> page(int pageNum, int pageSize) {
		return null;
	}
}
