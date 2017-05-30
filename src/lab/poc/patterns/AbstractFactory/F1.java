package lab.poc.patterns.AbstractFactory;

public class F1 extends AF {

	public AButton getButton(){
		
		return new Button1();
	}
}
