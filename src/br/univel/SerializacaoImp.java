package br.univel;

import java.io.File;


public class SerializacaoImp extends SerializadorException<T> {
	
	
	
	
	public interface Serializador<T>{
		

		
	}

	public void gravar(T t, File file) throws SerializadorException{

		
	}

	
	
	public  T ler(File file) throws SerializadorException {
		return null;
	}
}

