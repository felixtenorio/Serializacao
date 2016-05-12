package br.univel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteLeitura {

	public static void main(String[] args) {

		File file = new File("arquivo.dat");
		/*
		 * try {
		 * 
		 * fis = new FileInputStream(file); ObjectInputStream ois = new
		 * ObjectInputStream(fis);
		 * 
		 * Cliente clLido = (Cliente) ois.readObject();
		 * 
		 * 
		 * System.out.println(clLido.getId());
		 * System.out.println(clLido.getNome());
		 * 
		 * ois.close(); fis.close();
		 * 
		 * } catch (FileNotFoundException e) { e.printStackTrace();
		 * }catch(IOException e){ e.printStackTrace();
		 * }catch(ClassNotFoundException e){ e.printStackTrace(); } }
		 */
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			Cliente clLido = (Cliente) ois.readObject();

			System.out.println(clLido.getId());
			System.out.println(clLido.getNome());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
