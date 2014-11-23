package main;

public class Main {
	
	private static String[] shops = {"Tesco", "Asda", "Lidl"};
	private static String[] names = {"Bread", "Eggs", "Milk", "Chicken", "Rice"};
	private static int[][] pricePerKg = {{50,25,60},{100,112,99},{150,250,100},{400,350,499},{25,55,35}};
	private static double[][] nutritionalValues = {{266, 7.64, 50.61, 4.31, 3.29, 0.717, 2.4, 0.681},
		{74, 6.29, 0.38, 0.38, 4.97, 1.55, 0, 0.07},
		{146, 7.86, 11.03, 12.83, 7.93, 4.551, 0, 0.098},
		{164, 24.82, 0, 0, 6.48, 1.824, 0, 0.33},
		{204, 4.2, 44.08, 0.08, 0.44, 0.12, 0.6, 0.577}
	};

	public static void main(String[] args) {
		System.out.println("Cheapest shop:" + shops[PriceOptimisation.cheapestShop(pricePerKg)]);
		System.out.println("\nShopping lists such that you spend the minimum");
		String[] temp = PriceOptimisation.minimumBudget(shops, names, pricePerKg);
		for (String s: temp) {
			System.out.println(s);
		}
		System.out.println("\nPrice of that shopping list:" + PriceOptimisation.minimumBudget(pricePerKg));
		System.out.println("\nCheapest 2 shops:" + PriceOptimisation.maxNumberOfShops(2, shops, pricePerKg));
		
		System.out.println("\nTotal Nutritional Values");
		String[] descriptions = {"Calories", "Protein", "Carbohydrates", "Sugars", "Fat", "Saturates", "Fibre", "Salt"};
		String[] units = {" kcal", " g", " g", " g", " g", " g", " g", " g"};
		double[] values = NutritionOptimisation.totalNutrition(nutritionalValues);
		for (int i = 0; i < values.length; i++) {
			System.out.println(descriptions[i] + ": " + values[i] + units[i]);
		}
		
		Person person = new Person("Charlie", 20, 182.88, 65, 'M', 3);
		GDA gda = new GDA(person);
		
		System.out.println("\n" + NutritionOptimisation.compareToGDA(values, gda.getGDA(), descriptions));
		
	}

}
