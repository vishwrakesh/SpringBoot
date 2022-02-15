package com.springboot.dto;

import java.util.List;
import java.util.Map;

public class ResultDto<T> {

	public String mesage;
	public Map<String, String> info;
	public List<T> data;
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public ResultDto() {
	}
	
	public ResultDto(String message) {
		this.mesage = message;
	}

	public Map<String, String> getInfo() {
		return info;
	}

	public void setInfo(Map<String, String> info) {
		this.info = info;
	}

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}

}
