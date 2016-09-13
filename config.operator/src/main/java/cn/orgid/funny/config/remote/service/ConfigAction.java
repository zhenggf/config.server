package cn.orgid.funny.config.remote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.orgid.funny.config.domain.component.AccessTokenThreadLocalComponent;
import cn.orgid.funny.config.domain.model.app.AccessToken;
import cn.orgid.funny.config.domain.model.config.ConfigField;
import cn.orgid.funny.config.domain.service.ConfigService;

@Controller
@RequestMapping("/config")
public class ConfigAction {
	
	@Autowired
	ConfigService configService;
	
	@Autowired
	AccessTokenThreadLocalComponent accessTokenThreadLocalComponent;
	
	@RequestMapping("get_config_fields")
	public String getConfigFields(AccessToken accessToken,ModelMap map){
		
		accessTokenThreadLocalComponent.set(accessToken);
		List<ConfigField> fields = configService.findApplicationFields();
		JsonResult r = JsonResult.success(fields);
		map.put(JsonResult.k, r);
		return "/json/json";
		
	}

	
	
}
