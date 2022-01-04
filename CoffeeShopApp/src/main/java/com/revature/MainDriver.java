package com.revature;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.revature.model.CoffeeShop;
import com.revature.model.ItemType;
import com.revature.model.MenuItem;

public class MainDriver {
	
	private final Queue<String> orders = new LinkedList<String>();

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		String input = "";
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		boolean isRunning = true;
		CoffeeShop coffeeShop = initialiseCoffeeShop();
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Welcome to " + coffeeShop.getName() + "!");
		
		while(isRunning) {
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("What would you like to do? (Use the number to choose)");
			System.out.println("1) Add an order.");
			System.out.println("2) Fulfill an order.");
			System.out.println("3) List the orders.");
			System.out.println("4) Find the total amount due in all orders.");
			System.out.println("5) Find the cheapest item in the menu.");
			System.out.println("6) Find all drinks in the menu.");
			System.out.println("7) Find all food in the menu.");
			System.out.println("8) Exit the application.");
			System.out.println("------------------------------------------------------------------------------------");
			input = sc.nextLine();
			
			switch(input) {
				case "1":
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println("What item would you like to order?");
					input = sc.nextLine();
					System.out.println(coffeeShop.addOrder(input));
					break;
				case "2":
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println(coffeeShop.fulfillOrder());
					break;
				case "3":
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println(coffeeShop.listOrders());
					break;
				case "4":
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println(formatter.format(coffeeShop.dueAmount()));
					break;
				case "5":
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println(coffeeShop.cheapestItem());
					break;
				case "6":
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println(coffeeShop.drinksOnly());
					break;
				case "7":
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println(coffeeShop.foodOnly());
					break;
				case "8":
					isRunning = false;
					break;
				default:
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println("That's an invalid input!");
					break;
			}
		}
		
		sc.close();
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Thanks for visiting " + coffeeShop.getName() + "!");
	}
	
	private static CoffeeShop initialiseCoffeeShop() {
		CoffeeShop newShop = new CoffeeShop();
		
		newShop.setName("Test Shoppe");
		newShop.setMenu(initialiseMenu());
		
		return newShop;
	}
	
	private static List<MenuItem> initialiseMenu() {
		List<MenuItem> menu = new ArrayList<MenuItem> ();
		
		MenuItem item1 = new MenuItem("Good coffee", ItemType.DRINK, 4.50);
		MenuItem item2 = new MenuItem("Cheap coffee", ItemType.DRINK, 1.00);
		MenuItem item3 = new MenuItem("Premium coffee", ItemType.DRINK, 22.00);
		MenuItem item4 = new MenuItem("Sandwich", ItemType.FOOD, 2.40);
		MenuItem item5 = new MenuItem("Cookie", ItemType.FOOD, 1.50);
		
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		menu.add(item5);
		
		return menu;
	}

}
