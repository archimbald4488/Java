package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        InputStreamReader defaultInputReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(defaultInputReader);
        Scanner bufferedScanner = new Scanner(bufferedReader);

        System.out.print("Anna tehtaalle nimi:\n");
        Factory factory = new Factory(bufferedScanner.nextLine());
        
        while (true) {
            System.out.println("1) Lisää kone");
            System.out.println("2) Listaa kaikki koneet");
            System.out.println("0) Lopeta ohjelma");
            
            int choice =  Integer.parseInt(bufferedScanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Anna koneen tyyppi:\n");
                    String koneNimi = bufferedScanner.nextLine();

                    System.out.print("Anna koneen malli:\n");
                    String koneTyyppi = bufferedScanner.nextLine();

                    System.out.print("Anna työntekijän nimi:\n");
                    String tyyppiNimi = bufferedScanner.nextLine();

                    System.out.print("Anna työntekijän ammattinimike:\n");
                    String tyyppiAmmatti = bufferedScanner.nextLine();

                    Worker ukko = new Worker(tyyppiNimi, tyyppiAmmatti);
                    Machine kone = new Machine(koneNimi, koneTyyppi, ukko);
                    factory.addMachine(kone);

                    System.out.println("Kone lisätty!");
                    break;
                
                case 2:
                    System.out.println("Tehtaasta " + factory.getName() + " löytyy seuraavat koneet:");
                    for (Machine m : factory.getMachines()) {
                        System.out.println(m.getMachineDetails());
                    }
                    break;
                
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    bufferedScanner.close();
                    return;
                
                default:
                    System.out.println("Virheellinen valinta.");
            }
        }
    }
}