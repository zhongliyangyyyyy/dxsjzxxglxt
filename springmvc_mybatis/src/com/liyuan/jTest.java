package com.liyuan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class jTest {
	
	public static void main(String[] args){
		ApplicationContext ct=new FileSystemXmlApplicationContext("applicationContext.xml");
		ct.getBean("");
	}
}
