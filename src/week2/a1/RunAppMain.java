package week2.a1;

import com.supermarket.*;
import com.person.*;

import java.util.Scanner;

public class RunAppMain {
    public static void main(String[] args) {
        // 创建一个小超市类，由构造函数初始化
        LittleSupermarket littleSuperMarket = new LittleSupermarket(
                "ADVAN超市", "中国上海张江",
                100, 200, 200);
        System.out.println("超市开张啦！");

        littleSuperMarket.isOpen = true;
        Scanner in = new Scanner(System.in);
        while (littleSuperMarket.isOpen) {
            littleSuperMarket.describe();

            Customer customer = new Customer(
                    "顾客编号" + (int) (Math.random() * 10000000),
                    (1 + Math.random()) * 1000,
                    Math.random() > 0.5);

            //开车来的给分配车位，没车位就不让进了
            if (customer.isDrivingCar) {
                if (littleSuperMarket.parkingCount > 0) {
                    System.out.println("欢迎" + customer.name + "驾车而来。车位编号为" + littleSuperMarket.parkingCount);
                    littleSuperMarket.parkingCount -= 1;
                } else {
                    System.out.println("车位已满。欢迎您下次光临");
                    continue;
                }
            } else {
                System.out.println("欢迎" + customer.name + "光临本店");
            }

            // 接待此顾客
            double totalCost = 0;
            while (true) {
                // 顾客选商品
                System.out.print("本店提供" + littleSuperMarket.merchandises.length + "种商品。");
                System.out.println("今日超市大特惠，所有商品第二件半价！选择要购买的商品索引：");
                int merchandiseId = in.nextInt();
                // 输入负数表示买好了。
                if (merchandiseId < 0) {
                    System.out.println("您本次购买了" + totalCost + "元的商品。欢迎您再次光临。");
                    break;
                }

                // 商品没有，让顾客继续选择
                if (merchandiseId >= littleSuperMarket.merchandises.length) {
                    System.out.println("此商品本店没有，欢迎继续挑选");
                    continue;
                }

                // 商品有，问顾客要购买多少个
                Merchandise toBuy = littleSuperMarket.merchandises[merchandiseId];
                System.out.println(toBuy.name + "单价" + toBuy.soldPrice + "。请问购买几个？");

                int numToBuy = in.nextInt();

                // 不想买，看看也欢迎
                if (numToBuy <= 0) {
                    System.out.println("不买看看也好，欢迎继续选购");
                    continue;
                }

                double thisCost = toBuy.buySecondHalfPrices(numToBuy);

                // 买的太多，库存不够
                if (thisCost < 0) {
                    System.out.println(toBuy.name + "只有" + toBuy.count + "件了。欢迎继续选购。");
                    continue;
                }

                // 顾客钱不够
                if (thisCost + totalCost > customer.money) {
                    System.out.println("您带的钱不够结账，请您理智消费。");
                    continue;
                }

                // 钱也够，货也够
                // 更新顾客此次消费的总额
                totalCost += thisCost;
                // 更新今日销货数据
                littleSuperMarket.merchandiseSold[merchandiseId] += numToBuy;
            }
            // 归还车位
            if (customer.isDrivingCar) {
                littleSuperMarket.parkingCount++;
            }
            // 更新数据
            customer.money -= totalCost;
            littleSuperMarket.incomingSum += totalCost;
            System.out.println(customer.name + "共消费" + totalCost + "。欢迎再次光临。");

            System.out.println("请问继续营业吗？");
            littleSuperMarket.isOpen = in.nextBoolean();
        }

        System.out.println("超市关门啦！");

        System.out.println("今日销售额为" + littleSuperMarket.incomingSum + "。营业统计如下：");
        for (int i = 0; i < littleSuperMarket.merchandiseSold.length; i++) {
            int sold = littleSuperMarket.merchandiseSold[i];
            if (sold > 0) {
                Merchandise m = littleSuperMarket.merchandises[i];
                double netIncoming = sold * (m.soldPrice - m.purchasePrice);
                double incoming = sold * m.soldPrice;
                System.out.println(littleSuperMarket.merchandises[i].name + "售出" + sold + "个。销售额" + incoming + "。毛利润" + netIncoming);
            }
        }
        System.out.println("利润最高的商品是：");
        littleSuperMarket.getBiggestProfitMerchandise().describe();

    }
}
