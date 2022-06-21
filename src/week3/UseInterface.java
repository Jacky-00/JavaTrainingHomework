package week3;

import com.supermarket.*;

import java.util.Date;

public class UseInterface {

    public static void main(String[] args) {

        Date produceDate = new Date();
        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
        GamePointCard gamePointCard = new GamePointCard(
                "GamePointCard", "GamePointCard001", 100, 1999, 999,
                produceDate, expireDate
        );

        ExpireDateMerchandise expireDateMerchandise = gamePointCard;
        gamePointCard.describe();
        System.out.println("366天是否在保质期内：" + expireDateMerchandise.notExpireInDays(366));
        System.out.println("目前商品剩余价值：" +
                expireDateMerchandise.actualValueNow(expireDateMerchandise.leftDatePercentage()));

    }
}