package lab.poc.email;


public class EmailTask implements Runnable {

	public void run() {
		
//		JavaMailSenderImpl sender = new JavaMailSenderImpl();
//		sender.setHost("sj.verient.com");
//		MimeMessage message = sender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message);
//		try {
//			helper.setTo("voleynik@verient.com");
//			helper.setSubject("Verient Transaction notification.");
//			helper.setText("Transaction rejected. Rejection code: 999");
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		sender.send(message);
	}
	
	public EmailTask(){

	}
}