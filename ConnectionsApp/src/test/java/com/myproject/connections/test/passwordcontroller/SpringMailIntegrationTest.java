package com.myproject.connections.test.passwordcontroller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.myproject.connections.service.EmailService;

/*@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)*/
public class SpringMailIntegrationTest {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
    private JavaMailSender emailSender;
	
	@Rule
    public SmtpServerRule smtpServerRule = new SmtpServerRule(3025);
	
	@Test
	public void test_SendEmail() throws MessagingException, IOException {
		SimpleMailMessage simpleMessage =new SimpleMailMessage();
		simpleMessage.setFrom("test@example.com");
		simpleMessage.setSubject("TestEmail");
		simpleMessage.setTo("received@example.com");
		simpleMessage.setText("This is a test Email");
		
		emailSender.send(simpleMessage);
			
		MimeMessage[] receivedMessages = smtpServerRule.getMessages();
		assertEquals(1,receivedMessages.length);
		MimeMessage current = receivedMessages[0];
		
		assertEquals(simpleMessage.getFrom(),current.getFrom());
		assertEquals(simpleMessage.getTo(),current.getAllRecipients()[0].toString());
		assertEquals(simpleMessage.getSubject(),current.getSubject());
		assertEquals(simpleMessage.getSubject(),current.getSubject());
		assertTrue(String.valueOf(current.getContent()).contains(simpleMessage.getSubject()));

		
	}

}
