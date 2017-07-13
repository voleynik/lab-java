package lab.interkassa;

public class Main {

	public static void main(String[] args) {
		
		Component root = Builder.buildNode();
		
		System.out.println("BEFORE");
		Component.print(root);

		System.out.println("AFTER");
		Component.print(Processor.process(root, null));
		
		System.out.println("The end");
	}
}
