package com.retroflix;

public class FitaVHS extends Midia {
	
	public boolean isRewound;
	public int additionalPrice;
	
	@Override
	public int calcPrice() {
		int finalPrice = getPrice();
		if (isRewound) {
			finalPrice = getPrice() + getAdditionalPrice();
		}
		
		return finalPrice;
	}
	
	public void setAdditionalPrice(int additionalPrice) {
		additionalPrice = this.additionalPrice;
	}
	
	public int getAdditionalPrice() {
		return this.additionalPrice;
	}
	
	
}
