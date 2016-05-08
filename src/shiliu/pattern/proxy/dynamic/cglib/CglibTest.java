package shiliu.pattern.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

class TestClass{
	public void doSome(){
		System.out.println("testshiliu=======");
	}
}
public class CglibTest {
	static class MethodInterceptorImpl implements MethodInterceptor {

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			System.out.println(method);
			proxy.invokeSuper(obj, args);
			return null;
		}
	}
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestClass.class);
		enhancer.setCallback(new MethodInterceptorImpl());
		TestClass my = (TestClass) enhancer.create();
		my.doSome();
	}
}
