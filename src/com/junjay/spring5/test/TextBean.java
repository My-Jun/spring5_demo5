package com.junjay.spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.junjay.spring5.config.TxConfig;
import com.junjay.spring5.service.UserService;

public class TextBean {

	@Test
	public void testJdabTransfer() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		UserService userService = context.getBean("userService", UserService.class);
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		try {
			userService.transfer("张三", 100, "李四");
		} catch (Exception e) {
			System.err.println("转账中出现异常！！！");
			userService.queryUser("张三");
		}
	}

	@Test
	public void testJdabTransferXml() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		UserService userService = context.getBean("userService", UserService.class);
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		try {
			userService.transfer("张三", 100, "李四");
		} catch (Exception e) {
			System.err.println("转账中出现异常！！！");
			userService.queryUser("张三");
		}
	}

	@Test
	public void testJdabTransferConfig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		try {
			userService.transfer("张三", 100, "李四");
		} catch (Exception e) {
			System.err.println("转账中出现异常！！！");
			userService.queryUser("张三");
		}
	}

}
