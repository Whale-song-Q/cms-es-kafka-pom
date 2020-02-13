package com.qhm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.qhm.common.CmsConstant;
import com.qhm.common.JsonResult;
import com.qhm.dao.ArticleDao;
import com.qhm.pojo.Article;
import com.qhm.pojo.Category;
import com.qhm.pojo.Channel;
import com.qhm.pojo.User;
import com.qhm.service.ArticleService;

@Controller
@RequestMapping("/article/")
public class ArticleController {
	
	
	@Autowired
	private ArticleService articleService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @Title: add   
	 * @Description: 发布文章   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Integer id,Model model) {
		Integer i=0;
		
		
		logger.info("articleId:{}",id);
		if(id!=null) {
			Article article = articleService.getById(id);
			logger.info(article.toString());
			model.addAttribute("article", article);
			List<Category> cateList = articleService.getCateListByChannelId(article.getChannelId());
			model.addAttribute("cateList", cateList);
		}
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		i++;
		//对文章点击进行监视被点击则热点加一
				if(i>0){
					articleService.addHot(id);
				}
		return "article/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(Article article,Model model,HttpSession session) {
		System.out.println(article);
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(CmsConstant.unLoginErrorCode, "未登录");
		}
		article.setUserId(userInfo.getId());
		boolean result = articleService.save(article);
		return JsonResult.sucess(result);
	}
	/**
	 * @Title: getCateList   
	 * @Description: 根据频道Id查询分类列表   
	 * @param: @param channelId
	 * @param: @param model
	 * @param: @param session
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping(value="getCateList",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult getCateList(Integer channelId,Model model,HttpSession session) {
		return JsonResult.sucess(articleService.getCateListByChannelId(channelId));
	}
	/**
	 * @Title: delByIds   
	 * @Description: 批量删除   
	 * @param: @param ids
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping("delByIds")
	public @ResponseBody JsonResult delByIds(String ids) {
		if(ids==null) {
			return JsonResult.fail(10001, "请选择删除的文章");
		}
		//已审核判断
		boolean isCheck = articleService.isAllCheck(ids);
		if(!isCheck) {
			return JsonResult.fail(10001, "请选择未审核的文章删除");
		}
		//删除
		boolean result = articleService.delByIds(ids);
		if(result) {
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "未知错误");
	}
	/*@Autowired
	ComplainService complainService;
	
	@RequestMapping("toToushu")
	public String toToushu(Integer articleid,Model m){
		System.err.println("后台跳转接收：articleid="+articleid);
		m.addAttribute("articleid",articleid);
		
		return "article/addComplain";
		
	}*/
	
	
/*	@RequestMapping("articleComplain")
	@ResponseBody
	public Object articleComplain(Complain complain,@RequestParam("carticleid") String articleid) {
		int articleids=Integer.parseInt(articleid);
		System.err.println("前台接收投诉对象"+complain+"articleid"+articleids);
		int i = complainService.insertComplain(complain,articleids);
		return i;
	}*/
	
}
