package com.qhm.cms.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qhm.dao.ArticleDao;
import com.qhm.dao.CmsRepository;
import com.qhm.pojo.Article;

/** 
* @author 作者:wangmengbo
* @version 创建时间：2020年2月12日 下午4:48:17 
* 类功能说明 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class EsTest {
	@Resource
	private ElasticsearchTemplate es;
	@Resource
	ArticleDao dao;
	@Resource
	CmsRepository cr;
	@Test
	public void insert() {
		List<Article> list=dao.selectByHot();
		System.out.println(list);
		cr.saveAll(list);
	}
	
	
	
	
	
}
