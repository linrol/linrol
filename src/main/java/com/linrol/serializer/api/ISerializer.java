package com.linrol.serializer.api;

/**
 * 序列化接口
 * @author linrol
 * @param <T>
 *
 */
public interface ISerializer<T> {

	/**
	 * 序列化方法
	 * @param object 需序列化的对象
	 * @return 返回序列化后的字节数组
	 */
	public <E> byte[] serializer(E object);
	
	/**
	 * 反序列化方法
	 * @param bytes 反序列化的字节数组
	 * @param classes 反序列化类型
	 * @return 返回序列化对象
	 */
	public <E> E deSerializer(byte[] bytes,Class<E> classes);
	
	/**
	 * 序列化到文件
	 * @param object
	 * @param fileName
	 */
	public <E> void serializerFile(E object,String fileName);
	
	/**
	 * 反序列化文件
	 * @param bytes
	 * @param classes
	 * @return
	 */
	public <E> E deSerializerFile(String fileName,Class<E> classes);
}
