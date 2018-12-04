package day2.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoxChecksum {

    private static final int ALPHABET_SIZE = 26;
    private static final String PATH = "src/day2/input.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File(PATH));
        int checksum;
        int twoChars = 0;
        int threeChars = 0;
        String line;

        while (file.hasNextLine()) {
            line = file.nextLine();

            //Check for double chars
            int charcount[] = new int[ALPHABET_SIZE];
            for (int i = 0; i < line.length(); i++) {
                charcount[line.charAt(i) - 97]++;
            }
            for (int i : charcount) {
                if (i == 2) {
                    twoChars++;
                    break;
                }
            }
            for (int i : charcount) {
                if (i == 3) {
                    threeChars++;
                    break;
                }
            }

        }
        checksum = twoChars * threeChars;

        System.out.println("checksum = " + checksum);
    }
}
