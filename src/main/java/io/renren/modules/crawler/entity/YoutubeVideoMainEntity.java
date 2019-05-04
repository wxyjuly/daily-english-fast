package io.renren.modules.crawler.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 油管视频主表实体
 * @author LeonXi
 * @date 2019-04-10 11:35
 * 
 * 【表相关数据】
 * 
 * videoId:视频ID
 * 		
 * title:视频标题   
 * 		Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus
 * 
 * video_image: 图片名称
 * 		Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.jpg
 * 
 * video_image_url: 图片地址 
 * 		https://i.ytimg.com/vi/E7rdLT2xs9o/maxresdefault.jpg
 * 
 * video_count:视频数量
 * 
 * del_flag:删除标志
 * 
 * create_date:
 * 
 * is_show:
 * 
 * is_downloaded:
 * 
 * 
 */
@TableName("tb_youtube_video_main")
public class YoutubeVideoMainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 视频ID
	 */
	@TableId
	private Long videoId;
	
	
	
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long videoId) {
		this.videoId = videoId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return videoId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
