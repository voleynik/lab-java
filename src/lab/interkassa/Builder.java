package lab.interkassa;

public class Builder {

	public static Component buildNode(){
		
		// lvl 3
		Component n1_1 = new Node();
		n1_1.setId("N1.1");
		Component n1_2 = new Node();
		n1_2.setId("N1.2");
		Component n1_3 = new Node();
		n1_3.setId("N1.3");
		
		Component l1_3 = new Leaf();
		l1_3.setId("L1.3");
		l1_3.setWeight(3);
		Component l1_2 = new Leaf();
		l1_2.setId("L1.2");
		l1_2.setWeight(2);
		Component l1_1 = new Leaf();
		l1_1.setId("L1.1");
		l1_1.setWeight(1);
		
		Component n2_1 = new Node();
		n2_1.setId("N2.1");
		Component n2_2 = new Node();
		n2_2.setId("N2.2");
		Component n2_3 = new Node();
		n2_3.setId("N2.3");
		
		Component l3_2 = new Leaf();
		l3_2.setId("L3.2");
		l3_2.setWeight(2);
		
		Component l3_1 = new Leaf();
		l3_1.setId("L3.1");
		l3_1.setWeight(1);
		
		Component n3_1 = new Node();
		n3_1.setId("N3.1");
		Component n3_2 = new Node();
		n3_2.setId("N3.2");
		
		// lvl 2
		Component n1 = new Node();
		n1.setId("N1");
		n1.addComponent(n1_1);
		n1.addComponent(n1_2);
		n1.addComponent(n1_3);
		n1.addComponent(l1_3);
		n1.addComponent(l1_2);
		n1.addComponent(l1_1);
		
		Component n2 = new Node();
		n2.setId("N2");
		n2.addComponent(n2_1);
		n2.addComponent(n2_2);
		n2.addComponent(n2_3);
		
		Component n3 = new Node();
		n3.setId("N3");
		n3.addComponent(l3_2);
		n3.addComponent(l3_1);
		n3.addComponent(n3_1);
		n3.addComponent(n3_2);
		
		// lvl 1
		Component root = new Node();
		root.setId("R");
		root.addComponent(n1);
		root.addComponent(n2);
		root.addComponent(n3);
		
		return root;
	}
}
