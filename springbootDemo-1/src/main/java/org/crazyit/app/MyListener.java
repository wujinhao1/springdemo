package org.crazyit.app;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

public class MyListener implements ApplicationContextAware, ApplicationListener<ApplicationStartedEvent> {

	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	   this.ctx=applicationContext;

	}


	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		ConfigurableApplicationContext applicationContext = event.getApplicationContext();
		if(applicationContext==this.ctx) {
			System.out.println("触发事件的容器与监听器的容器相同");
		}
		System.out.println("执行自定义方法");
		
	}

}
