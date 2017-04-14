package services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import configuration.EmailConfig;
import model.ContactUs;

@Service
public class EmailService {


	@Autowired
	private EmailConfig e;
	
	//@PostConstruct
	public String sendEmail(ContactUs c)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo("team@ashnni.com");
		message.setSubject("Contacting");
		message.setText("Name:"+c.getName()+"\nEmail:"+c.getEmail()+"\nWebsite:"+c.getWebsite()+"\nMessage:"+c.getMessage());
		message.setFrom(c.getEmail());
		try{
		e.javaMailSender().send(message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Error";
		}
		System.out.println(e);
		return "Success";
	}
	
	
}
