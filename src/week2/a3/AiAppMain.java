package week2.a3;

import java.util.Scanner;

public class AiAppMain {
    public static void main(String[] args) {
        AI ai2 = new AI();
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.next();
            if (input.indexOf("再见") == 0) {
                System.out.println("再见！");
                break;
            }
            String answer = ai2.answer(input);
            System.out.println(answer);
        }
    }
}
