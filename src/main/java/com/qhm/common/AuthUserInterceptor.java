package com.qhm.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.qhm.pojo.User;
import com.qhm.service.UserService;
import com.quhaiming.common.utils.StringUtil;

public class AuthUserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object userInfo = request.getSession().getAttribute(CmsConstant.UserSessionKey);
		if(userInfo!=null) {
			return true;
		}
		//记住登录
		String cookieByName = CookieUtil.getCookieByName(request, "username");
		if(StringUtil.Blank(cookieByName)){
			UserService userservice = SpringBeanUtils.getBean(UserService.class);
			//单条用户信息
			userInfo = userservice.getByUsername(cookieByName);
			request.getSession().setAttribute(CmsConstant.UserSessionKey, userInfo);
			return true;
		}
	    response.sendRedirect("/user/login");
		return false;
	}

}
