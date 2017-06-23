package com.cqut.mina;

import java.beans.PropertyEditorSupport;
import java.nio.charset.Charset;

public class CharsetEditor extends PropertyEditorSupport {
	private Object value;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text != null)
			this.value = Charset.forName(text);
		else
			this.value = Charset.forName("UTF-8");
	}

	@Override
	public Object getValue() {
		return value;
	}
}
