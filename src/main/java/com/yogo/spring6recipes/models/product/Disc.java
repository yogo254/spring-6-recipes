package com.yogo.spring6recipes.models.product;

public class Disc extends Product {
	private Double capacity;

	public Disc(String name, Double price, Double capacity) {
		super(name, price);
		this.capacity = capacity;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return  super.toString()+", capacity=" + capacity;
	}

	
	
}
