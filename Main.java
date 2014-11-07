package main;

public class Main {
	
	private static String[] shops = {"Tesco", "Asda", "Lidl"};
	private static String[] names = {"Bread", "Eggs", "Milk", "Chicken", "Rice"};
	private static int[][] pricePerKg = {{50,25,60},{100,112,99},{150,250,100},{400,350,499},{25,55,35}};

	public static void main(String[] args) {
		System.out.println("Cheapest shop:" + shops[PriceOptimisation.cheapestShop(pricePerKg)]);
		System.out.println("\nShopping lists such that you spend the minimum");
		String[] temp = PriceOptimisation.minimumBudget(shops, names, pricePerKg);
		for (String s: temp) {
			System.out.println(s);
		}
		System.out.println("\nPrice of that shopping list:" + PriceOptimisation.minimumBudget(pricePerKg));
		System.out.println("\nCheapest 2 shops:" + PriceOptimisation.maxNumberOfShops(2, shops, pricePerKg));
	}

}
