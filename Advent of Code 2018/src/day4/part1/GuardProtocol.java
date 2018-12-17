package day4.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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

        ArrayList<GuardEntry> guards = new ArrayList<>();

        int guard;
        int guardIndex = 0;
        int sleepStart = -1;
        int sleepStop;

        for (ProtocolEntry p :
                protocol) {
            Pattern pattern = Pattern.compile("Guard #(\\d+) (.+)");
            Matcher matcher = pattern.matcher(p.message);
            if (matcher.matches()) {
                guard = Integer.parseInt(matcher.group(1));
                guardIndex = contains(guards, guard);
                if (guardIndex < 0) {
                    System.out.println("Adding Guard " + guard);
                    GuardEntry tmp = new GuardEntry(guard);
                    guards.add(tmp);
                    guardIndex = guards.indexOf(tmp);
                }
            } else if (p.message.equals("falls asleep")) {
                sleepStart = p.date.get(Calendar.MINUTE);
            } else if (p.message.equals("wakes up")) {
                sleepStop = p.date.get(Calendar.MINUTE);
//                guards.get(guardIndex).modifyMinutessAsleep(sleepStop-sleepStart);
                guards.get(guardIndex).sleepsAt(sleepStart, sleepStop);
//                System.out.println("Guard #"+ guard+ " slept for "+(sleepStop-sleepStart)+ " mins." );
            }
        }

        int maxIndex = 0;

        for (int i = 0; i < guards.size(); i++) {
            if (guards.get(i).getMinutesAsleep() > guards.get(maxIndex).getMinutesAsleep()) {
                maxIndex = i;
            }
        }

        System.out.println("Result: Lazy Guard #" + guards.get(maxIndex).guardId + " slept for " + guards.get(maxIndex).getMinutesAsleep() + " minutes.");

        System.out.println("Usually asleep at 00:" + guards.get(maxIndex).mostAsleepAt());
    }


    private static int contains(ArrayList<GuardEntry> guards, int id) {
        for (GuardEntry guardEntry : guards) {
            if (guardEntry.guardId == id) {
                return guards.indexOf(guardEntry);
            }
        }
        return -1;
    }
}
