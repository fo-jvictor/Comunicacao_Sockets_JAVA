package questao1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClasseCliente {

	public static void main(String[] args) {
		
		Socket socketC;
		
		System.out.println("\n\n------CLIENTE----------");
		
		try {
			
			socketC = new Socket("localhost",7080);
			
			DataOutputStream out = new DataOutputStream(socketC.getOutputStream());
			DataInputStream input = new DataInputStream(socketC.getInputStream());
			
			
			Scanner in = new Scanner(System.in);
			
			System.out.println("\nEnviando ao servidor");
			out.writeFloat(in.nextFloat());
			out.flush();
			
			System.out.println("\nRecebendo dados do servidor: "+input.readFloat());
			socketC.close();
			in.close();
			out.close();
			input.close();
			System.out.println("\nConexão encerrada com o servidor!");
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
