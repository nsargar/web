package model;

import lombok.Data;

@Data
public class Response {

	public Response(String string, ContactUs c) {
		// TODO Auto-generated constructor stub
		status=string;
		data=c;
	}
	private String status;
	private Object data;
	
}
