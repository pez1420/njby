package com.ruijie.framework.kyo.session.serialization.java;

import com.ruijie.framework.kyo.common.extension.Adaptive;
import com.ruijie.framework.kyo.session.serialization.Serialization;
import com.ruijie.framework.kyo.session.serialization.SerializationFactory;
@Adaptive("java")
public class NativeJavaSerializationFactory implements SerializationFactory {

	
	public Serialization getSerialization() {
		return new NativeJavaSerialization();
	}

}
