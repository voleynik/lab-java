package lab.pzl;

public class LinkedObj {
	
	public String objName;
	public LinkedObj oBefore;
	public LinkedObj oA;
	
	public String toString(){
		StringBuffer sb = new StringBuffer("Obj: ");
		sb.append(objName).
		append(", b: ");
		if(oBefore == null) sb.append("*NONE");
		else sb.append(oBefore.objName);
		sb.append(", a: ");
		if(oA == null) sb.append("*NONE");
		else sb.append(oA.objName);
		sb.append("\n");
				
		return sb.toString();
	}
	
	public LinkedObj(String objName, LinkedObj o1, LinkedObj o3) {

		this.objName = objName;
		this.oBefore = o1;
		this.oA = o3;
	}
	
	public LinkedObj() {

	}

}
