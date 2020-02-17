package com.qhm.cms.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年1月8日 上午11:17:56 

* 类说明 

*/
public class ConsumerTest {

	
	public static void main(String[] args) {
		
		System.out.println("进入");
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("spring-beans.xml");
		System.out.println("消费者启动完成");
		
	}
	
	
	
	
}
