package lab.list;
import java.util.*;

public class IndexOfCompare {

   public static void main(String[] args) {

      List completeList = createList();
      List newList = Collections.synchronizedList(new ArrayList());
      List names = Collections.synchronizedList(new ArrayList());
      MyObject myObj = null;

      for(int i = 0; i < completeList.size(); i++){
         myObj = (MyObject) completeList.get(i);
         if( names.indexOf( myObj.getMyObjectName() ) == -1){
            names.add(myObj.getMyObjectName());
            newList.add(myObj);
         }
      }
      System.out.println("~ New list size: " + newList.size());
   }

   private static List createList(){
      List l_list = Collections.synchronizedList(new ArrayList());

      l_list.add(new MyObject("Object-01"));
      l_list.add(new MyObject("Object-01"));
      l_list.add(new MyObject("Object-01"));
      l_list.add(new MyObject("Object-02"));
      l_list.add(new MyObject("Object-02"));
      l_list.add(new MyObject("Object-03"));
      l_list.add(new MyObject("Object-03"));
      l_list.add(new MyObject("Object-03"));
      l_list.add(new MyObject("Object-03"));

      return l_list;
   }
}

class MyObject{
   String name;
   public String getMyObjectName(){
      return name;
   }
   public MyObject(String p0){
      name = p0;
   }
}