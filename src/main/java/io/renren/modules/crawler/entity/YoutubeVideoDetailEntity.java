package io.renren.modules.crawler.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 油管视频实体
 * @author LeonXi
 * @date 2019-04-10 11:35
 * 
 * 【表相关数据】
 * Id:视频ID
 *  
 * videoId:视频主表ID
 * 
 * quality:
 * 		1080p (HD)
 * 
 * format:
 * 		MP4
 * 
 * size:
 * 		332.05MB
 * 
 * downloads:
 * 
 * has_sound: 0(Download Video without Sound) / 1(Download Video with Sound)
 * 
 * video_order:排序
 * 
 * create_date:
 * 
 * is_show: 是否显示
 * 
 * is_downloaded:是否下载
 * 
 *  is_default:0(不默认) / 1(默认)
 * 
 * del_flag:删除标志
 */
@TableName("tb_youtube_video_detail")
public class YoutubeVideoDetailEntity implements Serializable {
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
