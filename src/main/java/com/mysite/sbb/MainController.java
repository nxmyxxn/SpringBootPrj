package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "sbb에 오신 것을 화닝화닝";
	}
	

}
