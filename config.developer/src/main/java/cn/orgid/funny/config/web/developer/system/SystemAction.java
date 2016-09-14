package cn.orgid.funny.config.web.developer.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemAction {

	@RequestMapping("do_register")
	public String register(){
		
		
		return "";
		
	}
	
}
