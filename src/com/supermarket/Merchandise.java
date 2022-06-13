package com.supermarket;

public class Merchandise {

    static double DISCOUNT_FOR_VIP = 0.95;
    public String name;
    public String id;
    public int count;
    public double soldPrice; // 售价
    public double purchasePrice; // 进价
    public Merchandise gift; // 赠品
    String madeIn;

    // 构造方法

    /**
     * 构造方法（完整参数）
     *
     * @param name          商品名称
     * @param id            商品id
     * @param count         库存数量
     * @param soldPrice     售价
     * @param purchasePrice 进价
     */
    public Merchandise(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    /**
     * 构造方法，自动将进价赋值为售价的80%
     *
     * @param name      商品名称
     * @param id        商品id
     * @param count     库存数量
     * @param soldPrice 进价
     */
    public Merchandise(String name, String id, int count, double soldPrice) {
        this(name, id, count, soldPrice, soldPrice * 0.8);
    }

    /**
     * (无参)构造方法
     */
    public Merchandise() {
        this("未命名商品", "000", 0, 0, 0);

    }

    // 业务逻辑

    /**
     * 打印商品详细信息
     */
    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count +
                "。销售一个的毛利润是" + (soldPrice - purchasePrice));
    }

    /**
     * 计算商品的利润
     *
     * @return 利润
     */
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }
        return profit;
    }

    /**
     * 购买一个商品
     *
     * @return 购买商品的总金额，
     * 返回-1代表库存不足
     */
    public double buy() {
        return buy(1);
    }

    /**
     * 购买多个商品
     *
     * @param count 要购买的数量
     * @return 购买商品的总金额，
     * 返回-1代表库存不足
     */
    public double buy(int count) {
        return buy(count, false);
    }

    /**
     * 购买商品
     *
     * @param count 要购买的数量
     * @param isVIP 是否VIP购买
     * @return 购买商品的总金额，
     * 返回-1代表库存不足
     */
    public double buy(int count, boolean isVIP) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        if (isVIP) {
            return totalCost * DISCOUNT_FOR_VIP;
        } else {
            return totalCost;
        }
    }

    /**
     * 第二件半价购买
     */
    public double buySecondHalfPrices(int count) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        int fullPriceCount = count / 2 + count % 2;
        int halfPriceCount = count - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;
        return totalCost;
    }

    // 静态方法

    public static double getVIPDiscount() {
        return DISCOUNT_FOR_VIP;
    }

    public static double getDiscountOnDiscount(LittleSupermarket littleSupermarket) {
        double activityDiscount = littleSupermarket.activityDiscount;
        return DISCOUNT_FOR_VIP * activityDiscount;
    }

    // setter & getter

    public String getName() {
        return name;
    }

    public double getSoldPrice() {
        return soldPrice;
    }
}
