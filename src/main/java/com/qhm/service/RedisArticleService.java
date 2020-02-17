package com.qhm.service;

import com.qhm.pojo.Article;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年2月17日 下午1:43:43 

* 类说明 

*/
public interface RedisArticleService {

	
	/**
	 * @Title: save   
	 * @Description: 保存或修改文章 
	 * @param: @param article
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	boolean save(Article article);
	
	
	
	
}
