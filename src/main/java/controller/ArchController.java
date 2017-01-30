package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ArchController {
	
	@RequestMapping("/")
	public String homeReturn()
	{
		return "home";
	}

}
