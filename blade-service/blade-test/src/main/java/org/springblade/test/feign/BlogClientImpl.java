package org.springblade.test.feign;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.test.entity.Blog;
import org.springblade.test.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class BlogClientImpl implements BlogClient{

	private BlogService blogService;

	@Override
	@GetMapping(API_PREFIX+"/detail")
	public R<Blog> detail(int id) {
		int i=100/0;
		return R.data(blogService.getById(id));
	}

	@Override
	@GetMapping(API_PREFIX+"/page")
	public R<Page<Blog>> page(int pageNum,int pageSize) {
		Page page = new Page(pageNum,pageSize);
		return R.data(blogService.page(page));
	}
}
