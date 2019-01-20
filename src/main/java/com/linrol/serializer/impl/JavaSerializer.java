package com.linrol.serializer.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.linrol.serializer.api.ISerializer;

public class JavaSerializer<T> implements ISerializer<T> {

	/**
	 * java序列化实现
	 */
	@Override
	public <E> byte[] serializer(E object) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(byteArrayOutputStream != null) {
				try {
					byteArrayOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * java反序列化实现
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <E> E deSerializer(byte[] bytes, Class<E> classes) {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			Object object = objectInputStream.readObject();
			if(classes.isInstance(object)) {
				return (E) object;
			}else {
				throw new ClassCastException("not convert " + classes.getTypeName());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(byteArrayInputStream != null) {
				try {
					byteArrayInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public <E> void serializerFile(E object, String fileName) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(isExistFile(fileName));
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E deSerializerFile(String fileName, Class<E> classes) {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			if(classes.isInstance(object)) {
				return (E) object;
			}else {
				throw new ClassCastException("not convert " + classes.getTypeName());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private File isExistFile(String fileName) {
		File file = new File(fileName);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
}
