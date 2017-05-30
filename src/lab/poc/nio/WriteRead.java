package lab.poc.nio;

import java.nio.IntBuffer;

public class WriteRead {

  public static void main(String[] args) {
    
    //~ Write
    IntBuffer buffer = IntBuffer.allocate(10);
      for (int i=0; i < buffer.capacity(); i++) {
      buffer.put(i);
    }
      
    //~ Read
    buffer.position(0);
    while (buffer.hasRemaining()) { //~ Something to read between position and the limit.
      System.out.println("i = " + buffer.get() );
    }   
  }
}
