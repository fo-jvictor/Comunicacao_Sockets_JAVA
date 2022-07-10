package questao2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import questao2.Operacoes;

public class ClasseCliente {

	public static void main(String[] args) {		

		Socket socketC;

		System.out.println("\n\n------CLIENTE----------");
		
		try {
			
			socketC = new Socket("localhost",7080);
			
		    ObjectOutputStream out = new ObjectOutputStream(socketC.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socketC.getInputStream());
		    
		    Scanner scanner = new Scanner(System.in);
		    
		    System.out.println("\nInforme dois inteiros para serem operados: ");
		    int operadorUm = scanner.nextInt();
		    int operadorDois = scanner.nextInt();
		    
		    System.out.println("\nAgora informe qual opercao deseja realizar 1 para soma, 2 para subtracao, 3 para multiplicacao e 4 para divisao: ");
		    int operacao = scanner.nextInt(); 
		    
		    System.out.println("\nEnviando objeto para o servidor......");
		    
		    Operacoes operacoes = new Operacoes(operadorUm,operadorDois,operacao);
		    out.writeObject(operacoes);
		    out.flush();
		    
		    System.out.println("\nRecebendo resposta do servidor com a operacao solicitada >>>>> "+input.readInt());
		    input.close();		    
		    scanner.close();
		    socketC.close();		    
		    	    
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
