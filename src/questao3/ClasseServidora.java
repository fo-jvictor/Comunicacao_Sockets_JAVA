package questao3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ClasseServidora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket server;
		Socket socketS;		
		
		System.out.println("--------SERVIDOR-------");
		
		try {
			server = new ServerSocket(6543);
			
			while(true)
			{
				System.out.println("\n\nAguardando Conexao.....");
				socketS=server.accept();
				System.out.println("\nConexão estabelecida com o cliente: "+socketS.getInetAddress().getHostName());
				
				System.out.println("\nEnviando as horas para o cliente>>>>");				
				PrintWriter output = new PrintWriter(socketS.getOutputStream());
				output.println(new Date());
				output.flush();
				output.close();
				socketS.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
