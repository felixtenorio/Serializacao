package br.univel;

import java.io.File;

public class TesteSerializador {
	
	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		c.setId(1);
		c.setNome("Antônio");

		File file = new File("arquivo2.dat");
		SerializacaoImp<Cliente> ser = new SerializacaoImp(){};
		
		try {
			ser.gravar(c, file);
			
			Cliente cLido = ser.ler(file);
			
			System.out.println(cLido.getId());
			System.out.println(cLido.getNome());
			
		} catch (SerializadorException e) {
			e.printStackTrace();
		}
	}

}
