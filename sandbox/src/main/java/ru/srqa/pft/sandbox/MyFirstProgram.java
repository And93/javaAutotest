package ru.srqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] arg) {
	    hello("Andrei");

	    double l = 5.6;

        System.out.println("The area of a square with a side: " + l + " is: " + area(l) + "\n");

        double a = 54;
        double b = 11;

        System.out.println("The area of a rectangle with a side a: " + a +
                ", and b: " + b + " is: " + area(a,b) + "\n");
	}

	public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!\n");
    }

    public static double area(double l) {
	    return l * l;
    }

    public static double area(double a, double b) {
	    return a * b;
    }

}