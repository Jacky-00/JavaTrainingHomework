package com.supermarket;

public class LittleSupermarket {
    public boolean isOpen = false;
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;
    public double activityDiscount;

    // 构造方法

    /**
     * 初始化小超市
     *
     * @param superMarketName         超市名
     * @param address                 超市地址
     * @param parkingCount            停车位数量
     * @param merchandiseCount        商品种类数
     * @param merchandiseDefaultCount 每种商品缺省库存
     */
    public LittleSupermarket(String superMarketName, String address, int parkingCount,
                             int merchandiseCount, int merchandiseDefaultCount) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;

        merchandises = new Merchandise[merchandiseCount];
        for (int i = 0; i < merchandises.length; i++) {
            // 创建并给商品的属性赋值
            Merchandise m = new Merchandise();
            m.name = "商品" + i;
            m.count = merchandiseDefaultCount;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            merchandises[i] = m;
        }
        merchandiseSold = new int[merchandises.length];
    }

    /**
     * 初始化小超市（无参）
     */
    public LittleSupermarket() {
        this("未命名超市", "未知地址", 0, 0, 0);
    }

    /**
     * (！FOR TEST) 用于测试静态方法使时使用
     * 设置activityDiscount的构造方法
     *
     * @param activityDiscount
     */
    public LittleSupermarket(double activityDiscount) {
        this();
        this.activityDiscount = activityDiscount;
    }

    // setter & getter

    public String getSuperMarketName() {
        return superMarketName;
    }

    public String getAddress() {
        return address;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public double getIncomingSum() {
        return incomingSum;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }

    public void setIncomingSum(double incomingSum) {
        this.incomingSum = incomingSum;
    }

    public void setMerchandises(Merchandise[] merchandises) {
        this.merchandises = merchandises;
    }

    public void setMerchandiseSold(int[] merchandiseSold) {
        this.merchandiseSold = merchandiseSold;
    }

    // 业务逻辑

    public void describe() {
        System.out.println("本店叫做" + superMarketName + ",地址在" + address +
                ",共有停车位" + parkingCount + "个" + "共有商品" + merchandises.length + "种。");

    }

    /**
     * 获取利润最高的商品
     *
     * @return 利润最高的商品对象
     */
    public Merchandise getBiggestProfitMerchandise() {
        Merchandise curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null || curr.calculateProfit() < m.calculateProfit()) {
                curr = m;
            }
        }
        return curr;
    }

    /**
     * 根据索引获取商品
     *
     * @param merchandiseIndex 商品索引
     * @return 索引指向的商品对象
     */
    public Merchandise getMerchandiseOf(int merchandiseIndex) {
        if (merchandiseIndex < 0 || merchandiseIndex >= merchandises.length) {
            return null;
        }
        return merchandises[merchandiseIndex];
    }

    /**
     * 赚钱
     *
     * @param toBeAdded 增加的金额
     */
    public void addIncomingSum(double toBeAdded) {
        this.incomingSum += toBeAdded;
    }

    /**
     * 花钱
     *
     * @param toBeSpent 减少的金额
     * @return 钱是否足够
     */
    public boolean spendMoney(double toBeSpent) {
        if (toBeSpent > incomingSum) {
            return false;
        }
        incomingSum -= toBeSpent;
        return true;
    }

}
