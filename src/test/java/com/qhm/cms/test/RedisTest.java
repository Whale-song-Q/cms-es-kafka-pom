package com.qhm.cms.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 

* @author ���� QHM: 

* @version ����ʱ�䣺2020��1��3�� ����10:23:17 

* ��˵�� 

*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class RedisTest {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	/**
	 * String ����
	 */
	
	@Test
	public void testString(){
		
		
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		 Set<String> keys = redisTemplate.keys("name");
		 for (String string : keys) {
			
			 System.err.println(string);
		}
		/*if(keys!=null){
		for (String string : keys) {System.err.println("遍历keys："+string);}
		}else{
			
			System.err.println("key值为空");
		}*/
/*		opsForValue.set("name", "张三");
		Object object = opsForValue.get("name");
		System.out.println(object);*/
		
		
	}
	@Test
	public void testList(){
		
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		
		List li = new ArrayList();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		opsForList.leftPushAll("list", li);
		List<Object> list = opsForList.range("list", 0, -1);
		for (Object object : list) {
			System.out.print(object+",");
		}
		
		
		
		
	}
	@Test
	public void testSet(){
		
		SetOperations<String, Object> opsForSet = redisTemplate.opsForSet();
		opsForSet.add("ss", 1,2,3,4,5,6,7,8,9);
		Set<Object> set = opsForSet.members("ss");
		for (Object object : set) {
			System.out.print(object+",");
		}
	}
	@Test
	public void testHash(){
		HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
		Map map=new HashMap();
		
		map.put("name", "����");	
		map.put("age", 20);
		map.put("addr", "����");
		opsForHash.putAll("student", map);
		
		Map<Object, Object> map2 = opsForHash.entries("student");
		
		Set<Entry<Object, Object>> entrySet = map2.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.print(entry+",");
		}
		
	}
	@Test
	public void testZSet(){
		
		ZSetOperations<String, Object> opsForZSet = redisTemplate.opsForZSet();
		
		opsForZSet.add("math", "小红", 100);
		opsForZSet.add("math", "小绿", 50);
		opsForZSet.add("math", "С��", 80);
		Set<TypedTuple<Object>> set = opsForZSet.rangeWithScores("math", 0, -1);
		
		for (TypedTuple<Object> typedTuple : set) {
			System.out.println(typedTuple.getValue()+"=="+typedTuple.getScore());
		}
		
		
		
	}
	
	
}
