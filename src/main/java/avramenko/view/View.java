package main.java.avramenko.view;

import main.java.avramenko.model.Point;

import java.util.Scanner;
import java.util.*;

public class View {

    public void printMenu() {
        System.out.println("1. Create collection.");
        System.out.println("2. Generate collection.");
        System.out.println("3. Exit.");
    }

    public int readNumber() {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Not a number.");
                sc.next();
            }
            n = sc.nextInt();
        } while (n < 0);
        return n;
    }

   public int readCoordinate(){
       Scanner sc = new Scanner(System.in);
       int number;
       while (!sc.hasNextInt()) {
           System.out.println("Not a number.");
           sc.next();
       }
       number = sc.nextInt();
       return number;
   }

    public void printMessage(Messages messages) {
        switch (messages) {
            case CHOOSE:
                System.out.println("Choose number: ");
                break;
            case ENTER_POINT_X:
                System.out.print("x:");
                break;
            case ENTER_POINT_Y:
                System.out.print("y:");
                break;
            case ENTER_AMOUNT:
                System.out.println("How many points do you want to add?");
                break;
            case SUCCESSFUL:
                System.out.println("Successful operation.");
                break;
            case SOMETHING_WRONG:
                System.out.println("Something wrong... Try again.");
                break;
            case RESULT:
                System.out.println("Result: ");
                break;
            case POINT_ALREADY_EXIST:
                System.out.println("Such point already exists. Input another one.");
            default:
                break;
        }
    }

    public void printCollection(Set<Point> pointSet) {
        for (Point point : pointSet) {
            System.out.println(point);
        }
    }

    public void printResult(String result) {
        System.out.println(result);
    }
}
