package config.test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.orgid.funny.config.client.ConfigClient;
import cn.orgid.funny.config.client.ConfigClient.TestBean;

public class TestConfigClient extends TestBase {
	
	@Autowired
	ConfigClient client;
	
	@Autowired
	TestBean bean;
	
	@Test
	public void test(){
		
		System.out.println(client);
		Properties ps =client.getConfigProperties();
		System.out.println(ps);
		System.out.println("bean get t:"+bean.getT());
		
		//System.out.println(ps1);
	}

}
