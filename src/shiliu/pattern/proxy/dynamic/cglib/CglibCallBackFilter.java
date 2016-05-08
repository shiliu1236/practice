package shiliu.pattern.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

class CallBackFilterTest{
	public void doOne(){
		System.out.println("--------->1");
	}
	public void doTwo(){
		System.out.println("------------>2");
	}
}
public class CglibCallBackFilter {
	static class MethodIntercepterImpl implements MethodInterceptor{

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			System.out.println(method);
			return proxy.invokeSuper(obj, args);
		}
		
	}
	static class CallbackFilterImpl implements CallbackFilter{
		//返回1 代表不会进行interceptor的调用
		@Override
		public int accept(Method method) {
			return ("doTwo".equals(method.getName()))?1:0;
		}
		
	}
	public static void main(String[] args) {
		Callback[] callbacks = new Callback[]{
			new MethodIntercepterImpl(),NoOp.INSTANCE
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CallBackFilterTest.class);
		enhancer.setCallbacks(callbacks);
		enhancer.setCallbackFilter(new CallbackFilterImpl());
		CallBackFilterTest callBackFilterTest  = (CallBackFilterTest) enhancer.create();
	    callBackFilterTest.doOne();
	    callBackFilterTest.doTwo(); 
	}
	
}
