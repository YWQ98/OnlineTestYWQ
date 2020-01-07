package com.xmut.olt.seventh.aop;

import java.security.Key;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xmut.olt.seventh.entity.Admin;
import com.xmut.olt.seventh.tool.RSACoder;

@Component
@Aspect
public class AdminAllHandlerAOP {

	@Before("execution(* com.xmut.olt.seventh.handler.AdminManagePageHandler.*(..))")
	public void checkLogin(JoinPoint joinPoint) throws Exception 
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		Admin admin=(Admin) session.getAttribute("admin");
		if(admin==null) 
		{
			if(session.getAttribute("publicKey")==null) //秘钥生成
			{
				Map<String, Key> keyMap=RSACoder.initKey();
				session.setAttribute("keyMap", keyMap);
				session.setAttribute("publicKey", RSACoder.getPublicKey(keyMap));
			}
		}
	}
	@Before("execution(* com.xmut.olt.seventh.handler.AdminHandler.loginRegister(..))")
	public void loginRegister(JoinPoint joinPoint) throws Exception 
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		Admin admin=(Admin) session.getAttribute("admin");
		if(admin==null) 
		{
			if(session.getAttribute("publicKey")==null) //秘钥生成
			{
				Map<String, Key> keyMap=RSACoder.initKey();
				session.setAttribute("keyMap", keyMap);
				session.setAttribute("publicKey", RSACoder.getPublicKey(keyMap));
			}
		}
	}	

}
