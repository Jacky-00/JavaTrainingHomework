package week1;

import java.util.Scanner;

public class ScoreArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int yuWen = 0, shuXue = 1, waiYu = 2, wuLi = 3, huaXue = 4, shengWu = 5;
        String[] scoreNames = {"语文", "数学", "外语", "物理", "化学", "生物"};

        System.out.print("共有几年的成绩？");
        int yearsToStore = in.nextInt();
        double[][] scores = new double[yearsToStore][scoreNames.length];

        System.out.print("年份 \t");
        for (String scoreName : scoreNames) {
            System.out.printf("%s \t", scoreName);
        }
        for (int i = 0; i < yearsToStore; i++) {
            System.out.printf("\n第%d年\t", i + 1);
            for (int j = 0; j < scoreNames.length; j++) {
                scores[i][j] = Math.random() * 20 + 80;
                System.out.printf("%.1f\t", scores[i][j]);
            }
        }

        while (true) {
            System.out.println("""
                    \n请输入要进行的操作编号
                    1：求某年最好成绩
                    2：求某年平均成绩
                    3：求所有年最好成绩
                    4：求某门课历年最好成绩""");
            int operateId = in.nextInt();
            int yearInput;
            double maxScore;

            switch (operateId) {
                case 1:
                    System.out.print("输入年份：");
                    yearInput = in.nextInt() - 1;
                    maxScore = getMaxScore(scores[yearInput]);
                    for (int i = 0; i < scores[yearInput].length; i++) {
                        if (maxScore == scores[yearInput][i]) {
                            System.out.printf("第%d年最好成绩为%s: %.1f\n", yearInput+1, scoreNames[i], maxScore);
                        }
                    }
                    break;

                case 2:
                    System.out.print("输入年份：");
                    yearInput = in.nextInt() - 1;
                    double averageScore = 0;
                    for (int i = 0; i < scoreNames.length; i++) {
                        averageScore += scores[yearInput][i];
                    }
                    averageScore /= scoreNames.length;
                    System.out.printf("第%d年平均成绩为: %.1f\n", yearInput+1, averageScore);
                    break;

                case 3:
                    double[] maxScoresEachYear = new double[scores.length];
                    for (int i = 0; i < maxScoresEachYear.length; i++) {
                        maxScoresEachYear[i] = getMaxScore(scores[i]);
                    }
                    maxScore = getMaxScore(maxScoresEachYear);
                    for (int i = 0; i < scores.length; i++) {
                        for (int j = 0; j < scores[0].length; j++) {
                            if (scores[i][j] == maxScore) {
                                System.out.printf("最好成绩为第%d年的%s: %.1f\n", i + 1, scoreNames[j], maxScore);
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.print("输入课程编号：");
                    int scoreIndex = in.nextInt()-1;
                    maxScore = -1;
                    for (double[] score : scores) {
                        if (maxScore < score[scoreIndex]) {
                            maxScore = score[scoreIndex];
                        }
                    }
                    for (int i = 0; i < scores.length; i++) {
                        if (maxScore == scores[i][scoreIndex]) {
                            System.out.printf("最好的%s成绩为第%d年: %.1f\n", scoreNames[scoreIndex], i + 1, maxScore);
                        }
                    }
                    break;

                default:
                    System.out.println("输入错误");
            }
        }
    }

    static double getMaxScore(double[] scores) {
        double max = -1;
        for (double score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
}
