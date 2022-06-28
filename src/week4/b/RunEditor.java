package week4.b;

import java.io.IOException;
import java.util.Scanner;

public class RunEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件路径：");
        FileEditor f = null;
        try {
            f = new FileEditor(scanner.nextLine());

            boolean isContinue = true;
            while (isContinue) {
                System.out.println("\n输入操作：添加行(add)，删除行(del)，退出(q)");
                isContinue = f.commendHandler(scanner.nextLine());
            }

        } catch (IOException e) {
            System.out.println("新建文件失败");
            e.printStackTrace();
        }

    }
}
