package com.xmut.olt.seventh.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import com.xmut.olt.seventh.entity.Admin;
import com.xmut.olt.seventh.entity.Answer;
import com.xmut.olt.seventh.entity.EPaper;
import com.xmut.olt.seventh.entity.EPaperDetail;
import com.xmut.olt.seventh.entity.Option;
import com.xmut.olt.seventh.entity.QItem;
import com.xmut.olt.seventh.entity.QType;
import com.xmut.olt.seventh.entity.SType;
import com.xmut.olt.seventh.entity.StuPaper;
import com.xmut.olt.seventh.entity.StuPaperDetail;
import com.xmut.olt.seventh.entity.Student;
import com.xmut.olt.seventh.entity.Subject;
import com.xmut.olt.seventh.entity.Teacher;
import com.xmut.olt.seventh.tool.Md5Util;
import com.xmut.olt.seventh.repository.AdminRepository;
import com.xmut.olt.seventh.repository.StudentRepository;
import com.xmut.olt.seventh.service.AdminService;
import com.xmut.olt.seventh.service.AnswerService;
import com.xmut.olt.seventh.service.EPaperDetailService;
import com.xmut.olt.seventh.service.EPaperService;
import com.xmut.olt.seventh.service.OptionService;
import com.xmut.olt.seventh.service.QItemService;
import com.xmut.olt.seventh.service.QtypeService;
import com.xmut.olt.seventh.service.STypeService;
import com.xmut.olt.seventh.service.StuPaperDetailService;
import com.xmut.olt.seventh.service.StuPaperService;
import com.xmut.olt.seventh.service.StudentService;
import com.xmut.olt.seventh.service.SubjectService;
import com.xmut.olt.seventh.service.TeacherService;


public class SSSPTest {
	
	private ApplicationContext ctx = null;
	private EntityManagerFactory entityManagerFactory;
	private AdminRepository adminRepository;
	private AdminService adminService;

	private StudentRepository studentRepository;
	private AnswerService answerService;

	private StudentService studentService;
	private TeacherService teacherService;
	private QtypeService qtypeService;
	private STypeService sTypeService;
	private SubjectService subjectService;
	
	private QItemService qItemService;
	
	private EPaperService ePaperService;
	private EPaperDetailService detailService;
	private StuPaperService stuPaperService;
	private StuPaperDetailService stuPaperDetailService;
	private OptionService optionService;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
		adminRepository = ctx.getBean(AdminRepository.class);
		adminService = ctx.getBean(AdminService.class);
		studentRepository=ctx.getBean(StudentRepository.class);
		studentService=ctx.getBean(StudentService.class);
		teacherService=ctx.getBean(TeacherService.class);
		qtypeService=ctx.getBean(QtypeService.class);
		sTypeService=ctx.getBean(STypeService.class);
		subjectService=ctx.getBean(SubjectService.class);
		qItemService=ctx.getBean(QItemService.class);
		ePaperService=ctx.getBean(EPaperService.class);
		detailService=ctx.getBean(EPaperDetailService.class);
		stuPaperService=ctx.getBean(StuPaperService.class);
		stuPaperDetailService=ctx.getBean(StuPaperDetailService.class);
		optionService=ctx.getBean(OptionService.class);
		answerService=ctx.getBean(AnswerService.class);
	}
	
	@Test
	public void changeScore() {
		EPaper ePaper = ePaperService.getByeid(53);
		Page<StuPaper> byePaperOne = stuPaperService.getByePaperOne(ePaper, 1);
		System.out.println(byePaperOne.hasContent());
//		if(byePaperOne.getNumber()==0) {
//			System.out.println("null");
//		}
//		else 
//		{
//			System.out.println("not null");
//			System.out.println(byePaperOne.getContent().get(0));
//		}
//		StuPaper stuPaper = byePaperOne.getContent().get(0);
//		System.out.println(byePaperOne.getTotalPages());
//		Page<StuPaperDetail> bystuPaperOne = stuPaperDetailService.getBystuPaperDetailOne(stuPaper, 1);
//		for (StuPaperDetail stuPaperDetail : bystuPaperOne) {
//			System.out.println(stuPaperDetail.getqItem().getsType().getqType().getQtname());
//		}
	}
	
	@Test
	public void deletestupaper() {
		StuPaper byspid = stuPaperService.getByspid(21);
		boolean deleteStuPaperDetail = stuPaperDetailService.deleteStuPaperDetail(byspid);
		List<StuPaperDetail> bystuPaper = stuPaperDetailService.getBystuPaper(byspid);
		for (StuPaperDetail stuPaperDetail : bystuPaper) {
			System.out.println(stuPaperDetail.toString());
		}
		System.out.println(byspid);
	}
	
	@Test
	public void getBysName() {
//		Student bysName = studentService.getBysName("123");
//		if(bysName==null) 
//		{
//			System.out.println("null");
//		}else {
//			System.out.println("1");
//		}
	}
	
	@Test
	public void getEPScore() {
		EPaper byeid = ePaperService.getByeid(34);
		Page<StuPaper> finAllStuPaper = stuPaperService.finAllStuPaper(byeid);
		for (StuPaper stuPaper : finAllStuPaper) {
			System.out.println(stuPaper.getSpscore());
		}
	}
	@Test
	public void saveUser() 
	{
//		Teacher teacher=new Teacher();
//		teacher.settName("1221");
//		teacher.settNum("1221");
//		teacher.settPwd("1221");
//		teacher.settCreateTime(new Date());
//		teacher.settEmail("1269412851@qq.com");
//		teacher.settGender("男");
		Teacher teacher = teacherService.getTeacher("1221");
		teacher.settPwd(Md5Util.MD5("1221", "1221"));
		teacherService.save(teacher);
	}
	
	@Test
	public void countNum() {
		EPaper byeid = ePaperService.getByeid(38);
		System.out.println(byeid);
		Page<EPaperDetail> finallEPaperDetail = detailService.finallEPaperDetail(byeid);
		System.out.println(finallEPaperDetail.getNumberOfElements());
		Integer score=0;
		for (EPaperDetail ePaperDetail : finallEPaperDetail) {//遍历试卷下的题目
			score+=ePaperDetail.getqItem().getQiscore();
		}
		System.out.println(score);
	}
	
	@Test
	public void saveQitem() {
		Teacher teacher = teacherService.getTeacher("1221");
		SType bystid = sTypeService.getBystid(21);
		int j=10;
		for(int i=0;i<60;i++) {
			if(j==20) {
				j=10;
			}
			QItem item=new QItem(i+"", j++, "0", teacher, bystid);
			qItemService.save(item);
		}
	}
	
	@Test
	public void saveStuPaperDetail() 
	{
		StuPaper byspid = stuPaperService.getByspid(1);
		EPaper ePaper = byspid.getePaper();
		int i=0;
		Page<EPaperDetail> finallEPaperDetail = detailService.finallEPaperDetail(ePaper);
		for (EPaperDetail ePaperDetail : finallEPaperDetail) {
			QItem getqItem = ePaperDetail.getqItem();
			StuPaperDetail stuPaperDetail=new StuPaperDetail("1", i++, getqItem, byspid);
			stuPaperDetailService.save(stuPaperDetail);
			System.out.println(stuPaperDetail);
		}
	}
	
	@Test
	public void saveStuPaper() 
	{
		QItem byqiid = qItemService.getByqiid(41);
		System.out.println(byqiid);
		
		Answer answer= answerService.findOneAnswer(byqiid);
		System.out.println(answer);
		//查询学生试卷下的答案
//		List<Option> list=new ArrayList<Option>();
//		StuPaper stuPaper = stuPaperService.getByspid(4);
//		Page<StuPaperDetail> findStuPaper = stuPaperDetailService.findStuPaper(stuPaper);
//		System.out.println(findStuPaper.getNumber());
//		for (StuPaperDetail stuPaperDetail : findStuPaper) {
//			Page<Option> finqItem = optionService.finqItem(stuPaperDetail.getqItem());
//			for (Option stuPaperDetail2 : finqItem) {
//				System.out.println(stuPaperDetail2);
//				list.add(stuPaperDetail2);
//			}
//		}
//		System.out.println(list);
//		for (Option option : list) {
//			System.out.println(option);
//		}
		
		//添加12分钟
//		StuPaper stuPaper = stuPaperService.getByspid(2);
//		stuPaper.getDate().setTime((new Date().getTime()+12*60*1000));
//		stuPaperService.save(stuPaper);
		
		//查询当前时间与结束时间还有多久
//		StuPaper stuPaper = stuPaperService.getByspid(2);
//		Date date = stuPaper.getDate();
//		System.out.println(date);
//		System.out.println((date.getTime()-new Date().getTime())/60/1000-53);
//		System.out.println(((date.getTime()-new Date().getTime())/60/1000-53)<=-5);
		
		//保存
//		Student student = studentService.getStudent("1221");
//		EPaper byeid = ePaperService.getByeid(22);
//		StuPaper stuPaper=new StuPaper(0,byeid , student);
//		stuPaperService.save(stuPaper);
//		System.out.println("null"+stuPaper.getDate());
//		stuPaper.setDate(new Date());
//		stuPaperService.save(stuPaper);
//		System.out.println(stuPaper.getDate());
	}
	
	
	
	@Test
	public void EPaperPage(){
		Teacher teacher = teacherService.getTeacher("1221");
		Page<EPaper> findPagEPapers = ePaperService.findPagEPapers(teacher, 1);
		for (EPaper ePaper : findPagEPapers) {
			System.out.println(ePaper);
		}
	}
	
	@Test
	public void saveEPaperDetail() 
	{
		EPaper byename = ePaperService.getByename("测试试卷");
		QItem byqiid = qItemService.getByqiid(15);
		EPaperDetail detail=new EPaperDetail(byename, byqiid);
		detailService.save(detail);
		System.out.println(detail);
	}
	
	@Test
	public void saveEPaper() 
	{
		for (int i = 10; i < 13; i++) {
			Teacher teacher = teacherService.getTeacher("1221");
			EPaper ePaper=new EPaper("测试试卷"+i, 100, "0", 60, teacher, new Date());
			ePaperService.save(ePaper);
			System.out.println(ePaper);
		}
	}
	
	@Test
	public void getQI() 
	{
		SType findOneSType = sTypeService.findOneSType(4, 14);
//		System.out.println(findOneSType);
		Page<QItem> bySType = qItemService.getBySType(findOneSType, 1);
		for (QItem qItem : bySType) {
			System.out.println(qItem);
		}
	}
	
	@Test
	public void getSj() 
	{
			List<Subject> findAll = subjectService.findAll();
			for (Subject subject : findAll) {
				System.out.println(subject);
			}
	}
	@Test
	public void getSt() 
	{
		SType bystid = sTypeService.getBystid(1);
		SType findOneSType = sTypeService.findOneSType(4, 2);
		System.out.println(findOneSType);
			
	}
	
	
	@Test
	public void saveSt() 
	{
		QType qType=qtypeService.getByqitd(1);
		Subject subject=subjectService.getBysjid(1);
		SType sType=new SType(qType, subject);
		sTypeService.save(sType);
	}
	
	@Test
	public void getSub() 
	{
		Subject bysjid = subjectService.getBysjid(1);
		System.out.println(bysjid.getSjname());
	}
	
	@Test
	public void saveSub() 
	{
		Subject subject=new Subject("shu");
		subjectService.save(subject);
	}
	
	@Test
	public void getQt() 
	{
		QType byqitd = qtypeService.getByqitd(1);
		System.out.println(byqitd.getQtname());
	}
	
	@Test
	public void saveQt() 
	{
		QType qType=new QType("dan");
		qtypeService.sava(qType);
	}
	
	@Test
	public void getPageTeacher() {
//		Page<Teacher> page = teacherService.getPageAndtName("1",1);
		Page<Teacher> page = teacherService.getPageAndtNum("1", 1);
		for (Teacher student : page) {
			System.out.println(student);
		}
		System.out.println(page.getTotalElements());
	}
	
	@Test
	public void getPageStudent() {
		Page<Student> page = studentService.getPageAndsName("3",1);
//		Page<Student> page = studentService.getPageAndsNum("1", 1);
		for (Student student : page) {
			System.out.println(student);
		}
		System.out.println(page.getTotalElements());
	}
	
	@Test
	public void getStudent() 
	{
		Student student=studentRepository.getBysNum(123+"");
		System.out.println(student);
	}
	
	@Test
	public void saveStudent() 
	{
		for (int i = 21; i < 39; i++) {
			
			Student student=new Student();
//			student.setsId(studentRepository.getBysId(1).getsId());
			student.setsNum(i+"");
			student.setsCreateTime(new Date());
			student.setsPwd(Md5Util.MD5(student.getsNum().toString(), "111"));
			student.setsEmail("1269312851@qq.com");
			student.setsName("111");
			student.setsGender("男");
			studentRepository.saveAndFlush(student);
//			studentService.save(student);
		}
	}
	@Test
	public void checkAdmin() 
	{
		Admin admin=new Admin("admin", "admin");
//		System.out.println(adminService.loginCheck(admin));
	}
	
	@Test
	public void getAdmin() 
	{
//		Admin admin=adminRepository.getByaName("admin");
//		admin=adminRepository.getByaId(1);
//		admin.setaPwd(Md5Util.MD5("admin", "admin"));
//		adminRepository.saveAndFlush(admin);
		System.out.println(Md5Util.MD5("admin", "ywqolt"));
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

	@Test
	public void MD5() 
	{
		String str="1269412851@qq.com";
		String md51=com.xmut.olt.seventh.tool.MD5.convertMD5(str);
		String md52=com.xmut.olt.seventh.tool.MD5.convertMD5(md51);
		System.out.println("原："+str+",一次加密："+md51+",二次解密："+md52+","+str.equals(md52));
	}
	
}
