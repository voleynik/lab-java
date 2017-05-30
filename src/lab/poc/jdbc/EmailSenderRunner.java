package lab.poc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class EmailSenderRunner {
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static boolean active = true;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        
    	resetData();
        
        EmailSender e1 = new EmailSender("e1", 0);
        EmailSender e2 = new EmailSender("e2", 0);
        EmailSender e3 = new EmailSender("e3", 0);
        
        long t1 = System.currentTimeMillis();
        
        e1.start();
        e2.start();
        e3.start();

        try {
            Thread.sleep(40000);
	} catch (InterruptedException e) {
            e.printStackTrace();
	}finally{
            active = false;
            System.out.println("DONE");
            System.out.println("Total time: " + ( System.currentTimeMillis() - t1 ) );
        }
    }
    
    private static void resetData(){
    	Connection 	dbCon = null;
    	Statement 	dbStm = null;
    	try {
    		
			dbCon = DriverManager.getConnection( Db.getUrl(), Db.getUserName(), Db.getUserPassword());
			dbStm = dbCon.createStatement();
			dbStm.executeUpdate( EmailSender.s3 );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try { dbStm.close(); }    catch ( SQLException ignore ) { }
        	try { dbCon.close(); }    catch ( SQLException ignore ) { }
		}
    	
    }
}
