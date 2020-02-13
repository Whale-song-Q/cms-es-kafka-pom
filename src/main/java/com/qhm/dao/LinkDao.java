package com.qhm.dao;

import java.util.List;

import com.qhm.pojo.Link;

/** 

* @author 作者 QHM: 

* @version 创建时间：2019年12月20日 下午7:23:46 

* 类说明 

*/
public interface LinkDao {

	
	List<Link> ListLink();
	int deleAll(String ids);
}
