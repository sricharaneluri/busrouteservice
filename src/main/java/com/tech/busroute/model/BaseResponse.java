package com.tech.busroute.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
	private int code;
	private Object responseData;
	private String description;	


}
