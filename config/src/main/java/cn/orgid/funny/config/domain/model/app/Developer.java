package cn.orgid.funny.config.domain.model.app;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.orgid.funny.config.domain.model.base.ModelBase;

@Entity
@Table(name="t_developer")
public class Developer  extends ModelBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String loginName;
	
	private String passwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
