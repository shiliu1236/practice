package shiliu.jdk.fundamental.bind;

public class Son extends Father{
	protected String name="son's name";

	@Override
	public void method() {
		System.out.println("this is son's method"+this.getClass()+" "+this.name);
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		Father father = new Son();
		System.out.println(father.getName());
		System.out.println(father.name);
		father.method();
	}
}
