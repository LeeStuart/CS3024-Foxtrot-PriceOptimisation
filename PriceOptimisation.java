package main;

public class PriceOptimisation {
	
	// Will return the shop where your shopping list will be cheapest
	public static int cheapestShop(int[][] pricePerKg) {
		
		// Creating an array to keep track of total price
		int[] totalPrice = {0,0,0};
		
		// Looping through the prices adding them to the total price
		for (int i = 0; i < pricePerKg.length; i++) {
			for (int j = 0; j < pricePerKg[i].length; j++) {
				totalPrice[j] += pricePerKg[i][j];
			}
		}
		
		// Finding the minimum price
		int min = findMinimum(totalPrice);
		
		return min;
	}
	
	// Will return what to buy from each shop, such that you spend the absolute minimum
	public static String[] minimumBudget(String[] shops, String[] names, int[][] pricePerKg) {
		
		// Creating a array of strings to keep track of what you'll need to buy from each shop
		String[] lists = {shops[0] + ": ", shops[1] + ": ", shops[2] + ": "};
		
		// Looping through all the prices, and finding the minimum price of each item,
		// and adding that item to the correct list
		for (int i = 0; i < names.length; i++) {
			int min = findMinimum(pricePerKg[i]);
			lists[min] += names[i] + ", ";
		}
		return lists;
	}
	
	// Returns the total price for the shop, such that you spend the absolute minimum
	public static int minimumBudget(int[][] pricePerKg) {
		int totalPrice = 0;
		for (int i = 0; i < pricePerKg.length; i++) {
			int min = findMinimum(pricePerKg[i]);
			totalPrice += pricePerKg[i][min];
		}
		return totalPrice;
	}
	
	// Returns a the shops you'll visit based on how many you want to visit, such that you'll
	// pay the absolute minimum
	public static String maxNumberOfShops(int number, String[] shops, int[][] pricePerKg) {
		
		if (number == 1) {
			// if you only want to visit 1 shop, just return the cheapest shop
			return shops[cheapestShop(pricePerKg)];
		} else if (number > 1) {
			// calculating the number of different combinations of shops there are
			int n = shops.length;
			int r = number;
			int noCombinations = factorial(n) / (factorial(n - r) * factorial(r));
			
			// setting up a combinations variable to keep track of all of the different combinations of shops
			// and setting up an array to keep track of the current position when iterating through the combinations 
			int[][] combinations = new int[noCombinations][];
			int[] currentPlace = new int[number];
			for (int i = 0; i < number; i++) {
				currentPlace[i] = i;
			}
			
			// iterating through the combinations to work out all the different combinations of shops
			for (int i = 0; i < noCombinations; i++) {
				combinations[i] = currentPlace.clone();
				currentPlace[number - 1]++;
				for (int j = number - 1; j >= 0; j--) {
					if (currentPlace[j] >= n) {
						currentPlace[j - 1]++;
						currentPlace[j] = currentPlace[j - 1] + 1;
					}
				}
			}
			
			// going through the combinations and calculating the total price for each combination
			int[] totalPrices = new int[combinations.length];
			for (int i = 0; i < combinations.length; i++) {
				// creating a temporary array to hold price, so I can remove the prices for shops I don't need
				int[][] tempPricePerKg = new int[pricePerKg.length][];
				for (int j = 0; j < pricePerKg.length; j++) {
					tempPricePerKg[j] = new int[combinations[i].length];
					int currentPos = 0;
					for (int h = 0; h < pricePerKg[i].length; h++) {
						if (contains(combinations[i], h)) {
							tempPricePerKg[j][currentPos] = pricePerKg[j][h];
							currentPos++;
						}
					}
				}
				totalPrices[i] = minimumBudget(tempPricePerKg);
			}
			
			// finding the minimum of the total prices
			int min = findMinimum(totalPrices);
			
			// getting the shops' names of the combination that produces the lowest price
			String output = "";
			for (int i = 0; i < combinations[min].length; i++) {
				output += shops[combinations[min][i]] + ", ";
			}
			return output;
		} else {
			return "";
		}
	}
	// finds mininum
	public static int findMinimum(int[] array) {
		int min = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[min]) {
				min = i;
			}
		}
		return min;
	}
	
	public static boolean contains(int[] array, int value) {
		for (int i: array) {
			if (i == value) {
				return true;
			}
		}
		return false;
	}
	
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
