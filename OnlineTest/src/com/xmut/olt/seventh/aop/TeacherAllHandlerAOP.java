package com.xmut.olt.seventh.aop;

import java.security.Key;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xmut.olt.seventh.entity.Teacher;
import com.xmut.olt.seventh.tool.RSACoder;

@Component
@Aspect
public class TeacherAllHandlerAOP {

	@After("execution(* com.xmut.olt.seventh.handler.TeacherManagePageHandler.*(..)) || execution(* com.xmut.olt.seventh.handler.TeacherHandler.*(..))")
	public void checkLogin(JoinPoint joinPoint) throws Exception 
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		Teacher teacher=(Teacher) session.getAttribute("teacher");
		if(teacher==null) 
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
