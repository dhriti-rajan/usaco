/*
 ID: dhriti.1
 LANG: JAVA
 PROG: milk2
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class milk2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("milk2.in"));

        int farmers = scanner.nextInt();

        Pair[] milkTimes = new Pair[farmers];

        for (int i = 0; i < farmers; ++i) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            milkTimes[i] = new Pair(start, end);
        }

        scanner.close();

        Arrays.sort(milkTimes);

        int start = milkTimes[0].start;
        int end = milkTimes[0].end;
        int milkingTime = end - start;
        int nonMilkingTime = 0;

        for(int i = 1; i < milkTimes.length; i++) {
            if(end >= milkTimes[i].start && end <= milkTimes[i].end) {
                end = milkTimes[i].end;
            }

            milkingTime = Math.max(end - start, milkingTime);

            if(milkTimes[i].start > end) {
                milkingTime = Math.max(end - start, milkingTime);
                nonMilkingTime = Math.max(nonMilkingTime, milkTimes[i].start - end);

                start = milkTimes[i].start;
                end = milkTimes[i].end;
            }
        }

        BufferedWriter outFile = new BufferedWriter(new FileWriter("milk2.out"));

        outFile.write(milkingTime + " " + nonMilkingTime + "\n");

        outFile.close();

        System.exit(0);
    }
}

class Pair implements Comparable <Pair> {
    public int start;
    public int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
        Integer a = this.start;
        Integer b = o.start;
        return a.compareTo(b);
    }
}