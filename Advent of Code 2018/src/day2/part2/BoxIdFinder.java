package day2.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoxIdFinder {

    private static final String PATH = "src/day2/input.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File(PATH));
        ArrayList<String> ids = new ArrayList<>();
        int pos1 = 0;
        int pos2 = 2;

        while (file.hasNextLine())
            ids.add(file.nextLine());
        System.out.println("ids.size() = " + ids.size());
        for (String box1 :
                ids) {
            for (String box2 :
                    ids) {
                if (compareStrings(box1, box2)) {
                    pos1 = ids.indexOf(box1);
                    pos2 = ids.indexOf(box2);
                }
            }
        }
        System.out.println(ids.get(pos1) + "\n" + ids.get(pos2));
    }

    private static boolean compareStrings(String s1, String s2) {

        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
