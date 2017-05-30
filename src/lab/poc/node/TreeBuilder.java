package lab.poc.node;
import java.util.List;
import java.util.ArrayList;

public class TreeBuilder {

   public static Node buildNodeTree() {

      Node n_1 = new Node();

      Node n_1_1 = new Node();
      Node n_1_1_1 = new Node();
      Node n_1_1_2 = new Node();
      Node n_1_1_3 = new Node();

      Node n_1_2 = new Node();
      Node n_1_2_1 = new Node();
      Node n_1_2_2 = new Node();
      Node n_1_2_3 = new Node();

      Node n_1_3 = new Node();
      Node n_1_3_1 = new Node();
      Node n_1_3_2 = new Node();
      Node n_1_3_3 = new Node();

      List list_1 = new ArrayList();
      List list_1_1 = new ArrayList();
      List list_1_2 = new ArrayList();
      List list_1_3 = new ArrayList();

      n_1_1_1.nodeId = 111;
      n_1_1_1.childrenNodes = null;
      n_1_1_2.nodeId = 112;
      n_1_1_2.childrenNodes = null;
      n_1_1_3.nodeId = 113;
      n_1_1_3.childrenNodes = null;
      list_1_1.add(n_1_1_1);
      list_1_1.add(n_1_1_2);
      list_1_1.add(n_1_1_3);
      n_1_1.nodeId = 11;
      n_1_1.childrenNodes = list_1_1;

      n_1_2_1.nodeId = 121;
      n_1_2_1.childrenNodes = null;
      n_1_2_2.nodeId = 122;
      n_1_2_2.childrenNodes = null;
      n_1_2_3.nodeId = 123;
      n_1_2_3.childrenNodes = null;
      list_1_2.add(n_1_2_1);
      list_1_2.add(n_1_2_2);
      list_1_2.add(n_1_2_3);
      n_1_2.nodeId = 12;
      n_1_2.childrenNodes = list_1_2;

      n_1_3_1.nodeId = 131;
      n_1_3_1.childrenNodes = null;
      n_1_3_2.nodeId = 132;
      n_1_3_2.childrenNodes = null;
      n_1_3_3.nodeId = 133;
      n_1_3_3.childrenNodes = null;
      list_1_3.add(n_1_3_1);
      list_1_3.add(n_1_3_2);
      list_1_3.add(n_1_3_3);
      n_1_3.nodeId = 13;
      n_1_3.childrenNodes = list_1_3;

      n_1.nodeId = 1;
      list_1.add(n_1_1);
      list_1.add(n_1_2);
      list_1.add(n_1_3);
      n_1.childrenNodes = list_1;

      return n_1;
   }
}