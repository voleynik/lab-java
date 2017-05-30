package lab.patterns.AbstractFactory;

public class Client {

	AF af = AF.getFactory(null);
	AButton ab = af.getButton();	
}
