package com.xutown.hurtplatform.web;

import java.io.Serializable;

/**
 * 收集操作结果信息
 * @author kangming.ning
 * */
public class JsonTipMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success = true;

	private String msg = "";

	private Object obj = null;

	public JsonTipMessage() {
		super();

	}

	public JsonTipMessage(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public JsonTipMessage(boolean success, String msg, Object obj) {
		super();
		this.success = success;
		this.msg = msg;
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "JsonTipMessage [success=" + success + ", msg=" + msg + ", obj=" + obj + "]";
	}

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

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public void setErrorMsg(String msg) {
		this.success = false;
		this.msg = msg;
	}

	public void setRightMsg(String msg) {
		this.success = true;
		this.msg = msg;
	}

}
