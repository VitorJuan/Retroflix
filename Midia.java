package atividades.retroflix;

public abstract class Midia {
	String title;
	int price;
	boolean isRented;
	
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
	
	public String toString() {
		return "Titulo: " + getTitulo() + " Preço: " + getPrice() + " Alocado: " + getIsRented();
	}
}
