package week4.a1.shopping;

import week4.a1.shopping.impl.SimpleShopman;
import week4.a1.shopping.interfaces.*;

import static week4.a1.shopping.util.ShoppingUtil.*;

public class ShoppingAppMain {
    public static void main(String[] args) {
        SuperMarket superMarket = createSuperMarket();

        Shopman shopman = new SimpleShopman(superMarket);

        boolean open = true;
        while (open) {
            new ShoppingTask(shopman).executeTask();
            output("是否继续营业？(Yes)");
            open = ! input().next().trim().equalsIgnoreCase("no");
        }

        superMarket.dailyReport();
    }

}

class ShoppingTask {

    private Shopman shopman;

    public ShoppingTask(Shopman shopman) {
        this.shopman = shopman;
    }

    public void executeTask() {
//        Customer customer = createCustomer(true);
        Customer customer = createCustomer(false);

        shopman.serveCustomer(customer);

    }

}
