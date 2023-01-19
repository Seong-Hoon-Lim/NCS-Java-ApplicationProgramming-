package com.kudangtang.jv200.mod008;

public class CallStackExceptionTest {
	public void a() throws Exception{
		b();
	}
	
	public void b() throws Exception {
		c();
	}
	
	public void c() throws Exception{
		System.out.println("c() is called.");
		throw new Exception("매우 위험하고 대단하고 막강한 에러");
	}
	public static void main(String[] args) {
		CallStackExceptionTest test = new CallStackExceptionTest();
		try {
			test.a();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main close");
	}
}
