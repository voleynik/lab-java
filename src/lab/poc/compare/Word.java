package lab.poc.compare;

public class Word implements Comparable {

	public String 	wrd;
	public int		ctr;
	
	public Word(String p0, int p1){
		wrd = p0;
		ctr = p1;
	}
	
	  public int compareTo(Object obj) {
		  
		  Word w = (Word) obj;
		  int result = 0;
		    
		  if(this.ctr < w.ctr) result =  -1;
		  if(this.ctr > w.ctr) result =   1;
		  
		  return result;
	  }
}
