package com.qhm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhm.dao.DomainDao;
import com.qhm.pojo.Article;
import com.qhm.pojo.Domain;
import com.qhm.service.DomainService;
import com.quhaiming.common.utils.StringUtil;

/** 

* @author 作者 QHM: 

* @version 创建时间：2020年2月18日 上午9:13:08 

* 类说明 

*/
@Service
public class DomainServicemImpl implements DomainService{

	@Resource
	private DomainDao domainDao;
	
	@Override
	public boolean domainAdd(Domain domain) {
		
		boolean flag=true;
		if(StringUtil.HttpFirstUrl(domain.getUrl())){
			flag=domainDao.inserDomain(domain)>0;
			
		}else{
			
			System.err.println("收藏夹路径错误");
			flag=false;
		}

		return flag;
	}
	@Override
	public List<Domain> listDomainBytime() {
		
		List<Domain> listDomainBytime = domainDao.listDomainBytime();

		return listDomainBytime;
	}
	@Override
	public int deleteDomainByid(String ids) {
		// TODO Auto-generated method stub
		int deleteDomainByid=0;
		if(ids!=null){

			deleteDomainByid= domainDao.deleteDomainByid(ids);
		}
		return deleteDomainByid;
	}
	@Override
	public PageInfo<Domain> getPageInfo(Domain domain, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Domain> domainList = domainDao.listDomainBytime();
		return new PageInfo<>(domainList);
	}
	
	
	
}
