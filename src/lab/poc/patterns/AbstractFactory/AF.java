package lab.patterns.AbstractFactory;

public abstract class AF {
	
	public static AF getFactory(String[] args){
		
		return new F1();
	}
	
	public abstract AButton getButton();
}
