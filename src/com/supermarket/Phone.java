package com.supermarket;

import java.util.Date;

public class Phone extends Merchandise implements ExpireDateMerchandise {
    private Date produceDate;
    private Date expirationDate;

    // 给Phone增加新的属性和方法
    private double screenSize;
    private double cpuHZ;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;
    private static int MAX_BUY_ONE_ORDER = 5;

    /**
     * 构造方法
     *
     * @param name          商品名
     * @param id            商品id
     * @param count         商品数量
     * @param soldPrice     商品售价
     * @param purchasePrice 商品进价
     * @param screenSize    手机屏幕尺寸
     * @param cpuHZ         手机cpu频率
     * @param memoryG       手机运存(G)
     * @param storageG      手机容量(G)
     * @param brand         手机品牌
     * @param os            手机操作系统
     */
    public Phone(
            String name, String id, int count, double soldPrice, double purchasePrice,
            double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os
    ) {
        super(name, id, count, soldPrice * 1.2, purchasePrice);
        init(screenSize, cpuHZ, memoryG, storageG, brand, os);
    }

    public Phone() {
        super("无名", "000", 0, 1, 1.1);
        init(4.5, 4.6, 6, 128, "Unknown", "Unknown");
    }

    public void init(double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os) {
        this.screenSize = screenSize;
        this.cpuHZ = cpuHZ;
        this.memoryG = memoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;
    }

    /**
     * @param count 要购买的数量
     * @return 购买商品总金额,
     * 返回-2代表购买数量超过Phone.MAX_BUY_ONE_ORDER
     */
    @Override
    public double buy(int count) {
        if (count > MAX_BUY_ONE_ORDER) {
            System.out.println("购买失败，手机一次最多只能买" + MAX_BUY_ONE_ORDER + "个");
            return -2;
        }
        return super.buy(count);
    }

    public Phone getThisPhone() {
        return this;
    }

    @Override
    public String getName() {
        return this.brand + ":" + this.os + ":" + super.getName();
    }

    @Override
    public Date getProducedDate() {
        return produceDate;
    }

    @Override
    public Date getExpireDate() {
        return expirationDate;
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return soldPrice * (leftDatePercentage + 0.5);
    }


    @Override
    public void describe() {
        System.out.println("此手机商品属性如下");
        System.out.println("手机厂商为" + brand + "；系统为" + os + "；硬件配置如下：\n" +
                "屏幕：" + screenSize + "寸\n" +
                "cpu主频" + cpuHZ + " GHz\n" +
                "内存" + memoryG + "Gb\n" +
                "存储空间" + storageG + "Gb\n");

    }

    public boolean meetCondition() {
        return true;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getCpuHZ() {
        return cpuHZ;
    }

    public void setCpuHZ(double cpuHZ) {
        this.cpuHZ = cpuHZ;
    }

    public int getMemoryG() {
        return memoryG;
    }

    public void setMemoryG(int memoryG) {
        this.memoryG = memoryG;
    }

    public int getStorageG() {
        return storageG;
    }

    public void setStorageG(int storageG) {
        this.storageG = storageG;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void accessParentProps() {
        System.out.println("父类里的name属性：" + super.name);
    }

    /**
     * 调用super父类的方法
     */
    public void useSuper() {
        super.describe();
        super.buy(66);
        System.out.println("父类里的count属性：" + super.count);
    }
}
