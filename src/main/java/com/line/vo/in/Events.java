package com.line.vo.in;

public class Events {
	
	private String type;
	
	private Message message;
	
	private long timestamp;
	
	private Source source;
	
	private String replyToken;
	
	private String mode;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getReplyToken() {
		return replyToken;
	}

	public void setReplyToken(String replyToken) {
		this.replyToken = replyToken;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	
	
}
