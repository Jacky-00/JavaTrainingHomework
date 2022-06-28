package week4.a1.shopping.impl;

import week4.a1.shopping.interfaces.*;

public class CashCardCustomer extends SuiYuanCustomer implements HasCard {

    private Card card;

    public CashCardCustomer(String custId, Category shouldBuy) {
        super(custId, shouldBuy);
        card = new CashCard(500);
    }

    @Override
    public int buyMerchandise(Merchandise merchandise) {
        Category category = merchandise.getCategory();
        // 需要买的就买一个
        if (category == getShouldBuy()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Card getCard() {
        return card;
    }
}
