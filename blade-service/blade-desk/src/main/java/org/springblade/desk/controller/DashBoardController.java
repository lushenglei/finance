package org.springblade.desk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.support.Kv;
import org.springblade.test.entity.Blog;
import org.springblade.test.feign.BlogClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页
 *
 * @author zhuangqian
 */
@RestController
@RequestMapping("dashboard")
@AllArgsConstructor
@Api(value = "首页", tags = "首页")
public class DashBoardController {


	private BlogClient blogClient;
	/**
	 * 活跃用户
	 *
	 * @return
	 */
	@GetMapping("/activities")
	@ApiOperation(value = "活跃用户", notes = "活跃用户")
	public R activities() {

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>(16);
		map1.put("id", "trend-1");
		map1.put("updatedAt", "2019-01-01");
		map1.put("user", Kv.init().set("name", "曲丽丽").set("avatar", "https://gw.alipayobjects.com/zos/rmsportal/ThXAXghbEsBCCSDihZxY.png"));
		map1.put("group", Kv.init().set("name", "高逼格设计天团").set("link", "http://github.com/"));
		map1.put("project", Kv.init().set("name", "六月迭代").set("link", "http://github.com/"));
		map1.put("template", "在 @{group} 新建项目 @{project}");
		list.add(map1);

		Map<String, Object> map2 = new HashMap<>(16);
		map2.put("id", "trend-2");
		map2.put("updatedAt", "2019-01-01");
		map2.put("user", Kv.init().set("name", "付小小").set("avatar", "https://gw.alipayobjects.com/zos/rmsportal/ThXAXghbEsBCCSDihZxY.png"));
		map2.put("group", Kv.init().set("name", "高逼格设计天团").set("link", "http://github.com/"));
		map2.put("project", Kv.init().set("name", "七月月迭代").set("link", "http://github.com/"));
		map2.put("template", "在  @{group} 新建项目 @{project}");
		list.add(map2);

		return R.data(list);
	}

	@GetMapping("/blog-detail")
	public R<Blog> blogDetail(int id){

      return blogClient.detail(id);
	}

	@GetMapping("/blog-page")
	public R<Page<Blog>> blogPage(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){

		return blogClient.page(pageNum,pageSize);
	}
}
