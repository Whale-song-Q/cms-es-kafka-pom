package com.qhm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qhm.common.CmsConstant;
import com.qhm.common.JsonResult;
import com.qhm.pojo.Tousu;
import com.qhm.pojo.User;
import com.qhm.service.TousuService;


@Controller
@RequestMapping("/tousu/")
public class tousuController {
	@Autowired
	private TousuService tousuService;
	/**
	 * @Title: add   
	 * @Description: 添加评论 
	 * @param: @param comment
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	public @ResponseBody JsonResult add(Tousu tousu,HttpSession session) {
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(CmsConstant.unLoginErrorCode, "用户未登录");
		}
		
		tousu.setUserId(userInfo.getId());
		
		boolean result = tousuService.add(tousu);
		if(result) {
			return JsonResult.sucess();
		}
		return JsonResult.fail(10000, "未知错误");
	}
}
