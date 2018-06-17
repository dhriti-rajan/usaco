/*
 ID: dhriti.1
 LANG: JAVA
 PROG: beads
 */

import java.io.*;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("beads.in"));

        int necklaceLength = Integer.parseInt(reader.readLine().trim());
        String necklace = reader.readLine();

        int largestCollected = 0;

        for (int i = 0; i < necklaceLength; ++i) {
            int collected = 0;

            int startIndex = 0;
            int endIndex = necklaceLength - 1;

            while (startIndex < necklaceLength - 1 && necklace.charAt(startIndex) == 'w') {
                ++startIndex;
                ++collected;
            }

            char beginningColor = necklace.charAt(startIndex);

            while (startIndex < necklaceLength - 1 && (necklace.charAt(startIndex) == 'w' || necklace.charAt(startIndex) == beginningColor)) {
                ++startIndex;
                ++collected;
            }

            while (endIndex > 1 && necklace.charAt(endIndex) == 'w') {
                --endIndex;
                ++collected;
            }

            char endingColor = necklace.charAt(endIndex);

            while (endIndex > 1 && (necklace.charAt(endIndex) == 'w' || necklace.charAt(endIndex) == endingColor)) {
                --endIndex;
                ++collected;
            }

            if (collected > largestCollected) {
                largestCollected = collected;
            }
            necklace = necklace.substring(1) + necklace.substring(0, 1);
        }

        if (largestCollected > necklaceLength) largestCollected = necklaceLength;

        BufferedWriter outFile = new BufferedWriter(new FileWriter("beads.out"));

        outFile.write(largestCollected + "\n");

        outFile.close();

        System.exit(0);
    }
}