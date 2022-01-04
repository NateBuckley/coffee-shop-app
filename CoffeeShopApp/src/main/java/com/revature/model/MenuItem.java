package com.revature.model;

public class MenuItem {
	
	private String item;
	
	private ItemType type;
	
	private double price;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0.00) {
			this.price = price;
		} else {
			this.price = 0.00;
		}
		
	}

	public MenuItem(String item, ItemType type, double price) {
		super();
		this.item = item;
		this.type = type;
		this.price = price;
	}
	
	public MenuItem() {
		this("placeholder", ItemType.FOOD, 0.00);
	}

	@Override
	public String toString() {
		return "MenuItem [item=" + item + ", type=" + type + ", price=" + price + "]";
	}

}
