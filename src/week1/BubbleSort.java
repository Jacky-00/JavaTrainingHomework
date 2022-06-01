package week1;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入: ");
            char[] strInput = in.nextLine().toCharArray();

            for (int i = 0; i < strInput.length; i++) {
                for (int j = i + 1; j < strInput.length; j++) {
                    if (strInput[i] < strInput[j]) {
                        char tmp = strInput[i];
                        strInput[i] = strInput[j];
                        strInput[j] = tmp;
                    }
                }
            }

            String stringSorted = new String(strInput);
            int[] stringAsciiCodes = new int[strInput.length];
            for (int i = 0; i < stringAsciiCodes.length; i++) {
                stringAsciiCodes[i] = strInput[i];
            }

            System.out.println("有序字符串: " + stringSorted);
            System.out.println("ASCII码: " + Arrays.toString(stringAsciiCodes));
        }
    }
}
