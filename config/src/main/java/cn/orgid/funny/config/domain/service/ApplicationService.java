package cn.orgid.funny.config.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import cn.orgid.funny.config.domain.component.AccessTokenThreadLocalComponent;
import cn.orgid.funny.config.domain.component.SystemConfig;
import cn.orgid.funny.config.domain.dao.app.AccessTokenDAO;
import cn.orgid.funny.config.domain.dao.app.ApplicationDAO;
import cn.orgid.funny.config.domain.exception.ApplicationException;
import cn.orgid.funny.config.domain.model.app.AccessToken;
import cn.orgid.funny.config.domain.model.app.Application;
import cn.orgid.funny.config.domain.util.EncrypUtil;

@Service
public class ApplicationService {
	
	private boolean encrypting = false;

	private Object EncryptingLock = new Object();
	
	
	@Autowired
	ApplicationDAO applicationDAO;
	
	@Autowired
	AccessTokenDAO accessTokenDAO;
	
	@Autowired
	AccessTokenThreadLocalComponent accessTokenThreadLocalComponent;
	
	
	@Autowired
	SystemConfig systemConfig;
	
	
	
	public Application createApplication(String name){
		
		Application application=new  Application();
		application.setName(name);
		application.init(systemConfig.getEncryptKey());
		applicationDAO.save(application);
		return application;
		
	}
	
	public AccessToken getApplicationAccessToken(String appKey,String secret){
		
		Application application = applicationDAO.findByAppKey(appKey);
		if(application==null||!application.isSecretValid(secret,systemConfig.getEncryptKey())){
			throw new ApplicationException("appkey error!");
		}
		AccessToken token = accessTokenDAO.findByAppId(application.getId());
		if(token==null){
			 token = application.createAccessToken(systemConfig.getEncryptKey());
			 accessTokenDAO.save(token);
		}else{
			
				application.refreshAccessTokenIfNeed(token,systemConfig.getEncryptKey());
				accessTokenDAO.save(token);
			
		}
		return token;
		
		
	}
	
	
	@Scheduled(cron = "5 * * * * ?")
	public void encryptApplication() {

		synchronized (EncryptingLock) {
			if (encrypting) {
				return;
			} else {
				encrypting = true;
			}
		}
		List<Application> applications = applicationDAO.findByEncrypted(false);
		for (Application application : applications) {
			application.setEncrypted(true);
			application.setSecret(EncrypUtil.encryt(application.getSecret(), systemConfig.getEncryptKey()));
		}
		encrypting = false;

	}
	
}
