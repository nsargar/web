package controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring4.view.AjaxThymeleafViewResolver;

import configuration.EmailConfig;
import model.ContactUs;
import model.Response;
import services.EmailService;

@RestController
public class RestControllerClass {
	
	@Autowired
	private EmailService eService;
	
	@RequestMapping(value="/email", method=RequestMethod.POST)
	public  Response sendEmail(@RequestBody ContactUs c)
	{
		
		if(eService.sendEmail(c).equals("Success"))
			return new Response("Done",c);
		//e.javaMailSender().send(arg0);
		else
		
		return new Response("Error",c);
	}
	

}
