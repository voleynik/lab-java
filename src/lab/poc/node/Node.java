package lab.poc.node;
import java.util.List;

public class Node {

   protected int nodeId;
   protected List childrenNodes;

   public Node(){
   }

   public Node(int p0, List p1){
      nodeId = p0;
      childrenNodes = p1;
   }
}