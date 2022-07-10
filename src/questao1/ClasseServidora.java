package questao1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClasseServidora {
	
	public static void main(String[] args) {
		
		ServerSocket server;
		Socket socketS;
		
		System.out.println("--------SERVIDOR-------");
		
		try {
			
			server =  new ServerSocket(7080);
			System.out.println("\nAguardando conexão!");
			socketS = server.accept();
			System.out.println("\nConexão estabelecida com o cliente : "+socketS.getInetAddress().getHostName());
			DataInputStream input = new DataInputStream(socketS.getInputStream());
			DataOutputStream out = new DataOutputStream(socketS.getOutputStream());
			
			float raio = input.readFloat();
			System.out.println("\nDados recebidos do cliente>>> "+raio);
			
			
			//float r = input.readFloat();
			float area = (float) (3.14 * raio * raio);
			
			System.out.println("\nEnviando ao cliente >>>");
			out.writeFloat(area);
			out.flush();
			input.close();
			socketS.close();
			
			System.out.println("Conexão Encerrada com o cliente!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
