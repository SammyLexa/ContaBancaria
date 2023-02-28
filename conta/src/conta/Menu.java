package conta;

import conta.util.Cores;

import java.io.IOException;
import java.util.Scanner;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.controller.ContaController;
import conta.model.Conta;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		float saldo, limite, valor;
		String titular;
		
		ContaCorrente cc1= new ContaCorrente (contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f );
		contas.cadastrar(cc1);
		
		ContaCorrente cc2= new ContaCorrente (contas.gerarNumero(), 124, 2, "Marina da Silva", 2000f, 100.0f );
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca (contas.gerarNumero(), 125, 3, "Miguel dos Santos", 4000f, 12 );
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca (contas.gerarNumero(), 126, 4, "Juliana Ramos", 8000f, 15 );
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		while(true) {
			System.out.println(Cores.ANSI_PURPLE_BACKGROUND_BRIGHT + Cores.TEXT_YELLOW+ 
					"***********************************************************************************");
			System.out.println("																			");
			System.out.println("			BANCO DO BRAZIL COM Z											");
			System.out.println("																			");
			System.out.println("***********************************************************************************");
			System.out.println("																			");
			System.out.println("		1 - Criar conta														");
			System.out.println("		2 - Listar todas as contas											");
			System.out.println("		3 - Buscar contas por número										");
			System.out.println("		4 - Atualizar dados da conta										");
			System.out.println("		5 - Apagar conta													");
			System.out.println("		6 - Sacar															");
			System.out.println("		7 - Depositar 														");
			System.out.println("		8 - Transferir	valores entre contas								");
			System.out.println("		9 - Sair															");
			System.out.println("																			");
			System.out.println("***********************************************************************************");
			System.out.println("Entre com a opção desejada:								");
			System.out.println("														");
			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("\nCriar Conta\n");
					
					
					System.out.println(""+ Cores.TEXT_WHITE );
					System.out.println("Digite o Número da Agencia: ");
					agencia = leia.nextInt();
					
					System.out.println("Digite o Nome do Titular: "+ Cores.TEXT_WHITE);
					leia.skip("\\R?");
					titular =  leia.nextLine();
					
					do {
						System.out.println("Digite o Tipo da Conta (1-CC / 2-CP): "+ Cores.TEXT_WHITE);
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
					
					System.out.println("Digite o Saldo da Conta: "+ Cores.TEXT_WHITE);
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1 ->{
							System.out.println("Digite o Limite de Crédito(R$): "+ Cores.TEXT_WHITE);
							limite = leia.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						}
						case 2 ->{
							System.out.println("Digite o dia do Aniversário da Conta: "+ Cores.TEXT_WHITE);
							aniversario = leia.nextInt();
							contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						}
					}

					keyPress();
					
					break;
				case 2:
					System.out.println("Listar todas as Contas\n\n");
					contas.listarTodas();
					
					keyPress();
					break;
				case 3:
					System.out.println("Consultar dados da Conta - por número\n\n");

					System.out.println("Digite o Número da Conta: "+ Cores.TEXT_WHITE);
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);
					
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar dados da Conta\n\n");

					System.out.println( Cores.TEXT_WHITE + "Digite o Número da Conta: ");
					numero = leia.nextInt();
					
					// Condicional para checar se a conta existe
					if(contas.buscarNaCollection(numero) != null) {
						
						System.out.println("Digite o Número da Agencia: "+ Cores.TEXT_WHITE);
						agencia = leia.nextInt();
						
						System.out.println("Digite o Nome do Titular: "+ Cores.TEXT_WHITE);
						leia.skip("\\R?");
						titular =  leia.nextLine();
						
						System.out.println("Digite o Saldo da Conta: "+ Cores.TEXT_WHITE);
						saldo = leia.nextFloat();
						
						tipo = contas.retornaTipo(numero);
						
						
						switch(tipo) {
							case 1 ->{
								System.out.println("Digite o Limite da Conta Corrente: "+ Cores.TEXT_WHITE);
								limite = leia.nextFloat();
								contas.atualizar(new ContaCorrente(numero,agencia, tipo, titular, saldo, limite));
							}
							case 2 ->{
								System.out.println("Digite o Aniversário da Conta Poupança: "+ Cores.TEXT_WHITE);
								aniversario = leia.nextInt();
								contas.atualizar(new ContaPoupanca(numero,agencia, tipo, titular, saldo, aniversario));
							}
							default ->{
								System.out.println("Tipo de conta inválido!" + Cores.TEXT_RED_BOLD);
							}
						}
					}else
						System.out.println("Conta não encontrada!" + Cores.TEXT_RED_BOLD);
							
						
						keyPress();
						break;
				case 5:
					System.out.println("Apagar a Conta\n\n");

					System.out.println("Digite o Número da Conta: "+ Cores.TEXT_WHITE);
					numero = leia.nextInt();
					
					contas.deletar(numero);
					
					keyPress();
					break;
				case 6:
					System.out.println("Saque\n\n");

					System.out.println("Digite o Número da Conta: "+ Cores.TEXT_WHITE);
					numero = leia.nextInt();
					
					
					
					do {
						System.out.println("Digite o Valor do Saque: "+ Cores.TEXT_WHITE);
					valor = leia.nextFloat();
					}while(valor <= 0);
					
					
					contas.sacar(numero, valor);
					
					keyPress();
					break;
				case 7:
					System.out.println("Depósito\n\n");
					
					System.out.println("Digite o Número da Conta: "+ Cores.TEXT_WHITE);
					numero = leia.nextInt();
					
					do {
						System.out.println("Digite o Valor do Depósito: "+ Cores.TEXT_WHITE);
						valor = leia.nextFloat();
					}while(valor <= 0);
					
					contas.depositar(numero, valor);

					keyPress();
					break;
				case 8:
					System.out.println("Transferência entre Contas\n\n");

					System.out.println("Digiite o Número da Conta - Origem: "+ Cores.TEXT_WHITE);
					numero = leia.nextInt();
					
					System.out.println("Digite o Número da Conta - Destino: "+ Cores.TEXT_WHITE);
					numeroDestino = leia.nextInt();
					
					do {
						System.out.println("Digite o Valor da Transferência: "+ Cores.TEXT_WHITE);
						valor = leia.nextFloat();
					}while(valor <= 0);
					
					contas.transferir(numero, numeroDestino, valor);
					
					keyPress();
					break;
				default:
					System.out.println("\nOpção Inválida!\n" + Cores.TEXT_RED_BOLD);
					keyPress();
					break;
			}
		}
		
	}
	
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!" + Cores.TEXT_RED_BOLD);

		}
	}
}