package com.Spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HellController {
	@ResponseBody
	@RequestMapping(value="/hell",method=RequestMethod.GET)
	public String home() {
		return "Nitesh ki gand mari jaygi";
	}

}
