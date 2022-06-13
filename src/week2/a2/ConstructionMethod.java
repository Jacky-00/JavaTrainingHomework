package week2.a2;

import com.supermarket.Merchandise;

public class ConstructionMethod {
    public static void main(String[] args) {
        System.out.println("无参数调用构造方法：");
        Merchandise merchandise = new Merchandise();
        merchandise.describe();

        System.out.println("完整参数调用：");
        merchandise = new Merchandise("商品1", "001",
                10, 500, 400);
        merchandise.describe();

        System.out.println("进价缺失调用：");
        merchandise = new Merchandise("商品2", "002", 50, 1000);
        merchandise.describe();

    }
}
