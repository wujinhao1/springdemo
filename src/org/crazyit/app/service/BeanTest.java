package org.crazyit.app.service;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanTest {
public static void main(String[]args)throws Exception {
	/*
	 * //创建Spring容器 //在类加载途径中加载beans.xml文件 var ctx = new
	 * ClassPathXmlApplicationContext("beans.xml"); //获取相关bean Person person =
	 * ctx.getBean("person", Person.class); person.useAxe(); //为spring容器关闭注册钩子
	 * ctx.registerShutdownHook();
	 */
	
	ClassPathResource resource = new ClassPathResource("beans.xml");
	DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
	new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(resource);
}
}

