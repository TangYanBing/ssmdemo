package com.cqut.mina;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class MessageCodecFactory implements ProtocolCodecFactory{
	private final MessageDecoder decoder;
	
	private final MessageEncoder encoder;
	
	
	public MessageCodecFactory() {
		this(Charset.defaultCharset());
	}

	public MessageCodecFactory(Charset charSet){
		this.decoder = new MessageDecoder(charSet);
		this.encoder = new MessageEncoder(charSet);
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return encoder;
	}
}
