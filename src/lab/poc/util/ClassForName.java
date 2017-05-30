package lab.poc.util;

public class ClassForName {

	public static void main(String[] args) {
		// Added to project as 'Class Folder' - C:\Insectarium\Projects\Server\CentricFileVault\classes
		Object o = null;
		try {
			
			Class c = Class.forName("com.centricsoftware.server.nodestorage.nvmssql.NodeStorage"); // ok
//			Class c = Class.forName("com.centricsoftware.server.nodestorage.nvmssql.NodeAttributeQuery"); // has inner classes
//		    Class c = Class.forName("com.centricsoftware.server.nodestorage.nvmssql.Dependency"); // ok
			
			System.out.println("Got a class: " + c.getName());
			o = c.newInstance();	
			System.out.println("Got an instance: " + o.getClass().getName());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
