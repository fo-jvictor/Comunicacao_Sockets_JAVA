package questao3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClasseCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket socketC;
		System.out.println("\n\n-------------CLIENTE---------------");
		
		try {
			socketC = new Socket("localhost",6543);
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socketC.getInputStream()));
			
			System.out.println("\nRecebendo as horas do servidor>>>"+input.readLine());
			
			socketC.close();
			input.close();
			
			System.out.println("\nConexao encerrada com o servidor!!");
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
