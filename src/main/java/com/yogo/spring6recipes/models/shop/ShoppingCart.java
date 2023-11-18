package com.yogo.spring6recipes.models.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.yogo.spring6recipes.models.product.Product;

public class ShoppingCart {

	private final List<Product> items = new ArrayList<>();

	public void addItem(Product item) {
		this.items.add(item);
	}

	public List<Product> getItems() {
		return Collections.unmodifiableList(this.items);
	}

}
