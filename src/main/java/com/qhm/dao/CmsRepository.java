package com.qhm.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qhm.pojo.Article;


/** 
* @author 作者:qhm
* @version 创建时间：2020年2月11日 下午5:41:23 
* 类功能说明 
*/
public interface CmsRepository extends ElasticsearchRepository<Article, Integer>{

	List<Article> findByTitle(String string);
	
	Article save(Article article);
	
}
