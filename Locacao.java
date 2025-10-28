package atividades.retroflix;

import java.util.HashMap;
import java.util.ArrayList;

public class Locacao extends Midia{
	
	private Cliente client;
	private Midia midia;
	private int daysOAllocation;
	private boolean isFinished;
	
	public Locacao(Cliente client, Midia midia) {
		this.client = client;
		this.midia = midia;
	}

	@Override
	public int calcPrice() {
		return getDaysOfAllocation() * getMidia().price;
	}
	
	public void setDaysOfAllocation(int daysOfAllocation) {
		this.daysOAllocation = daysOfAllocation;
	}
	
	public int getDaysOfAllocation() {
		return this.daysOAllocation;
	}
	
	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	
	public boolean getIsFinished() {
		return this.isFinished;
	}
	
	public Cliente getClient() {
		return this.client;
	}
	
	public Midia getMidia() {
		return midia;
	}
	
	public String toStirng() {
		return "Nome do Cliente: " + client.getName() + " " + midia.toString() + " Dias alocados: " + getDaysOfAllocation() + " Preço: " + getPrice() + " Foi finalizado" + getIsFinished();
	}
}
