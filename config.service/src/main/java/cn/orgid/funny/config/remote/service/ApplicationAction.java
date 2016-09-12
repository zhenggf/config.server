package cn.orgid.funny.config.remote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.orgid.funny.config.domain.component.AccessTokenThreadLocalComponent;
import cn.orgid.funny.config.domain.model.app.AccessToken;
import cn.orgid.funny.config.domain.service.ApplicationService;

@Controller
@RequestMapping("/config")
public class ApplicationAction {
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	AccessTokenThreadLocalComponent accessTokenLocalThreadComponent;
	
	@RequestMapping("get_access_token")
	public String getAccessToken(String appKey,String secret,ModelMap map){
		
		AccessToken accessToken = applicationService.getApplicationAccessToken(appKey, secret);
		JsonResult r = JsonResult.success(accessToken);
		map.put(JsonResult.k, r);
		return "/json/json";
		
	}
	

}
