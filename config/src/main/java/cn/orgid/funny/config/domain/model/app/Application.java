package cn.orgid.funny.config.domain.model.app;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.orgid.funny.config.domain.model.base.ModelBase;
import cn.orgid.funny.config.domain.util.EncrypUtil;

@Entity
@Table(name = "t_app")
public class Application extends ModelBase {

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private String name;

	@Column(unique=true)
	private String appKey;

	private String secret;
	
	private boolean encrypted;
	
	
	
	private String k;
	
	
	private Long parentId;
	
	
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getK() {
		
		return k;
		
	}
	
	public String getDecryptK(String key){
		return EncrypUtil.decrypt(k, key);
	}
	
	public void  setK(String k){
		
		this.k=k;
		
	}
	

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getSecret() {
		return secret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public AccessToken createAccessToken(String key) {

		AccessToken accessToken = AccessToken.createApplicationAccessToken();
		accessToken.setAppId(getId());
		accessToken.setK(EncrypUtil.decrypt(k, key));
		return accessToken;

	}

	
	public void init(String key) {

		this.appKey = UUID.randomUUID().toString().replaceAll("-", "");
		this.secret = UUID.randomUUID().toString().replace("-", "");
		k=EncrypUtil.getEncryptionKey();
		k=EncrypUtil.encryt(k, key);
	}
	
	public void  encrypt(String key){
		
		k=EncrypUtil.encryt(k, key);
		
	}
	
	

	public static void main(String[] args) {
		
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		
	}

	public AccessToken refreshAccessTokenIfNeed(AccessToken token,String key) {
		
		if(token.isExpire()){
			token.refresh();
		}
		token.setK(EncrypUtil.decrypt(k, key));
		return token;
		
	}

	public boolean isEncrypted() {
		return encrypted;
	}

	public void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}

	public boolean isSecretValid(String secret2,String key) {
		
		if(secret2==null){
			return false;
		}
		if(encrypted){
			secret2=EncrypUtil.encryt(secret2, key);
		}
		return secret2.equals(secret);
	
	}

}
