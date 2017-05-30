package lab.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class EmailSender extends Thread {
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private static final String s1 = "select * from msg where timesent is NULL order by timeadded asc";
	private static final String s2 = "update msg set timesent = ?, sentby = ? where timeadded = ? and timesent is NULL";
	public static final  String s3 = "update msg set sentby = NULL, timesent = NULL";
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String 				senderName;
    private Connection 			dbCon;
    private Statement 			dbStm;
    private PreparedStatement 	dbPrdStm;
    private ResultSet 			rSet;
    private long 				initSleepTimeMS = 0;
    private Timestamp 			time_added;
    private Timestamp 			time_sent;
    private String 				emailBody;
    private int 				numbersOfRowsUpdated = 0;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void sendEmails(){   

    	try{
    		while( EmailSenderRunner.active ){
            
                rSet = dbStm.executeQuery(s1);
                
                if( rSet.next() ){
                	
                	time_added 	= rSet.getTimestamp("timeadded");
                	emailBody 	= rSet.getString("body");
            
                	time_sent = new Timestamp( System.currentTimeMillis() );
                    
                	dbPrdStm.setTimestamp( 	1, time_sent );
                	dbPrdStm.setString( 	2, senderName );
                	dbPrdStm.setTimestamp( 	3, time_added );
                
                	numbersOfRowsUpdated = dbPrdStm.executeUpdate(); 
                
                	if( numbersOfRowsUpdated == 1 ){ // Start emailing.
                	
                		//trace( senderName + " is trying to send: " + emailBody + " - " + time_added );
                		trace( emailBody + " tried by " + senderName );
                	
                		try {
                			sendEmail( emailBody );
                			dbCon.commit();
                			rSet.close();
                			trace( emailBody + " sent  by " + senderName );

                		} catch ( Exception e ) {
                			e.printStackTrace();
                			dbCon.rollback();
                			trace( emailBody + " NOT sent by " + senderName );
                		}
                    }
                }
            } 
    		
        } catch ( SQLException excpt ){
        	excpt.printStackTrace();
        } finally {
        	try { dbStm.close(); }    catch ( SQLException ignore ) { }
        	try { dbPrdStm.close(); } catch ( SQLException ignore ) { }
        	try { dbCon.close(); }    catch ( SQLException ignore ) { }
        }
    }    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void sendEmail( String emailBody ) throws Exception {
    	try{sleep(2000);}catch (InterruptedException e){e.printStackTrace();} 
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public EmailSender(String emsName, long pInitSleepTimeMS){
    	senderName = emsName;
//        trace("\n Constructing " + emsName);
        try {
        	//~ Connection
//         		System.out.print("Get connection using \n" + "Url: " + Db.getUrl() + 
//            	", User: " + Db.getUserName() + ", Pwd: " + Db.getUserPassword() + " ...... ");
			dbCon = DriverManager.getConnection( Db.getUrl(), Db.getUserName(), Db.getUserPassword());
//         		System.out.println("SUCCESS"); 
			dbCon.setAutoCommit(false);
//			dbCon.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
         
			//~ Statement
			dbStm = dbCon.createStatement();
//         		dbStm = dbCon.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
//              	ResultSet.CONCUR_UPDATABLE, 
//               	ResultSet.CLOSE_CURSORS_AT_COMMIT);
			dbStm.setFetchSize(1);
			
			dbPrdStm = dbCon.prepareStatement(s2);
         
			initSleepTimeMS = pInitSleepTimeMS;
		} catch (SQLException e) {
			System.out.println("FAILURE");
			e.printStackTrace();
			System.exit(1);
		} 
		setName(emsName);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void run(){
    	sendEmails(); 
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void trace(String traceMsg){
        //System.out.print("Thread " + senderName + " - ");
        System.out.println(traceMsg);
    }
}
