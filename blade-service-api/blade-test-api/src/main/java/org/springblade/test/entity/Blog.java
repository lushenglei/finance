package org.springblade.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("yw_blog")
public class Blog implements Serializable {

	private static final long serialVersionUID = -5574481198923422736L;
	/**
	 * 主键
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;

	/**
	 * 标题
	 */
	private String blogTitle;

	/**
	 * 内容
	 */
	private String blogContent;

	/**
	 * 时间
	 */
	private LocalDateTime blogDate;

	/**
	 * 是否已删除
	 */
	@TableLogic
	private Integer isDeleted;
}
