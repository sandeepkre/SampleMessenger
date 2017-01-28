package org.sandy.jersy.SampleMessenger.service;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class BeanParamClass {
	@PathParam("messageId") long messageId;
	@QueryParam("name") String name;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
