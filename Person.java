package main;

public class Person {

	private String name;
	private int age;
	private double height;
	private double weight;
	private char gender;
	private int exercise;
	
	public Person(String name, int age, double height, double weight, char gender, int exercise){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.exercise = exercise;
		
	}
	 
	public String toString(){
		String s ="Name: " + name +
				"\nAge: " + age + 
				"\nHeight: " + height + " cm" +
				"\nWeight: " + weight + " kg" +
				"\nGender: " + gender + 
				"\nExercise: " + exercise; 
		return s;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	public double getHeight(){
		return height;
	}
	public double getWeight(){
		return weight;
	}
	public char getGender(){
		return gender;
	}
	public int getExercise(){
		return exercise;
	}

	//use these setters if user changes age weight etc.
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}
	public void setGender(char gender){
		this.gender = gender;
	}
	public void setExercise(int exercise){
		this.exercise = exercise;
	}
	
}