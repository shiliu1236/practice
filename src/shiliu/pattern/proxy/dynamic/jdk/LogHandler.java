package shiliu.pattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import shiliu.pattern.proxy.normal.Calculator;
import shiliu.pattern.proxy.normal.CalculatorImpl;


public class LogHandler implements InvocationHandler{
	Object obj;
	public LogHandler(Object obj) {
		 this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.doBefore();
		Object o = method.invoke(obj, args);
		this.doAfter();
		return o;
	}
	public  void doBefore(){
		System.out.println("do this before");
	}
	public void doAfter(){
		System.out.println("do this after");
	}
	
	public static void main(String[] args) {
		Calculator calculator = new CalculatorImpl();
		LogHandler lh = new LogHandler(calculator);
		Calculator proxy = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), lh);
		proxy.add(1, 1);
	}
}
