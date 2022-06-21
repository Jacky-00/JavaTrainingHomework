package com.supermarket.chip;

import com.supermarket.Merchandise;

public abstract class Chip extends Merchandise {
    protected boolean isTested;
    protected boolean[] isWorked;
    protected double yield;


    public Chip(String name, String id, int count, double soldPrice, double purchasePrice) {
        super(name, id, count, soldPrice, purchasePrice);
        this.isTested = false;
    }

    public Chip() {
        super();
        this.isTested = false;
    }

    @Override
    public void describe() {
        super.describe();
        if (isTested) {
            System.out.format("经过测试，此芯片良率%.2f%%\n", yield * 100);
        } else {
            System.out.println("此芯片还未测试");
        }
    }

    /**
     * 运行芯片测试
     */
    public abstract void runChipTest();
}
