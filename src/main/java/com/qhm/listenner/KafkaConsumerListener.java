package com.qhm.listenner;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

import com.qhm.dao.ArticleDao;
import com.qhm.pojo.Article;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年1月8日 上午11:07:03 

* 类说明 

*/
@Component
public class KafkaConsumerListener implements MessageListener<String, String>{

	@Resource
	ArticleDao articleDao;
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		// TODO Auto-generated method stub
		
		if(data.key()!=null && data.key().equals("cmsArticleAdd")){
			
			String article = data.value();
			String[] split = article.split("\\@\\@");
			Article article2 = new Article();
			article2.setTitle(split[0]);
			article2.setContent(split[1]);
			//添加到mysql
			 articleDao.insert(article2);
		}else if(data.key()!=null &&data.key().equals("looksome")){
			
			String id = data.value();
			
			articleDao.updateHitsByid(id);
			
			
		}
	}

}
