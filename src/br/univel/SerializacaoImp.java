package br.univel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class SerializacaoImp<T> implements Serializador<T> {

	public interface Serializador<T> {

	}

	public void gravar(T t, File file) throws SerializadorException {
		Class<?>[] vet = t.getClass().getInterfaces();

		boolean achou = false;
		for (Class<?> class1 : vet) {
			if (class1.equals(Serializable.class)) {
				achou = true;
				break;
			}
		}
		if (!achou) {
			throw new SerializadorException(" Classe não" + "implmenta serializable.");
		}
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(t);

		} catch (Exception e) {
			throw new SerializadorException(e);// Encapsulamento
		}
	}

	public T ler(File file) throws SerializadorException {
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			Object object = ois.readObject();

			Class<?> clGenType = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];

			if (!object.getClass().equals(clGenType)) {
				throw new SerializadorException("Os tipos são diferentes!");
			}

			return (T) object;
			
		} catch (Exception e) {
			throw new SerializadorException(e);
		}
	}
}
