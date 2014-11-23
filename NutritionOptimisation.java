package main;

public class NutritionOptimisation {
	
	public static double[] totalNutrition(double[][] nutritionalValues) {
		double[] totalValues = new double[nutritionalValues[0].length];
		for (int i = 0; i < nutritionalValues.length; i++) {
			for (int j = 0; j < nutritionalValues[i].length; j++) {
				totalValues[j] += nutritionalValues[i][j];
			}
		}
		
		return totalValues;
	}
	
	public static String compareToGDA(double[] values, double[] gdaValues, String[] descriptions) {
		String result = "";
		for (int i = 0; i < values.length; i++) {
			double max = gdaValues[i] + 0.2 * gdaValues[i];
			double min = gdaValues[i] - 0.2 * gdaValues[i];
			if (values[i] < min) {
				result += descriptions[i] + " is too small\n";
			} else if (values[i] > max) {
				result += descriptions[i] + " is too large\n";
			}
		}
		
		return result;
	}

}
