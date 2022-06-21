package com.supermarket;

import java.util.Date;


public class GamePointCard extends Merchandise implements ExpireDateMerchandise {
    private Date produceDate;
    private Date expirationDate;


    public GamePointCard(String name, String id, int count, double soldPrice, double purchasePrice, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("剩余保质期："+(leftDatePercentage()*100)+"%");
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
        return super.getSoldPrice();
    }


}