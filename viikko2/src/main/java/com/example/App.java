package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        InputStreamReader defaultInputReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(defaultInputReader);
        Scanner bufferedScanner = new Scanner(bufferedReader);

        // kysy tiedot
        System.out.print("Anna auton merkki: ");
        String brand = bufferedScanner.nextLine();

        System.out.print("Anna auton malli: ");
        String model = bufferedScanner.nextLine();

        Car car = new Car(brand, model);

        while (true) {
            System.out.println("1) Näytä auton tila");
            System.out.println("2) Muokkaa auton merkkiä ja mallia");
            System.out.println("3) Kiihdytä autoa");
            System.out.println("4) Hidasta autoa");
            System.out.println("0) Lopeta ohjelma");

            int choice;
            choice = Integer.parseInt(bufferedScanner.nextLine());

            switch (choice) {
                case 1:
                    car.tila();
                    break;

                case 2:
                    System.out.print("Anna uusi auton merkki: ");
                    car.setBrand(bufferedScanner.nextLine());

                    System.out.print("Anna uusi auton malli: ");
                    car.setModel(bufferedScanner.nextLine());
                    break;

                case 3:
                    System.out.print("Kuinka monta km/h haluat kiihdyttää? ");
                    int acceleration = Integer.parseInt(bufferedScanner.nextLine());
                    if (acceleration < 0) {
                        System.out.println("Nopeuden täytyy olla positiivinen luku.");
                    } else {
                        car.accelerate(acceleration);
                    }
                    break;

                case 4:
                    System.out.print("Kuinka monta km/h haluat hidastaa? ");
                    int deceleration = Integer.parseInt(bufferedScanner.nextLine());
                    if (deceleration < 0) {
                        System.out.println("Nopeuden täytyy olla positiivinen luku.");
                    } else {
                        car.decelerate(deceleration);
                    }
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    bufferedScanner.close();
                    return;

                default:
                    System.out.println("Väärä syöte.");
            }
        }
    }
}