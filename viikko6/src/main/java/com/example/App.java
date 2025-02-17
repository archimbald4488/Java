package com.example;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        InputStreamReader defaultInputReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(defaultInputReader);
        Scanner bufferedScanner = new Scanner(bufferedReader);

        ArrayList<Instrument> soittimet = new ArrayList<>();
        
        while (true) {
            System.out.println("1) Lisää soitin");
            System.out.println("2) Listaa soittimet");
            System.out.println("3) Viritä kielisoittimet");
            System.out.println("4) Soita rumpuja");
            System.out.println("0) Lopeta ohjelma");

            int valinta = Integer.parseInt(bufferedScanner.nextLine());
            
            switch (valinta) {
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    bufferedScanner.close();
                    return;
                case 1:
                    System.out.print("Minkä soittimen haluat lisätä? 1) Kitara, 2) Viulu, 3) Rummut\n");
                    int tyyppi = Integer.parseInt(bufferedScanner.nextLine());
                    System.out.print("Anna valmistajan nimi:\n");
                    String valmistaja = bufferedScanner.nextLine();
                    System.out.print("Anna hinta euroina:\n");
                    int hinta = Integer.parseInt(bufferedScanner.nextLine());
                    
                    if (tyyppi == 1) {
                        soittimet.add(new Guitar(valmistaja, hinta));
                    } else if (tyyppi == 2) {
                        soittimet.add(new Violin(valmistaja, hinta));
                    } else if (tyyppi == 3) {
                        soittimet.add(new Drum(valmistaja, hinta));
                    } else {
                        System.out.println("Virheellinen soitinvalinta.");
                        break;
                    }
                    System.out.println("Soitin lisätty listaan!");
                    break;
                case 2:
                    if (soittimet.size() != 0)
                    for (Instrument soitin : soittimet) {
                        System.out.println(soitin.getDetails());
                    } else {
                        System.out.println("Ei lisättyjä soittimia.");
                    }
                    break;
                case 3:
                    for (Instrument soitin : soittimet) {
                        if (soitin instanceof StringInstrument) {
                            ((StringInstrument) soitin).tune();
                        }
                    }
                    break;
                case 4:
                    for (Instrument soitin : soittimet) {
                        if (soitin instanceof Drum) {
                            ((Drum) soitin).playBeat();
                        }
                    }
                    break;
                default:
                    System.out.println("Virheellinen valinta.");
            }
        }
    }
}
