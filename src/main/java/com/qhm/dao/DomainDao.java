package com.qhm.dao;

import java.util.List;

import com.qhm.pojo.Domain;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年2月18日 上午9:17:04 

* 类说明 

*/
public interface DomainDao {

	//持久层添加方法
	int inserDomain(Domain domain);
	//持久层查询方法
	List<Domain> listDomainBytime();
	//持久层删除方法
	int deleteDomainByid (String ids);
	
	
	
	
	
	
}
