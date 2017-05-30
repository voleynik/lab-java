package lab.node;

public class NodeFinder {

   public static Node findNode(Node rootNode, int aNodeId){

      // 1. - Check if passed node is the one.
      if(rootNode.nodeId == aNodeId){
         return rootNode;
      }

      // 2. - Continue only if this node has children
      if( rootNode.childrenNodes != null){

         Node tempNode = null;

         // 2.1 - Check all children of passed node.
         for( int i = 0; i < rootNode.childrenNodes.size(); i++ ){

            tempNode = (Node) rootNode.childrenNodes.get(i);
            if(tempNode.nodeId == aNodeId){
               return tempNode;
            }

            tempNode = findNode( (Node) rootNode.childrenNodes.get(i), aNodeId );
            if( tempNode != null ){
               return tempNode;
            }
         }
      }

      //~ Not found
      return null;
   }

   public static void main(String[] args) {
   		double t1 = System.currentTimeMillis();
      Node topNode = TreeBuilder.buildNodeTree();
      //
      int findId = 1;
      System.out.print("~ Looking for node " + findId + " . . . ");
      Node resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 11;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 111;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 112;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 113;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 12;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 121;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 122;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 123;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 13;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 131;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 132;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      findId = 133;
      System.out.print("~ Looking for node " + findId + " . . . ");
      resultNode = findNode(topNode, findId);
      if( resultNode == null ){ System.out.println("~ Node not found"); }else{ System.out.println("~ Node Id: " + resultNode.nodeId); }
      //
      System.out.println("NodeFinder time in MS: " + (System.currentTimeMillis() - t1));
   }
}