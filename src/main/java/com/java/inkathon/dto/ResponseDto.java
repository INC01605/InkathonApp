package com.java.inkathon.dto;

public class ResponseDto {
   public String code;
   public String message;
   public Boolean status;
   public Object data;
	@Override
	public String toString() {
		return "ResponseDto [code=" + code + ", message=" + message + ", status=" + status + ", data=" + data + "]";
	}
	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	}
