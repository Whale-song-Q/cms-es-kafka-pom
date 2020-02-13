package com.qhm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhm.dao.TousuDao;
import com.qhm.pojo.Tousu;
import com.quhaiming.common.utils.DateUtil;
@Service
public class TousuService {
	@Autowired
	private TousuDao tousuDao;
	@Autowired
	private ArticleService articleService;
	/**
	 * @Title: add   
	 * @Description: 添加投诉 
	 * @param: @param comment
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean add(Tousu tousu) {
		String createdStr = DateUtil.dateTimeFormat.format(new Date());
		tousu.setCreated(createdStr);
		tousuDao.insert(tousu);
		articleService.addTousu(tousu.getArticleId());
		return true;
	}
}
