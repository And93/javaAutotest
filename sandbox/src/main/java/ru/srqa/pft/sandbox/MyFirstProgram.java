package ru.srqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] arg) {

        hello("Andrei");

        Square s = new Square(50.8);
        System.out.println("The area of a square with a side: " + s.l + " is: " + s.area() + "\n");

        Rectangle r = new Rectangle(24, 978.999);
        System.out.println("The area of a rectangle with a side a: " + r.a +
                ", and b: " + r.b + " is: " + r.area() + "\n");
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!\n");
    }
}
