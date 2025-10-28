package atividades.retroflix;

public class DVD extends Midia{

	public boolean haveExtras;
	
	@Override
	public int calcPrice() {
		if (haveExtras) {
			price = price + 30;
		}
		price = price + 20;
		return price;
	}
	
	public void setHaveExtras(boolean haveExtras) {
		this.haveExtras = haveExtras;
	}
	
	public boolean getHaveExtras() {
		return this.haveExtras;
	}
	
}
