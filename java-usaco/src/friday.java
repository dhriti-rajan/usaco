/*
 ID: dhriti.1
 LANG: JAVA
 PROG: friday
 */

import java.io.*;

public class friday {

    private static boolean isLeapYear(int year) {
        return (year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("friday.in"));

        int[] days = new int[7];

        int years = Integer.parseInt(reader.readLine());

        int[] normalDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYearDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int last = 1900 + years;

        int currentDay = 12;

        for (int i = 1900; i < last; ++i) {
            for (int j = 0; j < 12; ++j) {
                days[(currentDay) % 7] += 1;
                if (isLeapYear(i)) {
                    currentDay += leapYearDays[j];
                } else {
                    currentDay += normalDays[j];
                }
            }
        }

        BufferedWriter outFile = new BufferedWriter(new FileWriter("friday.out"));
        outFile.write(days[5] + " ");
        outFile.write(days[6] + " ");
        outFile.write(days[0] + " ");
        outFile.write(days[1] + " ");
        outFile.write(days[2] + " ");
        outFile.write(days[3] + " ");
        outFile.write(days[4] + "\n");

        outFile.close();

        System.exit(0);
    }
}
