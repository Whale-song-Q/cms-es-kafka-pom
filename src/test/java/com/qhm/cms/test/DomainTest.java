package com.qhm.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qhm.dao.DomainDao;
import com.qhm.pojo.Domain;

/** 
* @author 作者:qhm
* @version 创建时间：2020年2月12日 下午4:48:17 
* 类功能说明 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class DomainTest {

	
	@Autowired
	DomainDao domainDao;
	
	
	
	
	@Test
	public void list() {
		
		List<Domain> listDomainBytime = domainDao.listDomainBytime();
			for (Domain domain : listDomainBytime) {
				System.err.println(domain);
			}
			


		
		
	}
	
	
	
	
	
}
