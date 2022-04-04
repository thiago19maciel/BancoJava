package Info_Conta;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Conta Pessoa= new Conta();
		System.out.println("Olá, por favor digite seu nome: ");
		String nome = sc.nextLine();
		Pessoa.setDono(nome);
		Pessoa.abrirConta(nome);
		Pessoa.getStatus();
		Pessoa.sacar();
		Pessoa.depositar();
		Pessoa.fecharConta();
	sc.close();
	}
}
