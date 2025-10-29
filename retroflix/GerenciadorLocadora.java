package atividades.retroflix;

import java.util.ArrayList;

public class GerenciadorLocadora {

	private ArrayList<Midia> midiaDatabase = new ArrayList<Midia>();
	private ArrayList<Locacao> locationsDatabase = new ArrayList<Locacao>();
	private ArrayList<Cliente> clientsDatabase = new ArrayList<Cliente>();
	
	private int midiaIDCounter = 0;
	private int clientIDCounter = 0;
	
	//cadastrar nova midia
	public void addNewMidia(Midia midia) {
		midia.setID(midiaIDCounter);
		getMidiaDatabase().add(midia);
		incrementMediaID();
	}
	
	public boolean removeMidia(String title) {
		for (int x = 0; x < getMidiaDatabase().size(); x++) {
			if (getMidiaDatabase().get(x).getTitulo().equals(title)) {
				getMidiaDatabase().remove(x);
				return true;
			}
		}
		return false;
	}
	
	//realizar o alguel, associando um cliejte a uma midia
	public void addNewLocation(Cliente client, Midia midia) {		
		midia.setIsRented(true);
		getLocationsDatabase().add(new Locacao(client, midia));
	}
	
	public boolean removeLocation(int ID) {
		for (int x = 0; x < getLocationsDatabase().size(); x++) {
			if (getLocationsDatabase().get(x).getID() == ID) {
				getLocationsDatabase().get(x).setIsRented(false);
				getLocationsDatabase().remove(x);
				return true;
			}
		}
		return false;
	}
	
	public void addNewClient(Cliente client) {
		client.setID(clientIDCounter);
		getClientsDatabase().add(client);
		incrementClientID();
	}
	
	public boolean removeClient(String clientName) {
		for (int x = 0; x < getClientsDatabase().size(); x++) {
			if (getClientsDatabase().get(x).getName().equals(clientName) ) {
				getClientsDatabase().remove(x);
				return true;
			}
		}
		return false;
	}
	
	public boolean removeClient(int ID) {
		for (int x = 0; x < getClientsDatabase().size(); x++) {
			if (getClientsDatabase().get(x).getID() == ID) {
				getClientsDatabase().remove(x);
				return true;
			}
		}
		return false;
	}
	
	public Cliente findClientByID(int ID) {
		for (int x = 0; x < getClientsDatabase().size(); x++) {
			if (getClientsDatabase().get(x).getID() == ID) {
				return getClientsDatabase().get(x);
			}
		}
		return null;
	}
	
	public Midia findMediaByID(int ID) {
		for (int x = 0; x < getMidiaDatabase().size(); x++) {
			if (getMidiaDatabase().get(x).getID() == ID) {
				return getMidiaDatabase().get(x);
			}
		}
		return null;
	}
	
	//listar o acervo completo
	public void listMidiaDatabase() {
		for (int x = 0; x < getMidiaDatabase().size(); x++) {
			System.out.println(midiaDatabase.get(x).toString());
		}
	}
	
	//devolver um midia
	public boolean returnMidia(String midiaTitle) {
		for (int x = 0; x < getLocationsDatabase().size(); x++) {
			if (midiaTitle.equals(getLocationsDatabase().get(x).getTitulo())) {
				getLocationsDatabase().remove(x);
				return true;
			}
		}
		return false;
	}
	
	//listar todas as locações realizadas
	public void listAllLocations() {
		for(int x = 0; x < getLocationsDatabase().size(); x++) {
			System.out.println(getLocationsDatabase().get(x).toStirng());
		}
	}
	
	public void listAllClients() {
		for (int x = 0; x < getClientsDatabase().size(); x++) {
			System.out.println(getClientsDatabase().get(x).toString());
		}
	}
	
	//calculat o total arecado pela locadora
	public int calcTotalLocations() {
		int finalPrice = 0;
		for (int x = 0; x < getLocationsDatabase().size(); x++) {
			finalPrice = finalPrice + getLocationsDatabase().get(x).price;
		}
		return finalPrice;
	}
	
	private void incrementClientID() {
		this.clientIDCounter = this.clientIDCounter + 1;
	}
	
	private void incrementMediaID() {
		this.midiaIDCounter = this.midiaIDCounter + 1;
	}
	
	
	public ArrayList<Midia> getMidiaDatabase() {
		return this.midiaDatabase;
	}
	
	public ArrayList<Locacao> getLocationsDatabase() {
		return this.locationsDatabase;
	}
	
	public ArrayList<Cliente> getClientsDatabase() {
		return this.clientsDatabase;
	}
}
