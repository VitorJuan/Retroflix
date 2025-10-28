package atividades.retroflix;

public class Streaming extends Midia{

	private String platform;
	private int descount = 20;
	
	@Override
	public int calcPrice() {
		//aplicando o desconto
		return (descount / price) * 100;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getPlatform() {
		return this.platform;
	}
	
}
