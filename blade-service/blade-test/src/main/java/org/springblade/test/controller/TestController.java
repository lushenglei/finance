package org.springblade.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.test.entity.Blog;
import org.springblade.test.service.BlogService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class TestController {

	private BlogService blogService;

	@GetMapping("test/{name}")
	@PreAuth("hasRole('administrator')")
	@Cacheable(cacheNames = "test-name", key = "#name")
	public R getName(@PathVariable("name") String name) {
		System.out.println("没有走缓存");
		return R.data("Hello " + name + "!!!");
	}

	@GetMapping("count")
	@PreAuth("permitAll()")
	public R count(int num) {

		return R.data(num * 10);
	}

	@GetMapping("remove-info")
	@PreAuth("hasRole('administrator')")
	@CacheEvict(cacheNames = "test-name", key = "#name")
	public R<String> removeInfo(String name) {
		return R.success("删除缓存成功");
	}

	@PostMapping("/save")
	public R save(@RequestBody Blog blog) {

		return R.status(blogService.save(blog));
	}

	@PutMapping("/update")
	public R update(@RequestBody Blog blog) {

		return R.status(blogService.updateById(blog));
	}

	@DeleteMapping("/delete")
	public R delete(@RequestParam String ids) {

		return R.status(blogService.removeByIds(Func.toIntList(ids)));
	}

	@GetMapping("/detail")
	public R<Blog> detail(int id) {

		return R.data(blogService.getById(id));
	}

	@GetMapping("/list")
	public R<List<Blog>> list(@RequestParam Map<String,Object> blog) {

		return R.data(blogService.list(Condition.getQueryWrapper(blog,Blog.class).lambda().orderByDesc(Blog::getBlogDate)));
	}

	@GetMapping("/page")
	public R<IPage<Blog>> page(@RequestParam Map<String,Object> blog, Query query){
		return R.data(blogService.page(Condition.getPage(query),Condition.getQueryWrapper(blog,Blog.class)));
	}

}
