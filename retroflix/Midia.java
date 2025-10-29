package atividades.retroflix;

public abstract class Midia {
	String title;
	int price;
	boolean isRented;
	int ID;
	
	public abstract int calcPrice();
	
	public void setTitulo(String title) {
		this.title = title;
	}
	
	public String getTitulo() {
		return this.title;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setIsRented(boolean isRented) {
		this.isRented = isRented;
	}
	
	public boolean getIsRented() {
		return this.isRented;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String toString() {
		return "ID: " + getID() + " Titulo: " + getTitulo() + " Preço: " + getPrice() + " Alocado: " + getIsRented();
	}
}
