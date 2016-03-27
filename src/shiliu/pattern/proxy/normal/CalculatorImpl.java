package shiliu.pattern.proxy.normal;

public class CalculatorImpl implements Calculator{

	@Override
	public int add(int a, int b) {
		System.out.println(a+b);
		return a+b;
	}

}
