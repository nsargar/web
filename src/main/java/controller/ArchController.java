package controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import configuration.EmailConfig;


@Controller
public class ArchController {
	

	@SuppressWarnings("unused")
	@Autowired
	private EmailConfig e;
	
	@RequestMapping("/")
	public String homeReturn()
	{
		return "index";
	}
	
	
	

}
