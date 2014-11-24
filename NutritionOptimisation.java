/*
 * @author Lee
 */

package main;

/*
 * A class which tells you if you're higher or lower than the GDA values
 */
public class NutritionOptimisation {
	
	/*
	 * Returns the total nutritional values.
	 * @param nutritionalValues An array of the nutritional values for each of the food item.
	 * @return The total nutritional values.
	 */
	public static double[] totalNutrition(double[][] nutritionalValues) {
		double[] totalValues = new double[nutritionalValues[0].length];
		for (int i = 0; i < nutritionalValues.length; i++) {
			for (int j = 0; j < nutritionalValues[i].length; j++) {
				totalValues[j] += nutritionalValues[i][j];
			}
		}
		
		return totalValues;
	}
	
	/*
	 * Returns a string detailing which nutritional values are higher or lower, within 10% either way lower or higher
	 * @param values The total nutritional values of the foods
	 * @param gdaValues The recommended daily values of the person
	 * @param descriptions The names of the GDA values, eg. Calories
	 * @return A string detailing which nutritional values are higher or lower
	 */
	public static String compareToGDA(double[] values, double[] gdaValues, String[] descriptions) {
		String result = "";
		for (int i = 0; i < values.length; i++) {
			double max = gdaValues[i] + 0.1 * gdaValues[i];
			double min = gdaValues[i] - 0.1 * gdaValues[i];
			if (values[i] < min) {
				result += descriptions[i] + " is too small\n";
			} else if (values[i] > max) {
				result += descriptions[i] + " is too large\n";
			}
		}
		
		return result;
	}
	
	/*
	 * Returns a string detailing which nutritional values are higher or lower for a week, within 10% either way lower or higher
	 * @param values The total nutritional values of the foods
	 * @param gdaValues The recommended daily values of the person
	 * @param descriptions The names of the GDA values, eg. Calories
	 * @return A string detailing which nutritional values are higher or lower for a week
	 */
	public static String compareToGDAWeek(double[] values, double[] gdaValues, String[] descriptions) {
		for (int i = 0; i < gdaValues.length; i++) {
			gdaValues[i] = gdaValues[i] * 7;
		}
		String result = "";
		for (int i = 0; i < values.length; i++) {
			double max = gdaValues[i] + 0.1 * gdaValues[i];
			double min = gdaValues[i] - 0.1 * gdaValues[i];
			System.out.println(max + " "  + min);
			if (values[i] < min) {
				result += descriptions[i] + " is too small\n";
			} else if (values[i] > max) {
				result += descriptions[i] + " is too large\n";
			}
		}
		
		return result;
	}

}
