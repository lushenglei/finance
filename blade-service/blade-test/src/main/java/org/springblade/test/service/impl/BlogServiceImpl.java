package org.springblade.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.test.entity.Blog;
import org.springblade.test.mapper.BlogMapper;
import org.springblade.test.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
}
