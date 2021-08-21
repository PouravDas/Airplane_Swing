package com.test.model;

public class Airplane {
	
	private int lenght;
	private int bredth;
	
	public Airplane(int lenght, int bredth) {
		super();
		this.lenght = lenght;
		this.bredth = bredth;
	}
	
	public Airplane() {
		
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int getBredth() {
		return bredth;
	}

	public void setBredth(int bredth) {
		this.bredth = bredth;
	}
}
