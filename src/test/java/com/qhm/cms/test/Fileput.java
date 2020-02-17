package com.qhm.cms.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qhm.pojo.Article;
import com.qhm.service.RedisArticleService;
import com.quhaiming.common.utils.FileUtil;
import com.quhaiming.common.utils.RandomUtil;

import scala.collection.parallel.ParIterableLike.Foreach;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年2月13日 下午7:56:22 

* 类说明 

*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class Fileput {

	@Resource
	KafkaTemplate<String, String> kafkaTemplate;
	@Resource
	RedisArticleService redisArticleServiceImpl;
	@Test
	public void FileTest(){
		
		List<String> filelist = FileUtil.readFileUrl("D:/1709DJsoup");
		
		
		for (String string : filelist) {
			String[] split = string.split("@@");
			
			Article article = new Article();
			String title = split[0].replace(".txt"," ");
			article.setTitle(title);
			article.setPicture("/pic/image/20191223/20191223090900_848.jpeg");
			article.setContent(split[1]);
			article.setHits(RandomUtil.random(0, 100));
			article.setHot(RandomUtil.random(0, 100));
			article.setChannelId(2);
			article.setCategoryId(4);
			article.setUserId(153);
			article.setCreated(new Date());
			article.setStatus(2);
			article.setDeleted(0);
			redisArticleServiceImpl.save(article);
			
			
			
			
		}
		
	}
	
	
	
	
	
	
	
	
}
