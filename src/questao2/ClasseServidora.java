package questao2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;

public class ClasseServidora {

	public static void main(String[] args) {

		// A Aplicação cliente deve permitir que o usuário faça a leitura de dois
		// valores
		// inteiros e um operador aritmético a partir do console e então, enviar esses
		// três
		// valores para o lado do servidor. O servidor, por sua vez, deverá efetuar o
		// cálculo sobre esses
		// dois inteiros, e enviar de volta o resultado da operação para o lado do
		// cliente.
		// O cliente deverá mostrar o resultado para o usuário.Utilize as classes
		// ObjectInputStream e
		// ObjectOutputStream para envio e recebimento de dados.

		ServerSocket server;
		Socket socketS;

		System.out.println("\n---------CLASSE SERVIDORA--------");

		try {
			server = new ServerSocket(7080);
			System.out.println("\nAguardando conexao!");
			socketS = server.accept();
			System.out.println("\nConexao estabelecida com o cliente : " + socketS.getInetAddress().getHostName());

			ObjectInputStream input = new ObjectInputStream(socketS.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socketS.getOutputStream());

			System.out.println("\nRecebendo dados do cliente....");

			Operacoes ops = (Operacoes) input.readObject();

			int opUm = ops.getOperandoUm();
			int opDois = ops.getOperandoDois();
			int op = ops.getOperacao();
			int res=0;
			
			if (op == 1) {
				res = somaOp(opUm, opDois);
			}
			if (op == 2) {
				res = subtraiOp(opUm, opDois);
			}
			if (op == 3) {
				res = multiplicaOp(opUm, opDois);
			}
			if (op == 4) {
				res = divideOp(opUm, opDois);
			}
			
			System.out.println("\nEnviando resultado da operacao para o cliente>>> " + res);
			out.writeInt(res);
			out.flush();

			System.out.println("\n\nFECHANDO CONEXAO");
			out.close();
			socketS.close();
			input.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static int somaOp(int a, int b) {
		return a + b;
	}

	public static int subtraiOp(int a, int b) {
		return a - b;
	}

	public static int multiplicaOp(int a, int b) {
		return a * b;
	}

	public static int divideOp(int a, int b) {
		return a / b;
	}

}
