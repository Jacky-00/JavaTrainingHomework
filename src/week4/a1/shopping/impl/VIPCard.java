package week4.a1.shopping.impl;

import week4.a1.shopping.interfaces.*;

public enum VIPCard implements Card {
    Level0(1),
    Level1(0.99),
    Level2(0.95),
    Level3(0.9),
    Level4(0.85),
    Level5(0.8);

    private double discount;

    VIPCard(double discount) {
        this.discount = discount;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, ShoppingCart shoppingCart) {
        return totalCostAfterDiscount * (1 - discount);
    }
}
