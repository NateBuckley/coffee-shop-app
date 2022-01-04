package com.revature.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CoffeeShop {
	
	private String name;
	
	private List<MenuItem> menu;
	
	private Queue<String> orders;
	
	//adds the name of the item to the end of the orders array if it exists on the menu. Otherwise, return "This item is currently unavailable!"
	public String addOrder(String order) {
		for(MenuItem item : menu) {
			if(item.getItem().equalsIgnoreCase(order)) {
				orders.add(item.getItem());
				return "Your order has been placed!";
			}
		}
		
		return "This item is currently unavailable!";
	}
	
	//if the orders array is not empty, return "The {item} is ready!". If the orders array is empty, return "All orders have been fulfilled!"
	public String fulfillOrder() {
		if(orders.size() == 0) {
			return "All orders have been fulfilled!";
		}
		
		String order = this.orders.poll();
		
		return "The " + order + " is ready!";
	}
	
	//returns the list of orders taken, otherwise, an empty array.
	public String listOrders() {
		StringBuilder orderList = new StringBuilder("Current orders: ");
		
		for(String order : orders) {
			orderList.append(order + "\n");
		}
		
		return orderList.toString();
	}
	
	//returns the total amount due for the orders taken.
	public double dueAmount() {
		double total = 0;
		
		if(this.orders.size() != 0) {
			for(String order : orders) {
				for(MenuItem item : menu) {
					if (item.getItem().equals(order)) {
						total += item.getPrice();
					}
				}
			}
		}
		
		return total;
	}
	
	//returns the name of the cheapest item on the menu.
	public String cheapestItem() {
		MenuItem cheapestItem = new MenuItem("placeholder", ItemType.FOOD, Double.MAX_VALUE);
		
		for(MenuItem item : menu) {
			if(item.getPrice() < cheapestItem.getPrice()) {
				cheapestItem = item;
			}
		}
		
		return cheapestItem.getItem();
	}
	
	//returns only the item names of type drink from the menu.
	public String drinksOnly() {
		StringBuilder drinks = new StringBuilder("Current drinks: ");
		
		for (MenuItem item : menu) {
			if(item.getType().equals(ItemType.DRINK)) {
				drinks.append(item.getItem() + "\n");
			}
		}
		
		return drinks.toString();
	}
	
	//returns only the item names of type food from the menu.
	public String foodOnly() {
		StringBuilder food = new StringBuilder("Current food items: ");
		
		for (MenuItem item : menu) {
			if(item.getType().equals(ItemType.FOOD)) {
				food.append(item.getItem() + "\n");
			}
		}
		
		return food.toString();
	}

	public CoffeeShop(String name, List<MenuItem> menu, Queue<String> orders) {
		super();
		this.name = name;
		this.menu = menu;
		this.orders = orders;
	}

	public CoffeeShop(String name, List<MenuItem> menu) {
		this(name, menu, new LinkedList<String>());
	}
	
	public CoffeeShop(String name) {
		this(name, new ArrayList<MenuItem>());
	}
	
	public CoffeeShop() {
		this("");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuItem> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuItem> menu) {
		this.menu = menu;
	}
	
	

}
