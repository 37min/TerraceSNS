package terrace.email;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemberSendEmail {
	public void sendEmail(String email, String title, String text) {
        // 메일 관련 정보
        String host = "smtp.gmail.com";
        String username = "ahn920328@gmail.com";
        String password = "ahn920328";
         
        // 메일 내용
        String recipient = email;
        String subject = title;
        String body = text;
         
        //properties 설정
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        // 메일 세션
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
 
        // 메일 관련
         try {
            msg.setSubject(subject);
            msg.setText(body);
            msg.setFrom(new InternetAddress(username));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            
            // 발송 처리
            Transport transport = session.getTransport("smtps");
            transport.connect(host, username, password);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();     
         } catch (MessagingException e) {
        	 e.printStackTrace();
         }
  }
}