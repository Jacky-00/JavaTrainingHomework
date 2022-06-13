package week2.b;

public class RefactorGuessNumber {
    int rangeStart;
    int rangeEnd;
    int allowedGuessingTimes; // 允许猜测次数
    int guessedTimes; // 已猜次数
    int numberToGuess;
    public boolean isStart;
    boolean isWin;
    public int gameCount = 0;
    public int winCount = 0;

    /**
     * 构造函数
     *
     * @param rangeStart           生成的随机数下限
     * @param rangeEnd             随机数上限
     * @param allowedGuessingTimes 最大允许猜测次数
     */
    public RefactorGuessNumber(int rangeStart, int rangeEnd, int allowedGuessingTimes) {
        if (rangeStart < 0 || rangeEnd < 0) {
            System.out.println("开始结束必须是正数或0");
        } else if (rangeEnd - rangeStart <= 1) {
            System.out.printf("非法的数字范围：(%d, %d)\n", rangeStart, rangeEnd);
        } else {
            this.rangeStart = rangeStart;
            this.rangeEnd = rangeEnd;
            this.allowedGuessingTimes = allowedGuessingTimes;
            this.isStart = false;
            this.isWin = false;
            this.guessedTimes = 0;
        }
    }

    /**
     * 构造函数（无参）
     */
    public RefactorGuessNumber() {
        this(0, 100, 5);
    }


    /**
     * 准备新游戏
     */
    public void prepareNewGame() {
        isWin = false;
        guessedTimes = 0;
        this.isStart = true;
        this.gameCount++;
        this.numberToGuess = (int) (Math.random() * (rangeEnd - rangeStart - 1) + rangeStart + 1);
        if (this.numberToGuess <= this.rangeStart) {
            this.numberToGuess = this.rangeStart + 1;
        } else if (this.numberToGuess >= this.rangeEnd) {
            this.numberToGuess = this.rangeEnd - 1;
        }
    }

    /**
     * @param guessingNumber 猜测的数字
     * @return 0: 猜中了/次数用完了
     * 1: 大了
     * -1: 小了
     */
    public int guess(int guessingNumber) {
        this.guessedTimes++;
        if (this.guessedTimes >= this.allowedGuessingTimes) {
            isStart = false; // 最后一次猜测机会
        }
        if (guessingNumber == this.numberToGuess) {
            isWin = true;
            this.winCount++;
            isStart = false;
            return 0;
        } else {
            isWin = false;
            return guessingNumber > numberToGuess ? 1 : -1;
        }
    }

    /**
     * 结束游戏
     * 减去尚未开始的一局游戏计数
     */
    public void exit() {
        if (isWin == false && guessedTimes == 0) {
            gameCount--;
        }
    }
}
