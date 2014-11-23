package main;

public class GDA {
	
	private double calories;
	private double protein;
	private double carbs;
	private double sugars;
	private double fat;
	private double saturates;
	private double fibre;
	private double salt;
	
	//this will just work out ratios from the calories, need to  use toGrams() to convert and round
	public GDA(Person p){
		calories = findTDEE(p);
		protein = 0.022 * calories;
		carbs = 0.118 * calories;
		sugars = 0.043 * calories;
		fat = 0.037 * calories;
		saturates = 0.011 * calories;
		fibre = 0.011 * calories;
		salt = 0.003 * calories;
	}
	

	public String toString(){
		String s = "Calories: " + toKcal(calories) + " kcal" +
				"\nProtien: " + toGrams(protein) + " g" +
				"\nCarbohydrates: " + toGrams(carbs) + " g" +
				"\nSugars: " + toGrams(sugars) + " g" +
				"\nFat: " + toGrams(fat) + " g" +
				"\nSaturates: " + toGrams(saturates) + " g" +
				"\nFibre: " + toGrams(fibre) + " g" +
				"\nSalt: " + toGrams(salt) +  " g";
		return s;
	}
	
	public double[] getGDA() {
		double[] values = {calories, protein, carbs, sugars, fat, saturates, fibre, salt};
		return values;
	}
	
	//work out persons total daily expendature of enenergy
	public static double findTDEE(Person p){
		double BMR;
		double TDEE = 0;
		if(p.getGender() == 'M')
			BMR = 66 + (13.70 * p.getWeight()) + (5.00 * p.getHeight()) - (6.8 * p.getAge());
		else
			BMR = 655 + (9.6 * p.getWeight()) + (1.8 * p.getHeight()) - (4.7 * p.getAge());
		//desk job with little exercise
		if(p.getExercise() == 1)
			TDEE = 1.2 * BMR;
		//1-3hrs/week of light exercise
		if(p.getExercise() == 2)
			TDEE = 1.375 * BMR;
		//3-5hrs/week of moderate exercise
		if(p.getExercise() == 3)
			TDEE = 1.55 * BMR;
		//5-6hrs/week of strenuous exercise
		if(p.getExercise() == 4)
			TDEE = 1.725 * BMR;
		//7-21hrs/week of strenuous exercise/work
		if(p.getExercise() == 5)
			TDEE = 1.9 * BMR;
		return TDEE;
	}
	//converts and rounds to 2 decimal place
	public double toGrams(double x){
		double sum = x*0.25;
		int multiplier = 100;
		sum = Math.round(sum * multiplier)/ (double)multiplier;
		return sum;
	}
	//converts and rounds to 2 decimal place
	public double toKcal(double x){
		int multiplier = 100;
		return Math.round(x * multiplier)/ (double)multiplier;
	}
	
/**
	@author Ruaraidh
	Main method
	
	**/
	public static void main(String[] args) {
	
		//System.out.println("What is your name?");
		String name = "Charlie";
		//System.out.println("What is your age?");
		int age = 20;
		//System.out.println("What is your height?");
		//in cm
		double height = 182.88;
		//System.out.println("What is your weight?");
		//in kg
		double weight = 65;
		//System.out.println("What is your gender?");
		char gender = 'M';
		//System.out.println("What is your exercise level?");
		int exercise = 3;
		
		Person person1 = new Person(name, age, height, weight, gender, exercise);
		GDA gda1 = new GDA(person1);
		System.out.println(person1.toString());
		System.out.println("------------------------");
		System.out.println(gda1.toString());
	}
}