package week2.b;

import java.util.Scanner;

public class RunGameMain {
    public static void main(String[] args) {
        RefactorGuessNumber game = new RefactorGuessNumber(0, 5, 2);
        Scanner scanner = new Scanner(System.in);
        boolean isRestartNewGame = true;
        while (isRestartNewGame) {
            game.prepareNewGame();
            System.out.printf("== 第 %d 局 ==\n", game.gameCount);
            System.out.printf("请输入范围 (%d, %d) 内的数字, ", game.rangeStart, game.rangeEnd);
            while (game.isStart) {
                System.out.printf("剩余%d次\n", game.allowedGuessingTimes - game.guessedTimes);
                int guessingNumber = scanner.nextInt();
                if (guessingNumber < 0) {
                    game.exit();
                    isRestartNewGame = false;
                    break;
                }
                switch (game.guess(guessingNumber)) {
                    case 0:
                        if (game.isWin) {
                            System.out.print("猜对了！");
                        }
                        break;
                    case 1:
                        System.out.print("太大了，");
                        break;
                    case -1:
                        System.out.print("太小了，");

                }
            }
            if (!game.isWin) {
                System.out.printf("正确数字为%d, 本局结束\n", game.numberToGuess);
            } else {
                System.out.println("本局结束");
            }
        }
        System.out.printf("游戏结束，共%d局，胜率%d%%\n",
                game.gameCount, (int) ((double) game.winCount / game.gameCount * 100));
    }
}
