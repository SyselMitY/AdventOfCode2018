package day4.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuardProtocol {

    private static final String PATH = "src/day4/input.txt";

    public static void main(String[] args) throws FileNotFoundException, ParseException {

        ArrayList<ProtocolEntry> protocol = new ArrayList<>();
        Scanner file = new Scanner(new File(PATH));
        final Pattern entry = Pattern.compile("\\[(\\d+-\\d+-\\d+ \\d+:\\d+)] (.+)");

        while (file.hasNextLine()) {
            Matcher matcher = entry.matcher(file.nextLine());
            if (!matcher.matches()) System.exit(1);

            protocol.add(new ProtocolEntry(matcher.group(1), matcher.group(2)));

        }

        protocol.sort(Comparator.comparing(o -> o.date));

        protocol.forEach(System.out::println);

    }
}
