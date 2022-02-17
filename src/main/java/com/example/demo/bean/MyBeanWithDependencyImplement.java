package com.example.demo.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
	Log LOGGER =LogFactory.getLog(MyBeanWithDependencyImplement.class);
	private MyOperation myOperationDependency;
	
	public MyBeanWithDependencyImplement(MyOperation operation) {
		this.myOperationDependency=operation;
		
	}
	
	
	@Override
	public void printWithDependency() {
		LOGGER.info("metodo printWithDependency");
		
		int num=1;
		LOGGER.debug("NUMERO ENVIADO COMO PARAMETRO:"+num);
		System.out.println(this.myOperationDependency.sum(num));
		System.out.println("Bean con dependencia");
		
	}

}
