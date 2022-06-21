package week3;

import com.supermarket.Phone;

public class UsePhoneExtendsMerchandise {
    public static void main(String[] args) {
        Phone phone = new Phone(
                "myPhone",
                "phone001",
                100,
                1999,
                999,
                4.5,
                3.5,
                6,
                128,
                "Sony",
                "Android"
        );
        phone.describe();
        System.out.println(phone.getName());
        phone.buy(10);
        phone.buy(2);
        phone.accessParentProps();
        phone.useSuper();
    }
}
