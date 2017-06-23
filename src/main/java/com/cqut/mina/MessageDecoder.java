package com.cqut.mina;


import java.net.SocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;



public class MessageDecoder extends CumulativeProtocolDecoder {
	@SuppressWarnings("unused")
	private final Charset charset;

	public MessageDecoder(Charset charset) {
		super();
		this.charset = charset;
	}

	@SuppressWarnings("unused")
	@Override
	protected boolean doDecode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {

		IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);
		int i = 1;

		MessageObject mobj = new MessageObject();
		String content = "";
		char messageType = 0;

		byte startChar = in.hasRemaining() ? in.get() : 1;
		while (in.hasRemaining()) {
			byte b = in.get();

			if (i == 1) { // 获取消息类型
				messageType = (char) b;
			} else {
				if (b == '\r' || b == '\n' || b == ')') {
					continue;
				} else {
					content += (char) b;
				}
			}

			i++;
		}

		SocketAddress senderAddress = session.getRemoteAddress(); // 获取发送者地址
		SocketAddress receiverAddress = session.getLocalAddress();// 获取接受者地址

		mobj.setType(messageType);
//		mobj.setDescription(Util.getCommandInfo(messageType).getName());
		mobj.setReceiver(receiverAddress.toString());//设置接受者
		mobj.setSender(senderAddress.toString());//设置发送者
		mobj.setContent(content); // 接受的内容
		buffer.flip();
		out.write(mobj);
		return false;
	}

}
