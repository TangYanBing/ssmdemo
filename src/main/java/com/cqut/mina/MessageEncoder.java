package com.cqut.mina;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * 
 * @author lxr
 * @description 依据传入的字符集类型对 message 对象进行编码
 */
public class MessageEncoder extends ProtocolEncoderAdapter {
	private final Charset charset;
	
	public MessageEncoder(Charset charset) {
		super();
		this.charset = charset;
	}


	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out)
			throws Exception {
		// TODO Auto-generated method stub
		MessageObject mobj = (MessageObject) message; //将 encode()方法中的 message 对象强制转换为指定的对象类型;
		CharsetEncoder ce = charset.newEncoder();
		IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);//创建缓冲区，并设置自动扩展
		

		/*
		 * 将转换后的 message 对象中的各个部分按照指定的应用层协议进行组装，并 put()到IoBuffer 缓冲区;
		 * */
		String content = mobj.getContent();
		buffer.putString("("+mobj.getType()+content+")", ce);
		
		/*
		 * 当你组装数据完毕之后，调用 flip()方法，为输出做好准备，
		 * 切记在 write()方法之前，要调用 IoBuffer 的 flip()方法，
		 * 否则缓冲区的 position 的后面是没有数据可以用来输 出的，
		 * 你必须调用 flip()方法将 position 移至 0，limit 移至刚才的 position。
		 * */
		buffer.flip();
		out.write(buffer);//最后调用 ProtocolEncoderOutput 的 write()方法输出 IoBuffer 缓冲区实例
	}

}
