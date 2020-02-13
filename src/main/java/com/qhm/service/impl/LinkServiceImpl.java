package com.qhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qhm.dao.LinkDao;
import com.qhm.pojo.Link;
import com.qhm.service.LinkService;

/** 

* @author 作者 QHM: 

* @version 创建时间：2019年12月20日 下午7:25:33 

* 类说明 

*/
@Transactional
@Service
public class LinkServiceImpl implements LinkService{

	@Autowired
	LinkDao linkdao;
	
	@Override
	public List<Link> ListLink() {
		// TODO Auto-generated method stub
		return linkdao.ListLink();
	}

	@Override
	public int deleAll(String ids) {
		// TODO Auto-generated method stub
		return linkdao.deleAll(ids);
	}

}
