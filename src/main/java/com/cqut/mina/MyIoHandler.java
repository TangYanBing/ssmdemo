package com.cqut.mina;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author c102
 *	负责session对象的创建监听
 */
public class MyIoHandler extends IoHandlerAdapter {
	// 这里我们使用的SLF4J作为日志门面，至于为什么在后面说明。
	private final static Logger log =  LoggerFactory
			.getLogger(MyIoHandler.class);

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		super.sessionOpened(session);
	}
	
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
	}
	
	/**
	 * 消息的接收处理
	 */
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
	}
	
	/**
	 * 消息的发送处理
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
	}
}
