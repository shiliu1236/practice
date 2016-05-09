package shiliu.jdk.fundamental.bind;

public class Father {
	protected String name="father's name";
	
	public void method(){
		System.out.println("this is father's method"+this.getClass());
	}

	public String getName() {
		return name;
	}
}
