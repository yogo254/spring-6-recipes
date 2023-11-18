package com.yogo.spring6recipes.models.product;

public class Battery extends Product {
	private boolean rechargeble;

	public Battery(String name, Double price, boolean rechargeble) {
		super(name, price);
		this.rechargeble = rechargeble;
	}

	public boolean isRechargeble() {
		return rechargeble;
	}

	public void setRechargeble(boolean rechargeble) {
		this.rechargeble = rechargeble;
	}

	@Override
	public String toString() {
		return super.toString() + ", rechargeble=" + rechargeble;
	}

}
