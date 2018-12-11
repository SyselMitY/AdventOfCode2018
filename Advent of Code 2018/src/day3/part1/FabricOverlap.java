package day3.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FabricOverlap {

    private static final String PATH = "src/day3/input.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File(PATH));

        int fabric[][] = new int[1000][1000];
        int result = 0;

        while (file.hasNextLine()) {

            int left;
            int top;
            int width;
            int height;
            String line = file.nextLine();
            Pattern p = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
            System.out.println("Matching string " + line);
            Matcher m = p.matcher(line);
            //noinspection ResultOfMethodCallIgnored
            m.matches();
            System.out.println("m.groupCount() = " + m.groupCount());
            left = Integer.parseInt(m.group(2));
            top = Integer.parseInt(m.group(3));
            width = Integer.parseInt(m.group(4));
            height = Integer.parseInt(m.group(5));

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    fabric[i + top][j + left]++;
                }
            }

        }

        for (int[] i : fabric) {
            for (int j : i) {
                if (j > 1) result++;
            }
        }

        System.out.println("result = " + result);
    }

}
