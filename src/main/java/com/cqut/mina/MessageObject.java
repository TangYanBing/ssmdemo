package com.cqut.mina;

import java.util.Date;

/**
 * 
 * @author lxr
 * @description 消息实体
 * 
 */
public class MessageObject {
	private String sender; // 发送者
	private String receiver; // 接受者
	private int contentLength; // 内容长度
	private char type; // 消息类型
	private Date senderTime; // 消息时间
	private String content; // 消息内容
	private String description;// 消息类型描述

	
	
	public MessageObject() {
		super();
	}

	public MessageObject(String receiver, char type, String content,
			String description) {
		super();
		this.receiver = receiver;
		this.type = type;
		this.content = content;
		this.description = description;
	}

	public MessageObject(String sender, String receiver, int contentLength,
			char type, Date senderTime, String content, String description) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.contentLength = contentLength;
		this.type = type;
		this.senderTime = senderTime;
		this.content = content;
		this.description = description;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getContentLength() {
		return content.length();
	}

	public Date getSenderTime() {
		return new Date();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MessageObject [sender=" + sender + ", receiver=" + receiver
				+ ", contentLength=" + contentLength + ", type=" + type
				+ ", senderTime=" + senderTime + ", content=" + content
				+ ", description=" + description + "]";
	}

}
