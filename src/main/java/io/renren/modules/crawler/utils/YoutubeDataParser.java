package io.renren.modules.crawler.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import io.renren.data.ImageDownloadInfoData;

/**
 * @author 作者  Administrator
 * ==============================================================
 * @version 1.0.0
 * @projectName renren-fast
 * @packageName io.renren.modules.crawler.util
 * @createTime 2019年4月10日
 * @title 解析https://qdownloader.net/download?video=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DE7rdLT2xs9o数据
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @copyright Copyright (c) 2018 中石油天然气股份有限公司规划总院
 * @company 中石油天然气股份有限公司规划总院
 * @module 模块: 模块名称
 * @reviewer 审核人 Administrator
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class YoutubeDataParser {
	
	public static void main(String[] args) {
		
		String html = ImageDownloadInfoData.testParseData;
		Document doc = Jsoup.parse(html);
		
		System.out.println(doc);
	}
}
