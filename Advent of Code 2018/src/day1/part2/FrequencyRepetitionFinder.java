package day1.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


//Very slow but works
class FrequencyRepetitionFinder {
    private static final String PATH = "src/day1/input.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File(PATH));
        int frequency = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean hasNumber = false;

        System.out.println("Calculating...");
        while (!hasNumber) {
            if (!file.hasNext()) {
                file.close();
                file = new Scanner(new File(PATH));
            }

            int nextEntry = file.nextInt();
            frequency += nextEntry;
            if (numbers.contains(frequency)) {
                hasNumber = true;
            } else numbers.add(frequency);
        }
        System.out.println("The first reoccurring frequency is " + frequency);
    }
}

