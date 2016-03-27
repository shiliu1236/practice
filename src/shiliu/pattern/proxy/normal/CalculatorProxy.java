package shiliu.pattern.proxy.normal;

//一个具体实现类和一个代理类，在proxy类的实现中，如果需要对多个类进行代理，并且在代理类中的功能实现是一致的，那么就
//需要为每个委托类都写一个代理类
public class CalculatorProxy implements Calculator{
	private Calculator calculator;
	CalculatorProxy(Calculator calculator){
		this.calculator = calculator;
	}
	@Override
	public int add(int a, int b) {
		int result = calculator.add(a, b);
		return result;
	}

}
