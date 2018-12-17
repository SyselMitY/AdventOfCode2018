package day4.part1;

class GuardEntry {

    final int guardId;
    private int[] asleep = new int[60];

    GuardEntry(int guardId) {
        this.guardId = guardId;
    }

    void sleepsAt(int sleepStart, int sleepStop) {
        for (int i = sleepStart; i < sleepStop; i++) {
            asleep[i]++;
        }
    }

    int getMinutesAsleep() {
        int sum = 0;
        for (int i :
                asleep) {
            sum += i;
        }
        return sum;
    }

    int mostAsleepAt() {
        int max = 0;
        for (int i = 0; i < 60; i++) {
            if (asleep[i] > asleep[max])
                max = i;
        }
        return max;
    }
}
