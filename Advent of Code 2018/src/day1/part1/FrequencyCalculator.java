package day1.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FrequencyCalculator {

    private static final String PATH = "src/day1/input.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File(PATH));
        int frequency = 0;

        while (file.hasNextInt()) {
            int nextEntry = file.nextInt();
            System.out.printf("Adding %d to old frequency %d. New frequency is now at %d.\n", nextEntry, frequency, frequency + nextEntry);
            frequency += nextEntry;
        }

        System.out.println("The final frequency of the device is " + frequency);
    }
}
