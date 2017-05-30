package lab.poc.exec;
/**
 *
 */
public class Exec {
	public static void main(String[] args) {
		try {
//			String[] cmd = {"start.exe", "/c", "notepad" };
			Runtime rt = Runtime.getRuntime();
			rt.exec("cmd.exe /c start notepad"); //OK
//			rt.exec("cmd.exe /c call notepad"); // OK
//			rt.exec("cmd.exe /c start C:/WINNT/profiles/AllUse~1/StartM~1/Programs/Startup/clean-rhi.bat"); // ok

//			rt.exec("cmd.exe /c call C:/WINNT/profiles/AllUse~1/StartM~1/Programs/Startup/clean-rhi.bat"); // OK

				System.out.println("Hi from Exec.class - " + new java.util.Date());
		}
    catch (Exception ex) {
         ex.printStackTrace(System.out);
    }
  }
}