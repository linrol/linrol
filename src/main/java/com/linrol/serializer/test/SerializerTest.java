package com.linrol.serializer.test;

import java.io.Serializable;

import com.linrol.serializer.api.ISerializer;
import com.linrol.serializer.impl.JavaSerializer;

public class SerializerTest implements Serializable {



	public static void main(String[] args) {
		// 构建序列器
		ISerializer<SerializerTest> javaSerializer = new JavaSerializer<SerializerTest>();
		// 准备序列化对象
		SerializerTest serializerObject = new SerializerTest();
		serializerObject.setId("123987");
		serializerObject.setVersion("001");
		
		// 序列化对象
		byte[] data = javaSerializer.serializer(serializerObject);
		SerializerTest.num = 10;
		
		// 反序列化对象
		SerializerTest deSerializerObject = javaSerializer.deSerializer(data, SerializerTest.class);
		
		// 比较测试
		System.out.println(serializerObject + "...." + deSerializerObject);
		System.out.println(serializerObject.getId() + "...." + deSerializerObject.getId());
		System.out.println(serializerObject.getVersion() + "...." + deSerializerObject.getVersion());
		System.out.println(serializerObject.num + "..." + SerializerTest.num + "...." + deSerializerObject.num);
		
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4513135433819843481L;
	
	private String id;
	
	private String version;
	
	public static int num = 5;
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
