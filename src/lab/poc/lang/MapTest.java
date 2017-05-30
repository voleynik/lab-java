package lab.poc.lang;
import java.util.*;

public class MapTest {
   public static void main(String[] args) {

      Hashtable ht = new Hashtable();
      HashMap hm = new HashMap();
      LabObject lo = new LabObject();
      lo.objNumber = 1;

      ht.put("lo", lo);
      hm.put("lo",lo);

      lo.objNumber = 2;

      System.out.println("~1. - lo ht objNumber: " + ((LabObject) ht.get("lo")).objNumber );
      System.out.println("~1. - lo hm objNumber: " + ((LabObject) hm.get("lo")).objNumber );

      updateObject(lo);

      System.out.println("~2. - lo ht objNumber: " + ((LabObject) ht.get("lo")).objNumber );
      System.out.println("~2. - lo hm objNumber: " + ((LabObject) hm.get("lo")).objNumber );
   }

   private static void updateObject ( LabObject pLabObject ){
      pLabObject.objNumber = 3;
   }
}

class LabObject{
   protected int objNumber;
}