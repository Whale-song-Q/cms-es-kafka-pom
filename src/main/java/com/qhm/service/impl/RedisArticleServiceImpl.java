package com.qhm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.qhm.pojo.Article;
import com.qhm.service.RedisArticleService;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年2月17日 下午1:41:56 

* 类说明 

*/
@Service
public class RedisArticleServiceImpl implements RedisArticleService{

	@Autowired
	RedisTemplate<String, Article> redisTemplate;
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	
	@Override
	public boolean save(Article article) {
		// TODO Auto-generated method stub
		System.err.println("前端传到新bean的文章对象"+article);
		//获取String类型redis对象
		ValueOperations<String, Article> opsForValue = redisTemplate.opsForValue();
		
		opsForValue.set(article.getTitle(), article);
		//生产者发送消息给消费者
		kafkaTemplate.sendDefault("newArticle", article.getTitle());
		
		return true;
	}
	
	
	
	

}
