package com.retroflix;

public class DVD extends Midia{

	public boolean haveExtras;
	public int extra;
	
	@Override
	public int calcPrice() {
		if (haveExtras) {
			price = price + extra;
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
	
	public void setExtra(int extra) {
		this.extra = extra;
	}
	
	public int getExtra() {
		return this.extra;
	}
	
}
