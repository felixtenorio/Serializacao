package br.univel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteGravacao {

	public static void main(String[] args) {

		Cliente clOriginal = new Cliente();
		clOriginal.setId(1);
		clOriginal.setNome("Hugo");

		File file = new File("arquivo.dat");
		/*try {

			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clOriginal);

			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(clOriginal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
         System.out.println("Foi");
	}

}
