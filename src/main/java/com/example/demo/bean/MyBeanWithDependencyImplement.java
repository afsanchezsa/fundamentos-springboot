package com.example.demo.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
	
	private MyOperation myOperationDependency;
	
	public MyBeanWithDependencyImplement(MyOperation operation) {
		this.myOperationDependency=operation;
		
	}
	
	
	@Override
	public void printWithDependency() {
		int num=1;
		System.out.println(this.myOperationDependency.sum(num));
		System.out.println("Bean con dependencia");
		
	}

}
