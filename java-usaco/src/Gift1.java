/*
 ID: dhriti.1
 LANG: JAVA
 PROG: gift1
 */

import java.io.*;
import java.util.*;

public class Gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("gift1.in"));
        int peopleNumber = Integer.parseInt(reader.readLine());
        String[] names = new String[peopleNumber];
        Map accounts = new HashMap<String, Integer>();

        for (int i = 0; i < peopleNumber; ++i) {
            String name = reader.readLine();
            names[i] = name;
            accounts.put(name, 0);
        }

        String currentGiver = reader.readLine();

        while (accounts.get(currentGiver) != null) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int money = Integer.parseInt(st.nextToken());
            int divisions = Integer.parseInt(st.nextToken());
            int giftAmount = money/divisions;
            int giftedMoney = giftAmount * divisions;
            int giverMoney = (int) accounts.get(currentGiver);

            accounts.remove(currentGiver);
            accounts.put(currentGiver, giverMoney - giftedMoney);

            for (int i = 0; i < divisions; ++i) {
                String currentReciever = reader.readLine();
                int receiverMoney = (int) accounts.get(currentReciever);
                accounts.remove(currentReciever);
                accounts.put(currentReciever, receiverMoney + giftAmount);
            }

            currentGiver = reader.readLine();
        }

        BufferedWriter outFile = new BufferedWriter(new FileWriter("gift1.out"));
        for (int i = 0; i < peopleNumber; ++i) {
            outFile.write(names[i] + " " + accounts.get(names[i]));
        }

        outFile.close();
        System.exit(0);
    }

}
