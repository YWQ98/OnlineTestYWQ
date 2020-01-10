package com.xmut.olt.seventh.handler;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xmut.olt.seventh.page.StaticPage;
import com.xmut.olt.seventh.service.QItemService;
import com.xmut.olt.seventh.service.StudentService;
import com.xmut.olt.seventh.service.TeacherService;
/**
 *控制类
 * @author 叶文清
 * @since 2019年1月2日
 */
@Controller
public class IndexHandler {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private QItemService qItemService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		String view=StaticPage.INDEX;
		ServletContext servletContext = request.getServletContext();
		if(servletContext.getAttribute("countTeacher")==null) {
			long countTeacher = teacherService.count();
			long countStudent = studentService.count();
			long countQItem = qItemService.count();
			servletContext.setAttribute("countTeacher", countTeacher);
			servletContext.setAttribute("countStudent", countStudent);
			servletContext.setAttribute("countQItem", countQItem);
		}
		return view;
	}
	
}
