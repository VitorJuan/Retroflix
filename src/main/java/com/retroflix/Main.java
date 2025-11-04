package com.retroflix;
import java.util.Scanner;

public class Main {

	GerenciadorLocadora gerenciadorLocadora = new GerenciadorLocadora();
	Scanner in = new Scanner(System.in);

	public static final int ADD_NEW_MEDIA = 1;
	public static final int LIST_ALL_MEDIA = 2;
	public static final int ALLOCATE = 3;
	public static final int RETURN_MEDIA = 4;
	public static final int LIST_ALL_ALLOCATIONS = 5;
	public static final int SHOW_TOTAL_REVENUE = 6;
	public static final int EXIT = 7;
	public static final int ADD_NEW_CLIENT = 8;
	public static final int LIST_ALL_CLIENTS = 9;
  
	public Main() {
		start();
	}

	public void start() {
		System.out.println("Iniciando o sistema de locação...");
		
		userInterfaceHandler();
	}

	private void handleUserOption(int userOption) {
		switch (userOption) {
			
			case ADD_NEW_CLIENT:
				handleAddNewClient();
			break;
		
			case ADD_NEW_MEDIA:
				handleAddNewMedia();
			break;
			
			case LIST_ALL_MEDIA:
				handleListAllMedia();
			break;
			
			case ALLOCATE:
				handleAllocate();
			break;
			
			case RETURN_MEDIA:
				handleReturnMedia();
			break;
			
			case LIST_ALL_ALLOCATIONS:
				handleListAllAllocations();
			break;
			
			case SHOW_TOTAL_REVENUE:
				handleShowTotalRevenue();
			break;
			
			case LIST_ALL_CLIENTS:
				handleListAllClients();
			break;
			
			case EXIT:
				System.out.println("Finalizando o sistema...");
			break;
			
			default:
				System.out.println("Comando não identificado");
			break;
		}
	}
	
	public void handleAddNewClient() {
		clearBuffer();
		Cliente client = new Cliente();
		
		System.out.println("Por favor, digite o nome do cliente");
		client.setName(in.nextLine());
		
		System.out.println("Por favor, digite o email do cliente");
		client.setEmail(in.nextLine());
		
		gerenciadorLocadora.addNewClient(client);
	}
	
	public void handleAddNewMedia() {
		clearBuffer();
		
		System.out.println("Por favor, informe o tipo de media desejado");
		System.out.println("1 - DVD");
		System.out.println("2 - VHS");
		System.out.println("3 - STREAMING");
		
		int userInput = in.nextInt();
		switch (userInput) {
			case 1:
				clearBuffer();
				
				DVD dvd = new DVD();
				System.out.println("Por favor, digite o titulo:");
				dvd.setTitulo(in.nextLine());
				System.out.println("Por favor, digite o preço:");
				dvd.setPrice(in.nextInt());
				
				System.out.println("Deseja adicionar um extra? S/N");
				String input = in.nextLine();
				if (input.equals("S")) {
					dvd.setHaveExtras(true);
					System.out.println("Digite o valor do extra:");
					dvd.setExtra(in.nextInt());
				}
				
				gerenciadorLocadora.addNewMidia(dvd);
			break;
			
			case 2:
				clearBuffer();
				
				FitaVHS vhs = new FitaVHS();
				
				System.out.println("Por favor, digite o titulo:");
				vhs.setTitulo(in.nextLine());
				System.out.println("Por favor, digite o preço:");
				vhs.setPrice(in.nextInt());
				
				gerenciadorLocadora.addNewMidia(vhs);
			break;
			
			case 3:
				clearBuffer();
				
				Streaming streaming = new Streaming();
				
				System.out.println("Por favor, digite o titulo:");
				streaming.setTitulo(in.nextLine());
				System.out.println("Por favor, digite o preço:");
				streaming.setPrice(in.nextInt());
				System.out.println("Por favor, digite a plataforma");
				streaming.setPlatform(in.nextLine());
				
				gerenciadorLocadora.addNewMidia(streaming);
			break;
		}
	}
	
	public void handleListAllMedia() {
		System.out.println("Todas as midias cadastradas: ");
		gerenciadorLocadora.listMidiaDatabase();
	}
	
	public void handleListAllClients() {
		System.out.println("Todos os clientes cadastrados: ");
		gerenciadorLocadora.listAllClients();
	}
	
	public void handleAllocate() {
		System.out.println("Por favor, insira o ID do cliente:");
		int clientID = in.nextInt();
		
		System.out.println("Por favor, insira o ID da midia:");
		int mediaID = in.nextInt();
		
		gerenciadorLocadora.addNewLocation(gerenciadorLocadora.findClientByID(clientID), gerenciadorLocadora.findMediaByID(mediaID));
	}
	
	public void handleReturnMedia() {
		System.out.println("Por favor, digite o ID da midia a devolver:");
		int mediaID = in.nextInt();
		
		gerenciadorLocadora.removeLocation(mediaID);
	}
	
	public void handleListAllAllocations() {
		System.out.println("Lista de todas as locações:");
		gerenciadorLocadora.listAllLocations();
	}
	
	public void handleShowTotalRevenue() {
		System.out.println("Total de lucro: " + gerenciadorLocadora.calcTotalLocations());
	}
	
	public void userInterfaceHandler() {

  		int input = 0;

	    do {

			System.out.println("Menu");
			System.out.println("1 - Para cadasra nova midia");
			System.out.println("2 - Listar todas as midias cadastradas");
			System.out.println("3 - Realizar uma Locação");
			System.out.println("4 - Devolver uma midia");
			System.out.println("5 - Listar o histórico de Alocações");
			System.out.println("6 - Mostrar o total arrecadado");
			System.out.println("8 - Adicionar novo cliente");
			System.out.println("9 - Listar todos os clientes cadastrados");
			System.out.println("7 - Sair do Sistema");
		
			input = in.nextInt();
			handleUserOption(input);
	    }
	    while(input!=7);
	    System.out.println("Saindo...");
  	}

	private void clearBuffer() {
		in.nextLine();
	}
	
	public static void main (String [] args) {
		new Main();
	}
}
