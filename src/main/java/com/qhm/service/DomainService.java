package com.qhm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qhm.pojo.Domain;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年2月18日 上午9:08:14 

* 类说明 

*/
public interface DomainService {

	
	//收藏夹添加方法
	boolean domainAdd(Domain domain);
	
	//收藏夹按时间倒叙查询方法
	List<Domain> listDomainBytime();
	
	//收藏夹通过id删除
	int deleteDomainByid(String ids);
	
	PageInfo<Domain> getPageInfo(Domain domain, int pageNum, int pageSize);
	
	
	
	
	
	
	
}
