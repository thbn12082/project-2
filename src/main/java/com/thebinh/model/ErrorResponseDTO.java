package com.thebinh.model;

import java.util.ArrayList;

public class ErrorResponseDTO {
	private String error;
	private ArrayList detail = new ArrayList<>();
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public ArrayList getDetail() {
		return detail;
	}
	public void setDetail(ArrayList detail) {
		this.detail = detail;
	}
	
	
}
