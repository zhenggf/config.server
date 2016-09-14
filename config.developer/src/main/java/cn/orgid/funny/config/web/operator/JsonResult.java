package cn.orgid.funny.config.web.operator;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class JsonResult {
	
	public static final String k="json";
private boolean success;
	
	private String msg;
	
	
	public  static JsonResult success(Object o){
		JsonResult r = new JsonResult();
		r.success=true;
		r.msg="成功";
		r.value=o;
		return r;
	}
	
	private Object value;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String toString(){
		return JSON.toJSONString(this);
	}

	public static JsonResult success(){
		JsonResult r = new JsonResult();
		r.msg="成功";
		r.success=true;
		
		
		return r;
	}
	public static JsonResult error(String msg) {
		
		if(msg==null){
			msg="";
		}
		JsonResult r = new JsonResult();
		r.success=false;
		r.msg=msg;
		r.value=null;
		return r;
	}
	
	public static class T {
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	public static void main(String[] args) {
		
		Set<T> t = new HashSet<T>();
		T t1 = new T();
		t1.setName("测试");
		T t2 = new T();
		t2.setName("测试");
		t.add(t1);
		t.add(t2);
		t.add(t2);
		System.out.println(JsonResult.success(t));
		
	}
}
