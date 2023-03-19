package org.example;

import org.example.ItacSerialNumberGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String serialNumber = "";
        int arrayLength = 0;
        System.out.print("Type serial number: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            serialNumber = scanner.nextLine();
            if (serialNumber.length() < 3) {
                System.out.println("Serial number must be at least 3 characters long.");
                System.exit(255);
            }
        }
        System.out.print("Type array length: ");
        if (scanner.hasNextInt()) {
            arrayLength = scanner.nextInt();
            if (arrayLength > 2000) {
                System.out.println("Size of array can't be bigger then 20");
                System.exit(256);
            }
        }
        ItacSerialNumberGenerator itacSerialNumberGenerator = new ItacSerialNumberGenerator(serialNumber, arrayLength);
        itacSerialNumberGenerator.generateSerialNumbers();
        itacSerialNumberGenerator.getSerialNumbers().stream().forEach(n->System.out.println(n));
    }
}
