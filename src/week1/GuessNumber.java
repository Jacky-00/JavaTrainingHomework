package week1;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 设置
        int rangeStart = 0;
        int rangeEnd = 5;
        int allowedGuessingTimes = 2;
        boolean gameEnd = false;

        // 统计
        int totalGameCount = 0;
        int correctCount = 0;


        while (!gameEnd) {
            boolean isCorrect = false;
            // 生成随机数:numberToGuess
            if (rangeStart < 0 || rangeEnd < 0) {
                System.out.println("开始结束必须是正数或0");
            } else if (rangeEnd - rangeStart <= 1) {
                System.out.printf("非法的数字范围：(%d, %d)\n", rangeStart, rangeEnd);
            }
            int numberToGuess = (int) (Math.random() * (rangeEnd - rangeStart - 1) + rangeStart + 1);
            if (numberToGuess <= rangeStart) {
                numberToGuess = rangeStart + 1;
            } else if (numberToGuess >= rangeEnd) {
                numberToGuess = rangeEnd - 1;
            }
            totalGameCount++;
            System.out.printf("== 第 %d 局 ==\n", totalGameCount);
            System.out.printf("请输入范围 (%d, %d) 内的数字, ", rangeStart, rangeEnd);
            int leftGuessingTimes = allowedGuessingTimes;
            while (leftGuessingTimes > 0) {
                System.out.printf("剩余%d次\n", leftGuessingTimes);
                int guessedNumber = in.nextInt();
                if (guessedNumber < 0) {
                    gameEnd = true;
                    break;
                }
                leftGuessingTimes--;
                if (guessedNumber > numberToGuess) {
                    System.out.print("太大了, ");
                } else if (guessedNumber < numberToGuess) {
                    System.out.print("太小了, ");
                } else {
                    System.out.print("猜对了! ");
                    correctCount++;
                    isCorrect = true;
                    break;
                }
            }
            if (!isCorrect){
                System.out.printf("正确数字为%d, 本局结束\n", numberToGuess);
            }else {
                System.out.println("本局结束");
            }
            if (leftGuessingTimes==allowedGuessingTimes){
                totalGameCount--;
            }
        }
        System.out.printf("游戏结束，共%d局，胜率%d%%\n", totalGameCount, (int) ((double) correctCount / totalGameCount * 100));
    }
}
