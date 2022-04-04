package Info_Conta;
import java.util.Scanner;

class Conta{
	Scanner sc = new Scanner(System.in);
	
	public int numConta;
	protected String tipo;
	private String dono;
	private double saldo;
	private String status;
	
	
	public int getNumConta() {
		return numConta;
	}


	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDono() {
		return dono;
	}


	public void setDono(String dono) {
		this.dono = dono;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public String getStatus() {
		System.out.println("\n\t\tConta do cliente " + this.getDono() +
				"\n\t  Status da conta: " + this.status +
				"\n\t  Tipo de conta: " + this.getTipo() +
				"\n\t  Saldo: R$" + this.getSaldo() + "\n");
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public void abrirConta(String Nome) {
		System.out.print("Oi " + Nome + "! Sua conta esta " + this.status +
				"! \nDigite ct para Conta Corrente \nDigite cp para Conta Poupanca" + 
				"\nQue tipo de conta deseja abrir: ");
		String Tipo;
		do {
			Tipo = sc.nextLine();
			if (Tipo.equals("ct")) {
				this.saldo = 50;
			}else if (Tipo.equals("cp")) {
				this.saldo = 150;
			} else {
				System.out.println("Erro! Digite novamente: ");
			}
 			
		}while (!Tipo.equals("ct") && !Tipo.equals("cp"));
	
		this.tipo = Tipo;
		this.status = "aberta";
	}
	
	public void fecharConta() {
		do {
			if (this.saldo > 0) {
				System.out.println("Para fechar a conta, voce deve sacar R$" + this.saldo);
				this.sacar();
			}else if (this.saldo < 0){
				System.out.println("Para fechar a conta, voce deve quitar seu débito de R$" + this.saldo);
				this.depositar();
			}else {
				this.status = "fechada";
				System.out.println("\nFechando conta");
			}
		}while (this.saldo != 0);
		System.out.println("Pronto! Sua conta foi fechada. Obrigado por usar o nosso banco :)");
	}
	
	public void depositar() {
		System.out.print("Digite o valor que deseja depositar: R$");
		int valor = sc.nextInt();
		System.out.println("Antigo saldo: R$" + this.saldo + "\nNovo saldo: R$" + (this.saldo + valor) + "\n");
		this.saldo += valor;
	}
		
	
	public void sacar() {
		double valor;
		do {
		System.out.print("\nDigite o valor que deseja sacar: ");
		valor = sc.nextDouble();
		if (this.saldo < valor) {
			System.out.println("Nao pode sacar R$" + valor + "\nSeu saldo é de R$" + this.saldo);
		}
		}while (valor > this.getSaldo());
		
		System.out.println("Sacando R$" + valor);
		this.saldo -= valor;
		System.out.println("Foi sacado R$" + valor + "\nNovo saldo: R$" + this.getSaldo() + "\n");
	}
	
	public void pagarMensal() {
		int mensalidade = 0;
		if (this.tipo == "ct") {
			mensalidade = 12;
		}else {
			mensalidade = 20;
		}
		if (saldo >= mensalidade){
			System.out.println("Pagando mensalidade no valor de R$" + mensalidade);
			saldo -= mensalidade;
		}else {
			System.out.println("Saldo insuficiente para pagar mensalidade!");
		}
	}
	
	public Conta(){
		this.saldo = 0;
		this.status = "fechada";
	}
}
