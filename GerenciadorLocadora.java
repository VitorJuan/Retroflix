package atividades.retroflix;

import java.util.ArrayList;

public class GerenciadorLocadora {

	private ArrayList<Midia> midiaDatabase = new ArrayList<Midia>();
	private ArrayList<Locacao> locationsDatabase = new ArrayList<Locacao>();
	
	//cadastrar nova midia
	public void addNewMidia(Midia midia) {
		getMidiaDatabase().add(midia);
	}
	//listar o acervo completo
	public void listMidiaDatabase() {
		for (int x = 0; x < getMidiaDatabase().size(); x++) {
			System.out.println(midiaDatabase.get(x).toString());
		}
	}
	
	//realizar o alguel, associando um cliejte a uma midia
	public void addNewLocation(Cliente client, Midia midia) {
		getLocationsDatabase().add(new Locacao(client, midia));
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
	
	//calculat o total arecado pela locadora
	public int calcTotalLocations() {
		int finalPrice = 0;
		for (int x = 0; x < getLocationsDatabase().size(); x++) {
			finalPrice = finalPrice + getLocationsDatabase().get(x).price;
		}
		return finalPrice;
	}
	
	public ArrayList<Midia> getMidiaDatabase() {
		return this.midiaDatabase;
	}
	
	public ArrayList<Locacao> getLocationsDatabase() {
		return this.locationsDatabase;
	}
}
