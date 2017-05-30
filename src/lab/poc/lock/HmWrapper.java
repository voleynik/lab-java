package lab.lock;

import java.util.HashMap;

public class HmWrapper {

    private HashMap hm = new HashMap();
    int _readers = 0;
    int _writers = 0;
    
    // Read
    public Object get(Object key){
    	getReadLock();
    	Object o = hm.get(key);
    	releaseReadLock();
    	return o;
    }
    synchronized private void getReadLock() {
        while(_writers > 0) {
          try {
           wait();
          }
          catch (InterruptedException ie) { }
        } 
        _readers ++ ;
    }
    synchronized private void releaseReadLock() {
    	_readers --;
        if (_readers == 0) {
        	notifyAll();       
        }
    }
    
    // Write
    public void add(Object key, Object obj){
    	getWriteLock();
    	Object o = hm.put(key, 0);
    	releaseWriteLock();
    }
    public void remove(Object key){
    	getWriteLock();
    	Object o = hm.remove(key);
    	releaseWriteLock();
    }  
    synchronized private void getWriteLock() {
        while (_readers > 0) {
          try {
        	  wait();
          }
          catch (InterruptedException ie) { }
        }
    	_writers = 1;
    }
    synchronized private void releaseWriteLock() {
    	_writers = 0;
       notifyAll();
    }
    
    
    
    public static void main(String[] args){
        HmWrapper hmw = new HmWrapper();
        
        hmw.add("h1", "o1");
    }
}
