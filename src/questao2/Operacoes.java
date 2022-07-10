package questao2;

import java.io.Serializable;

public class Operacoes implements Serializable {
	
	private int operandoUm;
	private int operandoDois;
	private int operacao;	
		
	public Operacoes() {
		
	}		

	public Operacoes(int operandoUm, int operandoDois, int operacao) {
		super();
		this.operandoUm = operandoUm;
		this.operandoDois = operandoDois;
		this.operacao = operacao;		
	}

	public int getOperandoUm() {
		return operandoUm;
	}

	public void setOperandoUm(int operandoUm) {
		this.operandoUm = operandoUm;
	}

	public int getOperandoDois() {
		return operandoDois;
	}

	public void setOperandoDois(int operandoDois) {
		this.operandoDois = operandoDois;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}	

	@Override
	public String toString() {
		return "Operacoes [operandoUm=" + operandoUm + ", operandoDois=" + operandoDois + ", operacao=" + operacao
				+ "]";
	}
	
}
