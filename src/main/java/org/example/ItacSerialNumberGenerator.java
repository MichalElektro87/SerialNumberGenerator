package org.example;

import java.util.*;

public class ItacSerialNumberGenerator {

    private List<String> serialNumbers;
    private String serialNumber = null;
    private int arrayLength = 0;
    private int overflowCounter = 0;

    public ItacSerialNumberGenerator (String serialNumber, int arrayLength) {
        serialNumbers = new ArrayList<>();
        this.serialNumber = serialNumber;
        this.arrayLength = arrayLength;
    }

    public void generateSerialNumbers() {
        char charTable[] = new char[serialNumber.length()];
        for (int i = 0; i < charTable.length; i++) {
            charTable[i] = serialNumber.charAt(i);
        }
        for (int i = 0; i < arrayLength; i++) {
            serialNumbers.add(String.valueOf(charTable));
            charTable[charTable.length - 1]++;
            for (int j = 0; j < charTable.length; j++) {
                if (charTable[charTable.length - 1 - j] == 58) {
                    charTable[charTable.length - 1 - j] = 65;
                }
                if (charTable[charTable.length - 1 - j] == 73 || charTable[charTable.length - 1 - 0] == 79) {
                    charTable[charTable.length - 1 - j]++;
                }
                if (charTable[charTable.length - 1 - j] == 91) {
                    overflowCounter++;
                    System.out.println("Overflow Z: " + overflowCounter);
                    if (overflowCounter >= charTable.length) {
                        System.exit(277);
                        break;
                    }
                    charTable[charTable.length - 1 - j] = 48;
                    charTable[charTable.length - 1 - (j+1)]++;

                }
            }
        }
    }

    public List<String> getSerialNumbers() {
        return serialNumbers;
    }

    public int getOverflowCounter () {
        return overflowCounter;
    }
}
