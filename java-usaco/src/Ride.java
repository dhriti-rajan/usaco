import java.util.Scanner;

/**
 * ID: dhriti.1
 * LANG: Java
 * PROG: ride
 */


public class Ride {

    public static int letterToNumber(char letter) {
        return letter - ((int) 'A') + 1;
    }

    public static int multiplication(String str) {
        if (str.length() == 0) return 1;
        return letterToNumber(str.charAt(0)) * multiplication(str.substring(1));
    }

    public static String ride(String comet, String group) {
        if (multiplication(comet) % 47 == multiplication(group) % 47) return "GO";
        return "STAY";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comet = sc.nextLine();
        String group = sc.nextLine();
        System.out.println(ride(comet, group));
        sc.close();
    }
}
