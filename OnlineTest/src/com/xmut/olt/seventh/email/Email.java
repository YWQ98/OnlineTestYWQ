package com.xmut.olt.seventh.email;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;

public class Email {

	public static boolean sendEmail(String emailaddress,String code){
		try {
			HtmlEmail email = new HtmlEmail();//不用更改
			email.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
			email.setCharset("UTF-8");
			email.addTo(emailaddress);// 收件地址
 
			email.setFrom("1269412851@qq.com", "在线考试系统网址：olt.wapin.xin");//此处填邮箱地址和用户名,用户名可以任意填写
 
			email.setAuthentication("1269412851@qq.com", "huruslnlbitcideh");//此处填写邮箱地址和客户端授权码
 
			email.setSubject("TaPin在线考试系统验证码");//此处填写邮件名，邮件名可任意填写
			email.setMsg("尊敬的用户您好,您本次的验证码是：" + code);//此处填写邮件内容
 
			email.send();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static String randomChar(){
		String code="";
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ123456789";
        for (int i = 0; i < 6; i++) {
        	code+=s.charAt(r.nextInt(s.length()));
		}
        return code;
    }
	public static void main(String[] args) {
		String code=Email.randomChar();
		System.out.println(Email.sendEmail("470199898@qq.com", code));
	}
}
