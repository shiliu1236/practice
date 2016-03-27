package shiliu.pattern.proxy.normal;

//һ������ʵ�����һ�������࣬��proxy���ʵ���У������Ҫ�Զ������д��������ڴ������еĹ���ʵ����һ�µģ���ô��
//��ҪΪÿ��ί���඼дһ��������
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
