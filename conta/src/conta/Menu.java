package conta;

import conta.util.Cores;

import java.util.Scanner;

import conta.model.Conta;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		Conta c1 = new Conta(1, 123, 1, "Samantha Alexandra Pereira", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		int opcao;
		
		while(true) {
			System.out.println(Cores.ANSI_PURPLE_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_BOLD_BRIGHT+ 
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
			
			if(opcao == 9) {
				System.out.println("\nBANCO DO BRAZIL COM Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT+ "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				break;
				
			}
		
		
		}
	}

}
