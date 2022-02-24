package org.crazyit.app.service;

public class Person {
	public Person() {
	System.out.println("person实例");
		
	}
private Axe axe;
public void setAxe(Axe axe) {
	this.axe=axe;
	System.out.println("执行依赖注入");
}

public void init() {
	System.out.println("执行初始化方法");
}
public void close() {
	System.out.println("正在销毁之前的方法");
}
public void useAxe() {
	System.out.println(axe.chop());
}
	
}
