package prj.resources.mgmt.services;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailNotifier {

	private MailSender mailSender;

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendPasswordInEmail(String email, String pwd) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("system@localhost");
		msg.setTo(email);
		msg.setSubject("Password for MeetMePal");
		msg.setText("Dear Sir \n\n" +
					"The new password is " + pwd + "\n\n" +
					"Thank you."
					);
		try {
			mailSender.send(msg);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
