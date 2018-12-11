package day3.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FabricFinder {
    private static final String PATH = "src/day3/input.txt";
    static private int fabric[][] = new int[1000][1000];

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File(PATH));
        int result = -1;

        while (file.hasNextLine()) {

            int id;
            int left;
            int top;
            int width;
            int height;
            Object[] colisionIds;
            String line = file.nextLine();
            Pattern p = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
            Matcher m = p.matcher(line);
            //noinspection ResultOfMethodCallIgnored
            m.matches();

            id = Integer.parseInt(m.group(1));
            left = Integer.parseInt(m.group(2));
            top = Integer.parseInt(m.group(3));
            width = Integer.parseInt(m.group(4));
            height = Integer.parseInt(m.group(5));

            System.out.println("Filling patch " + line);
            colisionIds = fillFabric(id, left, top, width, height);

            if (colisionIds.length != 0) {
                System.out.println("Found overlapping areas!");
                System.out.println("Removing id " + id);
                fillFabric(id);
                for (Object i :
                        colisionIds) {
                    if ((int) i != -1) {
                        System.out.println("Removing id " + i);
                        fillFabric((Integer) i);
                    }
                }
            }

        }

        for (int[] i : fabric) {
            for (int j : i) {
                if (j > 0) result = j;
            }
        }

        System.out.println("result = " + result);

    }

    private static Object[] fillFabric(int id, int left, int top, int width, int height) {
        ArrayList<Integer> colisionIds = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (fabric[i + top][j + left] == 0) fabric[i + top][j + left] = id;
                else if (!colisionIds.contains(fabric[i + top][j + left])) colisionIds.add(fabric[i + top][j + left]);
            }
        }
        return colisionIds.toArray();
    }

    private static void fillFabric(int id) {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (fabric[i][j] == id) fabric[i][j] = -1;

            }
        }
    }
}
