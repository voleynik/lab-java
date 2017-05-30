package lab.poc.patterns.AbstractFactory;

public class F2 extends AF {

	public AButton getButton(){
		
		return new Button2();
	}
}
