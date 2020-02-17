package com.qhm.cms.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年1月8日 上午10:58:49 

* 类说明 

*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-kafka-producer.xml")
public class KafkaSpring {
	
	@Resource
	KafkaTemplate<String,String> kafkatemplate;
	
	
	@Test
	public void sendMsg(){
		
		String msg="hello Spring,I'm Kafka";
		kafkatemplate.sendDefault("abc", msg);
		System.out.println("发送完毕！！！奥利给！");
		
		
		
		
	}
	
	
	
	
	
	
}
