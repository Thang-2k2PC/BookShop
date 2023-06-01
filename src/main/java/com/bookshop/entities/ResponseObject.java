package com.bookshop.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResponseObject {

	private Object data;
	private Map<String, String> errorMessages = null ;
	private String status;

	@Override
	public String toString() {
		return "ResponseObject [status=" + status + "]";
	}

}
