package com.qhm.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qhm.dao.UserDao;
import com.qhm.pojo.Article;
import com.qhm.pojo.Category;
import com.qhm.pojo.Channel;
import com.qhm.pojo.Settings;
import com.qhm.pojo.Slide;
import com.qhm.pojo.Tag;
import com.qhm.pojo.User;

/** 

* @author 作者 QHM: 

* @version 创建时间：2019年12月10日 下午7:05:30 

* 类说明 

*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring-beans.xml")
public class UserTest {

	@Autowired
	private UserDao userdao;
	
/*//用户表测试	
		@Test
		public void select(){
			
			User user = new User();
			List<User> userlist = userdao.select(user);
			for (User user2 : userlist) {
				System.out.println(user2);
			}
			
		}
//频道表测试	
		@Test
		public void Channelselect(){
			
		Channel channel = new Channel();
		  	List<Channel> Channellist = userdao.Channelselect(channel);
			for (Channel Ch : Channellist) {
				System.out.println(Ch);
			}
			int i = userdao.Channelcount(channel);
			System.err.println(i);
		}
//分类表测试
		@Test
		public void Categoryselect(){
			
			Category category = new Category();
		//	List<Category> categorylist = userdao.Categoryselect(category);
		//	for (Category Ch : categorylist) {
		//	System.out.println(Ch);
		//		}
			int i = userdao.Categorycount(category);
			System.err.println(i);
		}
	
//	文章表测试
	     @Test
		public void Articleselect(){
			
		    Article article = new Article();
		    List<Article> articlelist = userdao.Articleselect(article);
			for (Article Ch : articlelist) {
				System.out.println(Ch);
			}
			int i = userdao.Articlecount(article);
			System.err.println(i);
		}
//标签表测试
	     @Test
		public void Tagselect(){
			
	    	 Tag tag = new Tag();
		    List<Tag> Taglist = userdao.Tagselect(tag);
			for (Tag Ch : Taglist) {
				System.out.println(Ch);
			}
			int i = userdao.Tagcount(tag);
			System.err.println(i);
		}	     
//标签表测试
	     @Test
		public void Slideselect(){
			
	    	 Slide slide = new Slide();
	    	  List<Slide> slidelist = userdao.Slideselect(slide);
			for (Slide Ch : slidelist) {
				System.out. println(Ch);
			}
		int i = userdao.Slidecount(slide);
			System.err.println(i);
		}	     
//设置表测试
	     @Test
		public void Settingsselect(){
			
	    	 Settings settings = new Settings();
	    	 List<Settings> Settingslist = userdao.Settingsselect(settings);
			for (Settings Ch : Settingslist) {
				System.out. println(Ch);
			}
		int i = userdao.Settingscount(settings);
			System.err.println(i);
		}
	     
	     
	     
	     
	     */
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     

}
